// src/pages/Products.jsx
import React from 'react';
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
    image: "/images/oneplus 10 pro.jpg",
  },
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

const Products = () => {
  return (
    <div className="p-8 bg-white">
      <h2 className="text-3xl font-bold mb-6 text-center">Products</h2>
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-6">
        {products.map(product => (
          <ProductCard key={product.id} product={product} />
        ))}
      </div>
    </div>
  );
};

export default Products;
