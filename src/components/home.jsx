import React, { useState, useEffect } from "react";
import "../index.css";
function Home() {
  const [customerData, setCustomerData] = useState([]);

  useEffect(() => {
    // Fetch data from the API endpoint
    fetch("http://localhost:8084/customer")
      .then((response) => response.json())
      .then((data) => {
        setCustomerData(data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  return (
    <div className="App">
      <h1>Customer Data</h1>
      <table>
        <thead>
          <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Mobile No</th>
          </tr>
        </thead>
        <tbody>
          {customerData.map((customer) => (
            <tr key={customer.customerId}>
              <td>{customer.customerId}</td>
              <td>{customer.customerName}</td>
              <td>{customer.customerMobileNo}</td>
            </tr>
          ))}
        </tbody>
      </table>
      {/* card-center-div */}

      <div className="card-center">
        <div className="single-card singel-card-1">
          <h2>Fruits</h2>
          <div className="cards-container">
            {customerData.map((customer) => (
              <div key={customer.customerId} className="card">
                <h4>{customer.customerName}</h4>
                <ul>
                  {customer.fruits.map((fruit) => (
                    <li key={fruit.fruitId}>
                      <strong>Fruit Name:</strong>
                      <p className="small-text">{fruit.fruitName}</p>
                    </li>
                  ))}
                </ul>
              </div>
            ))}
          </div>
        </div>

        {/* second card */}

        <div className="single-card-2 single-card">
          <h2>Vegetables</h2>
          <div className="cards-container">
            {customerData.map((customer) => (
              <div key={customer.customerId} className="card">
                <h4>{customer.customerName}</h4>
                <ul>
                  {customer.vegetables.map((vegetable) => (
                    <li key={vegetable.vegId}>
                      <strong>Vegetable Name:</strong> {vegetable.vegName}
                    </li>
                  ))}
                </ul>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
