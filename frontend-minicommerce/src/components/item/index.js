import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
const Item = (props) => {
const { id, title, price, description, category, quantity, jumlah, handleEdit, handleCart, isCartHidden, handleChange, value, onItemClick} = props;
const total = jumlah * price;
return (
    <div className={classes.item}>
    {isCartHidden ? (
    <div>
    <h3>{`ID ${id}`}</h3>
    <p>{`Nama Barang: ${title}`}</p>
    <p>{`Harga: ${price}`}</p>
    <p>{`Deskripsi: ${description}`}</p>
    <p>{`Kategori: ${category}`}</p>
    <p>{`stok: ${quantity}`}</p>

    <Button action={handleEdit}>
        Edit
    </Button>     
    <input className={classes.textField}
            type="number"
            placeholder="jumlah kuantitas"
            name="jumlah"
            value={value}
            onChange={handleChange}
            />
    <Button action={handleCart}>
        Add To Cart
    </Button> 
    </div>
    ): 
    <div>
    <h2>{`ID Cart ${id}`}</h2>
    <p>{`Nama Barang: ${title}`}</p>
    <p>{`Harga: ${price}`}</p>
    <p>{`jumlah: ${jumlah}`}</p>
    <p>{`Deskripsi: ${description}`}</p>
    <p>{`Kategori: ${category}`}</p>
    <p >{`Total Harga: ${total}`}</p>
    </div>
    } 
    </div>
);
};
export default Item;
