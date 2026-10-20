import React, { useState } from 'react';
import { addOrUpdateStock } from '../services/api';

export default function StockUpdate(){
    const[hubId, setHubId] = useState(1);
    const[productId, setProductId] = useState(1);
    const[quantity, setQuantity] = useState(50);
    const[status, setStatus] = useState(' ');

    const handleSubmit = async (e) => {
        e.preventDefault();
        setStatus(' ');
        try{
            const response = await addOrUpdateStock(hubId, productId, quantity);
            setStatus(`Stock Updated Successfully at the product ID: ${productId} stored in hub ID: ${hubId} `);
        }
        catch(err){
                setStatus(`Error: ${err.response?.data || err.message}`);
        }

}



return(
    <div style={{ border: '1px solid black', padding: '12px', borderRadius:'8px', }}>
        <h3>Stock Replinishment</h3>
        <form onSubmit={handleSubmit}>
        <div >
                <label>Hub ID:</label>
                <input type='number' value={hubId} onChange={(e) => setHubId(e.target.value)} required />
            
        </div>
        <div style={{ marginTop: '10px' }}>
            
                <label>Product ID:</label>
                <input type='number' value={productId} onChange={(e) => setProductId(e.target.value)} required/>
            
        </div>
        <div style={{ marginTop: '10px' }}>
            
                <label>Quantity</label>
                <input type='number' value={quantity} onChange={(e) => setQuantity(e.target.value)} required/>
           
        </div>

        <button type='submit' style={{ marginTop: '10px' }}> Update Stock </button>
         </form>
         
        {status && <p style={{ color: 'green', marginTop: '10px', fontWeight: 'bold' }}>{status}</p>}
        
        
    </div>
)
};