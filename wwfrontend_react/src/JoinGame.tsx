import React from 'react';

export class JoinGame extends React.Component <{}, { value: string }> {
    constructor(props:any) {
      super(props);
      this.state = {value: ''};
  
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event:any) {
      this.setState({value: event.target.value});
    }
  
    handleSubmit(event:any) {
      console.log('A name was submitted: ' + this.state.value);
      event.preventDefault();
    }
  
    render() {
      return (
        <form onSubmit={this.handleSubmit}>
          <label>
            Name:
            <input type="text" value={this.state.value} placeholder="Enter Your Name" onChange={this.handleChange} />
          </label>
          <button value="Join Game" />
        </form>
      );
    }
  }
