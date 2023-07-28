import React from 'react';

const BookList = ({ books }) => {
  if (books.length === 0) {
    return <p>No books available.</p>;
  }

  return (
    <div>
      <h2>Book List</h2>
      <table>
        <thead>
          <tr>
            <th>ISBN Number</th>
            <th>Book Name</th>
            <th>Author</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {books.map((book, index) => (
            <tr key={index}>
              <td>{book.isbn}</td>
              <td>{book.name}</td>
              <td>{book.author}</td>
              <td>{book.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default BookList;
