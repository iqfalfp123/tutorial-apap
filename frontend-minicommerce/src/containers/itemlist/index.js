import React, { Component } from "react";
import Item from "../../components/item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
import { Badge } from '@mui/material';
import Fab from '@mui/material/Fab';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import PointOfSaleIcon from '@mui/icons-material/PointOfSale';
import Cart from "../../components/cart";

class ItemList extends Component {
    constructor(props) {
    super(props);
    this.state = {
        items: [],
        copyItems: [],
        cartItems: [],
        jumlah: 0,
            isLoading: false,
            isCreate: false,
            isEdit: false,
            isSearch: false,
            cartHidden: true,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            jumlah:0
            };
            this.handleAddItem = this.handleAddItem.bind(this);
            this.handleClickLoading = this.handleClickLoading.bind(this);
            this.handleChangeField = this.handleChangeField.bind(this);    
            this.handleSubmitItem = this.handleSubmitItem.bind(this);
            this.handleCancel = this.handleCancel.bind(this);
            this.handleEditItem = this.handleEditItem.bind(this);
            this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
            this.handleSearch = this.handleSearch.bind(this);
            this.handleCheckout = this.handleCheckout.bind(this);
        }
    async handleAddItemToCart(item){
        if(item.quantity >= this.state.jumlah) {
            try {
                const data = {
                quantity: this.state.jumlah,
                idItem: item.id,
                };
                await APIConfig.post("/cart", data);
            }catch (error) {
                alert("Oops terjadi masalah pada server");
                console.log(error);
            }
            this.loadDataCart();
        }else {
            alert("Jumlah stok tidak mencukupi");
        }
    }
    async handleCheckout(item){
        // const list = [];
            try {
                await APIConfig.get("/cart/checkout");
            }catch (error) {
                alert("Oops terjadi masalah pada server");
                console.log(error);
            }
            this.loadDataCart();
            // this.setState({cartItems:list})
            // this.handleDeleteItem(item);
    }
    handleEditItem(item) {
        this.setState({
        isEdit: true,
        id: item.id,
        title: item.title,
        price: item.price,
        description: item.description,
        category: item.category,
        quantity: item.quantity
        })
        }

    handleAddItem() {
        this.setState({ isCreate:true });
        }
    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate:false, isEdit: false });
        }
    componentDidMount() {
        console.log("componentDidMount()");
        this.loadData()
            }
    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
            }
    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    } 
    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({[name]: value});
        }
    async handleSearch(item){
        var find = item.target.value;
        const list = this.state.items;
        const newList = [];
        // const result = list.some(element => );
        list.forEach(function(element){
            if(element.title.includes(find)) {
                newList.push(element);
            }
        });
        this.setState({copyItems: newList});
        this.setState({isSearch: true});
    }
    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
} 
    async loadDataCart() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ cartItems: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
} 
    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
            title: this.state.title,
            price: this.state.price,
            description: this.state.description,
            category: this.state.category,
            quantity: this.state.quantity
            };
            
        await APIConfig.post("/item", data);
        this.setState({
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0
            })
        this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
        }
        async handleSubmitEditItem(event) {
            event.preventDefault();
            try {
                const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
                })
            this.loadData();
            } catch (error) {
                alert("Oops terjadi masalah pada server");
                console.log(error);
            }
            this.handleCancel(event);
            }
        handleToggle = () => {
            const cartHidden = this.state.cartHidden;
            this.setState({ cartHidden: !cartHidden });
    }

render() {
    return (
        <div className={classes.itemList}>
        <div style={{ position: "fixed", top:15, right: 25}}>
        <Fab variant="extended" onClick={this.handleToggle}>
        {this.state.cartHidden ?(
        <Badge  color="secondary" badgeContent={this.state.cartItems.length}>
            <ShoppingCartIcon></ShoppingCartIcon>
        </Badge>
         ): <a>BACK</a>
            }
        </Fab>
        </div>
        {!this.state.cartHidden ? (
            <div className="col-sm">
                <Cart
                    title="My Cart"
                    items={this.state.cartItems}
                    onItemClick={this.handleCheckout}
                    isCartHidden = {this.state.cartHidden}
                    // handleCart={() => this.handleAddItemToCart(item)}
                ></Cart>
            </div>):
        <div className="col-sm">
        <h1 className={classes.title}>All Items</h1>
        <Button action={this.handleAddItem}>
            Add Item
        </Button>
         <form>
            <input
            type="text"
            placeholder="cari berdasarkan nama.."
            name="search"
            onKeyUp={this.handleSearch}
            /></form>
        
        <div>
        {this.state.isSearch && this.state.copyItems.map((item) => (
            <Item
            key={item.id}
            id={item.id}
            title={item.title}
            price={item.price}
            description={item.description}
            category={item.category}
            quantity={item.quantity}
            handleEdit={() => this.handleEditItem(item)}
            handleCart={() => this.handleAddItemToCart(item)}
            handleChange= {this.handleChangeField}
            isCartHidden = {this.state.cartHidden}
            />
        ))}
        {!this.state.isSearch && this.state.items.map((item) => (
            <Item
            key={item.id}
            id={item.id}
            title={item.title}
            price={item.price}
            description={item.description}
            category={item.category}
            quantity={item.quantity}
            handleEdit={() => this.handleEditItem(item)}
            handleCart={() => this.handleAddItemToCart(item)}
            handleChange ={this.handleChangeField}
            isCartHidden = {this.state.cartHidden}
            />
        ))}
        </div>
        </div>
        }
        <Modal
        show={this.state.isCreate || this.state.isEdit}
        handleCloseModal={this.handleCancel}
        modalTitle={this.state.isCreate?"Add Item" : `Edit Item ID ${this.state.id}`}
        > 
        <form>
            <input className={classes.textField}
            type="text"
            placeholder="Nama Item"
            name="title"
            value={this.state.title}
            onChange={this.handleChangeField}
            />
            <input className={classes.textField}
            type="number"
            placeholder="Harga"
            name="price"
            value={this.state.price}
            onChange={this.handleChangeField}
            />
            <textarea className={classes.textField}
            placeholder="Deskripsi"
            name="description"
            rows="4"
            value={this.state.description}
            onChange={this.handleChangeField}
            />
            <input className={classes.textField}
            type="text"
            placeholder="Kategori"
            name="category"
            value={this.state.category}
            onChange={this.handleChangeField}            
            />
            <input className={classes.textField}
            type="number"
            placeholder="qty"
            name="quantity"
            value={this.state.quantity}
            onChange={this.handleChangeField}
            />         
        <Button action={this.state.isCreate ? this.handleSubmitItem : this.handleSubmitEditItem}>
            Create
        </Button>

        <Button action={this.handleCancel}>
        Kembali
        </Button>
         </form>
         </Modal>
        </div>
    );
    }
    }
export default ItemList;
