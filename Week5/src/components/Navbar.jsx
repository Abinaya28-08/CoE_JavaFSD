// src/components/Navbar.jsx
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="bg-blue-500 p-4 text-white flex justify-between items-center">
      {/* Left Side: Logo and ShopNow Branding */}
      <div className="flex items-center space-x-2">
        <img 
          src="/images/logo.png" 
          alt="ShopNow Logo" 
          className="w-10 h-10 rounded-full" 
        />
        <span className="text-xl font-bold">ShopNow</span>
      </div>
      {/* Right Side: Navigation Links */}
      <div className="flex space-x-4">
        <Link 
          to="/" 
          className="hover:underline transition-transform transform hover:scale-105"
        >
          Home
        </Link>
        <Link 
          to="/products" 
          className="hover:underline transition-transform transform hover:scale-105"
        >
          Products
        </Link>
        <Link 
          to="/cart" 
          className="hover:underline transition-transform transform hover:scale-105"
        >
          Cart
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
