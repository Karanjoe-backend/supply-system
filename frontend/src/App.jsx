import React from 'react';
import StockUpdate from './components/StockUpdate';
import CheckOut from './components/CheckOut';

function App() {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', marginTop: '20px' }}> 
      <h2>HD Supply Chain Management Portal</h2> 
      <StockUpdate />
      <CheckOut />
    </div>
  );
}

export default App;