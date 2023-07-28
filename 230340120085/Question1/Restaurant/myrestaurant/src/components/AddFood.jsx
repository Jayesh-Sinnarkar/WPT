import React, { useState } from 'react';

const AddFood = ({ addFood }) => {
  //using useState hook to manage states of food fields
  const [foodId, setFoodId] = useState('');
  const [foodName, setFoodName] = useState('');
  const [foodType, setFoodType] = useState('');
  const [price, setPrice] = useState('');

  //Handling data submit after form is submitted
  const handleSubmit = (e) => {
    e.preventDefault();
    const newFood = {
      foodId,
      foodName,
      foodType,
      price,
    };
    addFood(newFood);
    setFoodId('');
    setFoodName('');
    setFoodType('');
    setPrice('');
  };

  return (
    <div className='container my-5'>
      <h2 className='my-3'>Restaurant Menu Management:</h2>
      <form onSubmit={handleSubmit}>
        
          <label className='mx-2' htmlFor="foodId">Food Id:</label>
          <input
            type="text"
            id="foodId"
            value={foodId}
            onChange={(e) => setFoodId(e.target.value)}
            required
          />
        
      
          <label className='mx-2' htmlFor="foodName">Food Name:</label>
          <input
            type="text"
            id="foodName"
            value={foodName}
            onChange={(e) => setFoodName(e.target.value)}
            required
          />
        
       
          <label className='mx-2' htmlFor="foodType">Food Type:</label>
          <select
            id="foodType"
            value={foodType}
            onChange={(e) => setFoodType(e.target.value)}
            required
          >
            <option value="">Select</option>
            <option value="veg">Veg</option>
            <option value="non-veg">Non-Veg</option>
          </select>
        
       
          <label className='mx-2' htmlFor="price">Price:</label>
          <input
            type="text"
            id="price"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            required
          />
        
        <button type="submit">Add Food</button>
      </form>
    </div>
  );
};

export default AddFood;









