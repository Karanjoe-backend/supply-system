import axios from 'axios';
import { captureOwnerStack } from 'react';

const API = axios.create({
    baseURL : 'http://localhost:8080/api/v1',
    headers :{
        'Content-Type' : 'application/json',
    }
});

export const addOrUpdateStock = (hubId, productId, quantity ) => 
            API.post(`/hubs/${hubId}/products/${productId}/stock`, null, { 
                params: { quantity } });
            
export const placeOrder = (orderData) => 
            API.post('/orders', orderData);

export const getCustomerOrders = (customerId) => 
            API.get(`/customers/${customerId}/orders`);