import React, { useEffect, useState } from "react";
import GitClient from "./GitClient";

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
    GitClient.getRepositories("techiesyed").then(setRepos);
  }, []);

  return (
    <div>
      <h1>Repositories for techiesyed</h1>
      <ul>
        {repos.map(name => (
          <li key={name}>{name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
