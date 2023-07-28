import React, { useState } from 'react';
import AddBook from './components/AddBook';
import BookList from './components/BookList';

const App = () => {
  const [books, setBooks] = useState([]);

  const handleAddBook = (newBook) => {
    setBooks([...books, newBook]);
  };

  return (
    <div>
      <AddBook onAddBook={handleAddBook} />
      <BookList books={books} />
    </div>
  );
};

export default App;
