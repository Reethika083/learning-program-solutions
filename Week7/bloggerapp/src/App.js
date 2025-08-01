import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [showComponent, setShowComponent] = useState("book");

  // Using element variable
  let displayComponent;
  if (showComponent === "book") displayComponent = <BookDetails />;
  else if (showComponent === "blog") displayComponent = <BlogDetails />;
  else displayComponent = <CourseDetails />;

  return (
    <div className="App">
      <h1>🧠 Blogger App - Conditional Rendering Examples</h1>
      
      <button onClick={() => setShowComponent("book")}>Book</button>
      <button onClick={() => setShowComponent("blog")}>Blog</button>
      <button onClick={() => setShowComponent("course")}>Course</button>

      <hr />

      {/* Render using Element Variable */}
      {displayComponent}

      {/* Render using Ternary */}
      <div style={{ marginTop: "20px" }}>
        {showComponent === "book" ? (
          <h4>📌 You're viewing Book Details</h4>
        ) : showComponent === "blog" ? (
          <h4>📌 You're viewing Blog Details</h4>
        ) : (
          <h4>📌 You're viewing Course Details</h4>
        )}
      </div>

      {/* Render using Logical AND */}
      {showComponent === "book" && <p>✔️ Books are essential to grow knowledge.</p>}
    </div>
  );
}

export default App;
