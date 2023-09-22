import { BrowserRouter, Routes, Route } from "react-router-dom";
import Register from "./components/register";
import Login from "./components/login";
import Home from "./components/home";
import FruitsList from "./components/fruitList";
import VegetablesList from "./components/vegList";
import SortList from "./components/sorting";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/" element={<Login />} />
          <Route path="/fruitlist" element={<FruitsList />} />
          <Route path="/veglist" element={<VegetablesList />} />
          <Route path="/sorting" element={<SortList />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
