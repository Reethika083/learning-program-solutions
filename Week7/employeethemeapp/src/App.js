import React, { useState } from 'react';
import './App.css';
import ThemeContext from './ThemeContext';
import EmployeeList from './components/EmployeeList';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme((prev) => (prev === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management</h1>
        <button onClick={toggleTheme}>
          Toggle Theme
        </button>
        <EmployeeList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
