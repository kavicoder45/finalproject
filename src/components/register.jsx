import { useState } from "react";
import axios from "axios";

function Register() {
  const [employeeName, setEmployeeName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function save(event) {
    event.prevantDefault();

    try {
      await axios.post("http://localhost:8085/api/v1/employee/save", {
        employeeName: employeeName,
        email: email,
        password: password,
      });
      alert("Employee Registration Succesfully");
    } catch (err) {
      alert(err);
    }
  }

  return (
    <div>
      <div className="container trans-container">
        <div className="card">
          <div className="main-title">
            <h2>Registration Form</h2>
            <div className="line"></div>
          </div>
          <form className="form-container">
            <div className="form-group">
              <label htmlFor="employeename">Name</label>
              <input
                type="text"
                id="employeename"
                placeholder="Enter your name"
                className="form-control"
                value={employeeName}
                onChange={(event) => {
                  setEmployeeName(event.target.value);
                }}
              />
            </div>
            {/* email form elment */}
            <div className="form-group">
              <label htmlFor="employeeemail">Email</label>
              <input
                type="email"
                id="employeeemail"
                placeholder="Enter your email"
                className="form-control"
                value={email}
                onChange={(event) => {
                  setEmail(event.target.value);
                }}
              />
            </div>
            {/* password */}
            <div className="form-group">
              <label htmlFor="password">password:</label>
              <input
                type="text"
                name="text"
                id="password"
                placeholder="Enter your password"
                className="form-control"
                value={password}
                onChange={(event) => {
                  setPassword(event.target.value);
                }}
              />
            </div>

            <button type="Submit" className="btn btn-primary mt-4">
              Register
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
export default Register;
