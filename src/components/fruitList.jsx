import React, { useEffect, useState } from "react";
import axios from "axios";
import "../card.css";
import appleImg from "../assets/apple.jpg";
import bananaImg from "../assets/banana.jpg";
import mangoImg from "../assets/mango.jpg";
import orangeImg from "../assets/orange.jpg";
import pineappleImg from "../assets/pineapple.jpg";
import strawberryImg from "../assets/strawberry.jpg";
import watermelonImg from "../assets/watermelon.jpg";
import lemonImg from "../assets/lemon.jpg";
import defaultImg from "../assets/default.jpg";
import cherryImg from "../assets/cherry.jpg";
import kiwiImg from "../assets/kiwi.jpg";
import grapesImg from "../assets/grapes.jpg";

const FruitsList = () => {
  const [fruits, setFruits] = useState([]);

  useEffect(() => {
    // Make a GET request to fetch all fruits from your backend API
    axios
      .get("http://localhost:8082/api/fruits")
      .then((response) => {
        setFruits(response.data);
      })
      .catch((error) => {
        console.error("Error fetching fruits:", error);
      });
  }, []);

  const getFruitImage = (fruitName) => {
    switch (fruitName.toLowerCase()) {
      case "apple":
        return appleImg;
      case "banana":
        return bananaImg;
      case "orange":
        return orangeImg;
      case "strawberry":
        return strawberryImg;
      case "pineapple":
        return pineappleImg;
      case "mango":
        return mangoImg;
      case "watermelon":
        return watermelonImg;
      case "lemon":
        return lemonImg;
      case "cherry":
        return cherryImg;
      case "grapes":
        return grapesImg;
      case "kiwi":
        return kiwiImg;
      // Add cases for other fruits as needed
      default:
        return defaultImg; // Provide a default image or an empty string
    }
  };

  return (
    <div className="image-section">
      <div className="wrapper">
        <header className="header">
          <h2 className="logo">OrganicStore</h2>

          <nav className="nav-links">
            <ul>
              <li>
                <a href="#">home</a>
              </li>
              <li>
                <a href="#">contact</a>
              </li>
              <li>
                <a href="#">about</a>
              </li>
              <li>
                <a href="#">product</a>
              </li>
            </ul>
          </nav>
        </header>
      </div>
      <section className="image-section-center">
        <h2>Fruits List</h2>
        <div className="fruit-cards">
          {fruits.map((fruit) => (
            <div className="fruit-card" key={fruit.id}>
              <div className="img-container">
                <img
                  src={getFruitImage(fruit.fruitName)}
                  alt={fruit.fruitName}
                  className="fruit-image"
                />
              </div>
              <div className="card-content">
                <h3>{fruit.fruitName}</h3>
                <p>Quantity: {fruit.quantity}</p>
                <p>Price: {fruit.price}</p>
                <p>Description: {fruit.description}</p>
              </div>
            </div>
          ))}
        </div>
      </section>
      <footer className="footer">
        <p>All Copyrights Reserved</p>
      </footer>
    </div>
  );
};

export default FruitsList;
