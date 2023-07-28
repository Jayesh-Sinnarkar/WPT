// index.js
const express = require('express');
const methodOverride = require('method-override');
const path = require('path'); // Import the path module
const app = express();
const port = 3000;

app.set('view engine', 'ejs');
app.set('views', path.join(process.cwd(), 'src', 'views')); // Set the correct views directory path

app.use(express.urlencoded({ extended: true }));
app.use(methodOverride('_method'));

// In-memory list to store employee details
let employees = [];
let idCounter = 1;

// Route to render the index.ejs template
app.get('/employees', (req, res) => {
  res.render('index', { employees });
});

// Route to handle form submission and add an employee
app.post('/employees', (req, res) => {
  const { name, position } = req.body;
  const employee = { id: idCounter++, name, position };
  employees.push(employee);
  res.redirect('/employees');
});

// Route to render the edit.ejs template with the selected employee details
app.get('/employees/:id/edit', (req, res) => {
  const employeeId = parseInt(req.params.id);
  const employee = employees.find(emp => emp.id === employeeId);
  if (employee) {
    res.render('edit', { employee });
  } else {
    res.status(404).send('Employee not found');
  }
});

// Route to handle form submission and update an employee
app.put('/employees/:id', (req, res) => {
  const employeeId = parseInt(req.params.id);
  const { name, position } = req.body;
  const index = employees.findIndex(emp => emp.id === employeeId);
  if (index !== -1) {
    employees[index] = { id: employeeId, name, position };
    res.redirect('/employees');
  } else {
    res.status(404).send('Employee not found');
  }
});

// Route to delete an employee
app.delete('/employees/:id', (req, res) => {
  const employeeId = parseInt(req.params.id);
  employees = employees.filter(emp => emp.id !== employeeId);
  res.redirect('/employees');
});

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});
