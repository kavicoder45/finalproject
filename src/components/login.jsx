import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "../App.css";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  async function login(event) {
    event.preventDefault();
    try {
      await axios
        .post("http://localhost:8085/api/v1/employee/login", {
          email: email,
          password: password,
        })
        .then(
          (res) => {
            console.log(res.data);

            if (res.data.message == "Email not exits") {
              alert("Email not exits");
            } else if (res.data.message == "Login Success") {
              navigate("/veglist");
            } else {
              alert("Incorrect Email and Password not match");
            }
          },
          (fail) => {
            console.error(fail); // Error!
          }
        );
    } catch (err) {
      alert(err);
    }
  }

  return (
    <div className="container">
      <div class="container-center">
        <div class="title">
          <h1>welcome</h1>
          <p>sign in to continue</p>
        </div>
        <form className="form">
          <div class="form-group">
            <label>Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              placeholder="eg:akavi846@gmail.com"
              value={email}
              onChange={(event) => {
                setEmail(event.target.value);
              }}
            />
          </div>

          <div class="form-group">
            <label>password</label>
            <input
              type="password"
              class="form-control"
              id="password"
              placeholder="***********"
              value={password}
              onChange={(event) => {
                setPassword(event.target.value);
              }}
            />
          </div>
          <button type="submit" class="btn btn-primary" onClick={login}>
            Login
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;
