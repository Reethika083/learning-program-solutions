import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch("https://api.randomuser.me/");
      const data = await response.json();
      this.setState({ user: data.results[0] });
    } catch (error) {
      console.error("Error fetching user:", error);
    }
  }

  render() {
    const { user } = this.state;

    return (
      <div className="user-container">
        <h2>User Details</h2>
        {user ? (
          <div className="user-card">
            <p><strong>Title:</strong> {user.name.title}</p>
            <p><strong>First Name:</strong> {user.name.first}</p>
            <img src={user.picture.large} alt="User" />
          </div>
        ) : (
          <p>Loading user details...</p>
        )}
      </div>
    );
  }
}

export default Getuser;
