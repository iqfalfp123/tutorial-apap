import React from "react";
import Item from "../item";
import { Badge } from '@mui/material';
import Fab from '@mui/material/Fab';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import PointOfSaleIcon from '@mui/icons-material/PointOfSale';
import Cart from "../../components/cart";

export default function cart({ title, items, onItemClick, isCartHidden}) {
    return (
        <>
        <h3 style={StyleSheet.heading}>{title}</h3>
        <div className="list-group">
            {items.length === 0 ? (
                <div className="text-center">
                    <h1>Belum ada item yang dipilih</h1>
                    <h3>Klik salah satu item di List Item</h3>
                </div>
            ):          
            <button onClick={onItemClick}>
             <PointOfSaleIcon></PointOfSaleIcon>
             CHECKOUT
             </button>}
            {items.map((item) => (
                <Item
                    key={item.id}
                    id={item.id}
                    title={item.item.title}
                    price={item.item.price}
                    description={item.item.description}
                    category={item.item.category}
                    quantity={item.item.quantity}
                    jumlah={item.quantity}
                    handleEdit={() => this.handleEditItem(item)}
                    handleCart={() => this.handleAddItemToCart(item)}
                    isCartHidden = {isCartHidden}
                    onItemClick ={onItemClick}
                    />
            ))}
        </div>
        </>
    );
}