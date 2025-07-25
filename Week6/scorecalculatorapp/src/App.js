import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore name="Reethika" school="Cluny School" total={460} goal={5} />
    </div>
  );
}

export default App;
