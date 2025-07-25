// src/OnlineShopping.js
import React from "react";
import Cart from "./Cart";

class OnlineShopping extends React.Component {
  constructor() {
    super();
    this.items = [
      { itemname: "Laptop", price: 60000 },
      { itemname: "Smartphone", price: 20000 },
      { itemname: "Earbuds", price: 2500 },
      { itemname: "Keyboard", price: 1500 },
      { itemname: "Mouse", price: 800 }
    ];
  }

  render() {
    return (
      <div>
        <h1>Welcome to Online Shopping</h1>
        {this.items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
