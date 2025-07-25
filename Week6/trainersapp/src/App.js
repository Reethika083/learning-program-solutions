// src/App.js
import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainerList from "./TrainerList";
import TrainerDetails from "./TrainerDetails";

function App() {
  return (
    <Router>
      <div>
        <h1>Cognizant Academy - Trainers App</h1>
        <nav>
          <Link to="/">Home</Link> | <Link to="/trainers">Trainer List</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainerList />} />
          <Route path="/trainers/:id" element={<TrainerDetails />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
