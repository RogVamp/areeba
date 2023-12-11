import AddCustomerComponent from "./components/AddCustomerComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListCustomerComponent from "./components/ListCustomersComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <BrowserRouter>
        <HeaderComponent/>
        <div className="container">
          <Routes>
            <Route path="/" element={<ListCustomerComponent/>} />
            <Route path="/customer" element={<ListCustomerComponent/>} />
            <Route path="/add-customer" element={<AddCustomerComponent/>} />
            <Route path="/add-customer/:id" element={<AddCustomerComponent/>} />
          </Routes>
        </div>
        <FooterComponent/>
      </BrowserRouter>
    </div>
  );
}

export default App;
