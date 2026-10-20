import React, { useState } from 'react';
import { placeOrder } from '../services/api';

export default function CheckOut() {
  const [customerId, setCustomerId] = useState(1);
  const [hubId, setHubId] = useState(1);
  const [productId, setProductId] = useState(1);
  const [quantity, setQuantity] = useState(2);
  const [unitPrice, setUnitPrice] = useState(45.0);
  const [orderResponse, setOrderResponse] = useState(null);
  const [error, setError] = useState('');

  const handleCheckout = async (e) => {
    e.preventDefault();
    setError('');
    setOrderResponse(null);

    const payload = {
      customerId: Number(customerId),
      hubId: Number(hubId),
      items: [
        {
          productId: Number(productId),
          quantity: Number(quantity),
          unitPrice: Number(unitPrice),
        },
      ],
    };

    try {
      const res = await placeOrder(payload);
      setOrderResponse(res.data);
    } catch (err) {
      setError(err.response?.data || err.message);
    }
  };

  return (
    <section>
      <h2>2. Place Order (Checkout)</h2>

      <form onSubmit={handleCheckout}>
        <label>
          Customer ID
          <input
            type="number"
            value={customerId}
            onChange={(e) => setCustomerId(e.target.value)}
            min="1"
            required
          />
        </label>

        <label>
          Hub ID
          <input
            type="number"
            value={hubId}
            onChange={(e) => setHubId(e.target.value)}
            min="1"
            required
          />
        </label>

        <label>
          Product ID
          <input
            type="number"
            value={productId}
            onChange={(e) => setProductId(e.target.value)}
            min="1"
            required
          />
        </label>

        <label>
          Quantity
          <input
            type="number"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
            min="1"
            required
          />
        </label>

        <label>
          Unit Price
          <input
            type="number"
            value={unitPrice}
            onChange={(e) => setUnitPrice(e.target.value)}
            min="0"
            step="0.01"
            required
          />
        </label>

        <button type="submit">Place Order</button>
      </form>

      {orderResponse && (
        <p>
          Order placed successfully! Order ID:{' '}
          <strong>{orderResponse.orderId}</strong>
        </p>
      )}

      {error && <p role="alert">{String(error)}</p>}
    </section>
  );
}