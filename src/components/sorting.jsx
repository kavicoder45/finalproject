// src/components/SortList.js

import React, { useState, useEffect } from "react";
import axios from "axios";
import "../sort.css";

function SortList() {
  const [fruits, setFruits] = useState([]);
  const [sortField, setSortField] = useState("fruitName"); // Default sorting field
  const [cart, setCart] = useState([]);
  const [totalCost, setTotalCost] = useState(0);

  useEffect(() => {
    // Fetch the list of fruits with sorting from your Spring Boot API
    axios
      .get(`http://localhost:8082/api/fruits/sorted/${sortField}`)
      .then((response) => {
        setFruits(response.data);
      })
      .catch((error) => {
        console.error("Error fetching fruits:", error);
      });
  }, [sortField]);

  const handleSortChange = (newSortField) => {
    setSortField(newSortField);
  };

  const addToCart = (fruit) => {
    // Check if the fruit is already in the cart
    const isFruitInCart = cart.find((item) => item.id === fruit.id);

    if (!isFruitInCart) {
      // If not, add it to the cart
      setCart([...cart, fruit]);
      // Update the total cost
      setTotalCost(totalCost + fruit.price);
    }
  };

  const removeFromCart = (fruit) => {
    // Remove the fruit from the cart
    const updatedCart = cart.filter((item) => item.id !== fruit.id);
    setCart(updatedCart);
    // Update the total cost
    setTotalCost(totalCost - fruit.price);
  };

  return (
    <div className="parent">
      <section className="first-child">
        {/* sort by button */}
        <div className="column-1">
          <label>Sort by:</label>
          <select onChange={(e) => handleSortChange(e.target.value)}>
            <option value="fruitName">Name</option>
            <option value="price">Price</option>
            {/* Add more sorting options here */}
          </select>
          <div>Total Cost: ${totalCost}</div>
        </div>

        <ul className="column-2">
          {fruits.map((fruit) => (
            <li key={fruit.id} className="list">
              {fruit.fruitName} - {fruit.price}
              <button onClick={() => addToCart(fruit)} className="button">
                Add to Cart
              </button>
            </li>
          ))}
        </ul>
        <ul>
          <h3>bucke List</h3>
          {cart.map((cartItem) => (
            <li key={cartItem.id} className="remove">
              {cartItem.fruitName} - {cartItem.price}
              <button
                onClick={() => removeFromCart(cartItem)}
                className="button"
              >
                Remove
              </button>
            </li>
          ))}
        </ul>
      </section>
    </div>
  );
}

export default SortList;
