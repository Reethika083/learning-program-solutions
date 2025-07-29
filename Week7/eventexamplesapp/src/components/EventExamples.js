// src/components/EventExamples.js
import React, { Component } from 'react';

class EventExamples extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      rupees: '',
      euro: ''
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    console.log("Hello! You're doing great 🚀");
  };

  sayWelcome = (message) => {
    alert(message);
  };

  onPress = (e) => {
    alert("I was clicked");
  };

  handleInput = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = () => {
    const euro = parseFloat(this.state.rupees) / 88; // Approx conversion
    this.setState({ euro: euro.toFixed(2) });
  };

  render() {
    return (
      <div>
        <h2>Event Handling Examples</h2>
        <h3>Counter: {this.state.count}</h3>
        <button onClick={this.increment}>Increase</button>
        <button onClick={this.decrement}>Decrease</button>
        <br /><br />
        <button onClick={() => this.sayWelcome("Welcome to the React World!")}>
          Say Welcome
        </button>
        <br /><br />
        <button onClick={this.onPress}>Click Me</button>

        <h3>Currency Converter</h3>
        <input
          type="text"
          placeholder="Enter amount in INR"
          value={this.state.rupees}
          onChange={this.handleInput}
        />
        <button onClick={this.handleSubmit}>Convert</button>
        <p>Amount in Euro: {this.state.euro}</p>
      </div>
    );
  }
}

export default EventExamples;
