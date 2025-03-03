// src/components/ProductCard.jsx
import { useCart } from "../context/CartContext";
import { toast } from 'react-toastify';

const ProductCard = ({ product }) => {
  const { dispatch } = useCart();

  const addToCart = () => {
    dispatch({ type: "ADD_TO_CART", payload: product });
    toast.success(`${product.name} added to cart!`, {
      position: "top-right",
      autoClose: 2000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
    });
  };

  return (
    <div className="border p-4 rounded-lg shadow-lg bg-white hover:bg-gray-100 hover:shadow-2xl transition duration-300">
      <img
        src={product.image}
        alt={product.name}
        className="w-full h-40 object-contain rounded"
      />
      <h2 className="text-xl font-semibold mt-2">{product.name}</h2>
      <p className="text-gray-700">${product.price.toFixed(2)}</p>
      <button
        className="mt-2 bg-orange-500 text-white px-4 py-2 rounded hover:bg-orange-600 transition-colors"
        onClick={addToCart}
      >
        Add to Cart
      </button>
    </div>
  );
};

export default ProductCard;
