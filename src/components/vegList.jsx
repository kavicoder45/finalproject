import React, { useState, useEffect } from "react";
import axios from "axios";
import carrotImg from "../assets/carrot.jpg";
import cucumberImg from "../assets/cucumber.jpg";
import bellpepperImg from "../assets/bellpepper.jpg";
import broccoliImg from "../assets/broccoli.jpg";
import lettuceImg from "../assets/lettuce.jpg";
import mushroomImg from "../assets/mushroom.jpg";
import onionImg from "../assets/onion.jpg";
import spinachImg from "../assets/spinach.jpg";
import tomatoImg from "../assets/tomato.jpg";
import zucchiniImg from "../assets/zucchini.jpg";
import potatoImg from "../assets/potato.jpg";
import defaultImg from "../assets/default.jpg";

const VegetablesList = () => {
  const [vegetables, setVegetables] = useState([]);

  useEffect(() => {
    // Fetch vegetable data from your Spring Boot backend
    axios
      .get("http://localhost:8082/api/vegetables")
      .then((response) => {
        setVegetables(response.data);
      })
      .catch((error) => {
        console.error("Error fetching vegetables:", error);
      });
  }, []);

  const getVegImage = (vegetableName) => {
    switch (vegetableName.toLowerCase()) {
      case "carrot":
        return carrotImg;
      case "cucumber":
        return cucumberImg;
      case "onion":
        return onionImg;
      case "potato":
        return potatoImg;
      case "mushroom":
        return mushroomImg;
      case "lettuce":
        return lettuceImg;
      case "zucchini":
        return zucchiniImg;
      case "spinach":
        return spinachImg;
      case "bellpeper":
        return bellpepperImg;
      case "broccli":
        return broccoliImg;
      case "tomato":
        return tomatoImg;
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
        <h2>vegetable List</h2>
        <div className="fruit-cards">
          {vegetables.map((fruit) => (
            <div className="fruit-card" key={fruit.id}>
              <div className="img-container">
                <img
                  src={getVegImage(fruit.vegetableName)}
                  alt={vegetables.vegetableName}
                  className="fruit-image"
                />
              </div>
              <div className="card-content">
                <h3>{fruit.vegetableName}</h3>
                <p>Quantity: {fruit.quantity}</p>
                <p>Price: {fruit.price}</p>
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

export default VegetablesList;
