// src/pages/Home.jsx
import React from 'react';
import { Link } from 'react-router-dom';
import ProductCard from "../components/ProductCard";

const products = [
  {
    id: 1,
    name: "iPhone 14 Pro",
    price: 999.99,
    image: "/images/iphone 14 pro.jpg",
  },
  {
    id: 2,
    name: "Samsung Galaxy S22",
    price: 899.99,
    image: "/images/samsung galaxy S22.jpg",
  },
  {
    id: 3,
    name: "Google Pixel 7",
    price: 799.99,
    image: "/images/google pixel 7.jpg",
  },
  {
    id: 4,
    name: "OnePlus 10 Pro",
    price: 749.99,
    image:"/images/oneplus 10 pro.jpg",
  },
  // Additional phone products for unified collection
  {
    id: 5,
    name: "iPhone 13 Mini",
    price: 850.00,
    image: "/images/iphone 13 mini.jpg",
  },
  {
    id: 6,
    name: "Redmi Note 11 Pro",
    price: 650.00,
    image: "/images/Redmi Note 11 pro.jpg",
  },
  {
    id: 7,
    name: "Xiomi 12T",
    price: 700.00,
    image: "/images/Xiaomi 12T pro.jpg",
  },
  {
    id: 8,
    name: "Galaxy Z Flip 4",
    price: 600.00,
    image: "/images/Galaxy Z Flip 4.jpg",
  },
];

const Home = () => {
  return (
    <div className="flex flex-col">
      {/* Hero Section */}
      <section className="relative bg-gradient-to-r from-blue-500 to-purple-600 h-[600px] text-white">
        {/* Hero Content: Trending Phone Details and Large Image */}
        <div className="absolute inset-0 flex flex-col md:flex-row items-center justify-center px-4">
          {/* Left: Text Content */}
          <div className="md:w-1/2 text-center md:text-left">
            <h1 className="text-4xl md:text-5xl font-extrabold mb-4">
              Trending Now: The Ultimate Smartphone
            </h1>
            <p className="text-lg md:text-xl mb-6 max-w-xl">
              Experience cutting-edge technology, unmatched camera quality, and seamless performance. This is the phone that sets the trend.
            </p>
            <Link
              to="/products"
              className="bg-yellow-400 text-dark font-semibold px-6 py-3 rounded-full hover:bg-yellow-500 transition duration-300"
            >
              Shop Now
            </Link>
          </div>
          {/* Right: Large Trending Phone Image */}
          <div className="md:w-1/2 mt-8 md:mt-0 flex justify-center">
            <img 
              src="/images/trending phone.jpg" 
              alt="Trending Phone" 
              className="w-full max-w-sm rounded-lg shadow-2xl"
            />
          </div>
        </div>
      </section>
      
      {/* Unified Phones Collection Section */}
      <section className="p-8 bg-white">
        <h2 className="text-3xl font-bold mb-6 text-center">
          Our Exclusive Phones Collection
        </h2>
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-6">
          {products.map(product => (
            <ProductCard key={product.id} product={product} />
          ))}
        </div>
      </section>
    </div>
  );
};

export default Home;
