import React from 'react';

const FoodList = ({ foodList }) => {
  return (
    <div className='my-2'>
      <h2>Food List</h2>
      {/* Displaying Currently Added Menu */}
      <table className="table">
        <thead>
          <tr>
            <th>Dish Id</th>
            <th>Dish Name</th>
            <th>Dish Type</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {foodList.map((food) => (
            <tr key={food.foodId}>
              <td>{food.foodId}</td>
              <td>{food.foodName}</td>
              <td>{food.foodType}</td>
              <td>${food.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FoodList;