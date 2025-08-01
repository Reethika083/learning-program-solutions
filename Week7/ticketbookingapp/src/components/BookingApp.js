import React, { Component } from 'react';

class BookingApp extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  }

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  }

  renderGuestPage() {
    return (
      <div>
        <h2>Welcome, Guest!</h2>
        <p>Browse flights, but login to book tickets.</p>
        <button onClick={this.handleLogin}>Login</button>
      </div>
    );
  }

  renderUserPage() {
    return (
      <div>
        <h2>Welcome, User!</h2>
        <p>You can now book tickets.</p>
        <button onClick={this.handleLogout}>Logout</button>
      </div>
    );
  }

  render() {
    return (
      <div>
        <h1>✈️ Flight Ticket Booking Portal</h1>
        {this.state.isLoggedIn ? this.renderUserPage() : this.renderGuestPage()}
      </div>
    );
  }
}

export default BookingApp;
