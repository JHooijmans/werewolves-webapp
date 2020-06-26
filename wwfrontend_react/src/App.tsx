import React, { useState } from 'react';
import './App.css';
import { Toggle } from './Toggle';
import { JoinGame } from './JoinGame';
import ConnectionTest from './ConnectionTest';

// const ws = new WebSocket('ws://localhost:3000/ws');

function App() {

  const webSocket = new WebSocket("ws://localhost:8080/play");
  let gameStart: boolean = false;


  webSocket.onopen = (event) => {
      console.log("Connected!");
  };

  webSocket.onmessage = (event) => {
      console.log(event.data);
      // JSON.parse(event.data);
      if (event.data.includes('gameStart')) {
          gameStart = true;
      }
  };

  webSocket.onclose = (event) => {
      console.log("Connection Closed");
  };

  return (
    <div className="App">
      <Toggle />
      <ConnectionTest gameStart={gameStart} webSocket={webSocket} />
    </div>
  );
}

export default App;
