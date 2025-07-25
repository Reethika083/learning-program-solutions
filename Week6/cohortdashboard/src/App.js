import React from "react";
import CohortDetails from "./Components/CohortDetails";

function App() {
  return (
    <div className="App">
      <h1>Cohort Dashboard</h1>
      <CohortDetails name="React Developer Track" batch="March 2025" status="Ongoing" />
      <CohortDetails name="Java Full Stack" batch="January 2025" status="Completed" />
    </div>
  );
}

export default App;
