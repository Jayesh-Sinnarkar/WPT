import React, { useState } from 'react';
import AddFood from './components/AddFood';
import FoodList from './components/FoodList';


const App = () => {
  const [foods, setFoods] = useState([]);

  const addFood = (newFood) => {
    setFoods([...foods, newFood]);
  };

  return (
    <div className='container'>
      <AddFood addFood={addFood} />
      <FoodList foodList={foods} />
    </div>
  );
};

export default App