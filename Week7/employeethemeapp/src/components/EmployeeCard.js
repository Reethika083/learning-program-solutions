import React, { useContext } from 'react';
import ThemeContext from '../ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  const buttonClass = theme === 'light' ? 'lightButton' : 'darkButton';

  return (
    <div className="card">
      <h3>{employee.name}</h3>
      <p>{employee.position}</p>
      <button className={buttonClass}>View Profile</button>
    </div>
  );
}

export default EmployeeCard;
