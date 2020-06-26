import React from 'react';

interface ConnectionProps {
    gameStart:boolean;
    webSocket:WebSocket;
}

export class ConnectionTest extends React.Component <ConnectionProps, {message:string}> {
    constructor(props:any) {
      super(props);
      this.state = {message: ''};
    }

    // let webSocket;

    // if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
    //     return;
    // }  

    //This needs to be in it's own class, because it should cause the gameboard to appear. 
    startGame = () => {
        this.props.webSocket.send(JSON.stringify({gameStart: true}));
    }
 
    send = (message: string) => {
        this.props.webSocket.send(JSON.stringify({ playername : message }));
    }

    render() {
        if (this.props.gameStart === false ) {
            return (
                <div>
                    <form
                    action="."
                    onSubmit={e => {
                        e.preventDefault()
                        this.send(this.state.message)
                        this.setState({ message: '' })
                    }}
                    >
                    <input
                        type="text"
                        placeholder={'Enter your name here'}
                        value={this.state.message}
                        onChange={e => this.setState({ message: e.target.value })}
                    />
                    <input type="submit" value={'Join Game'} />
                    </form>
                    <p>Enter your name to join the game; When everyone has joined, hit Start Game!</p>
                    <button type="button" onClick={this.startGame}>Start Game!</button>
                </div>
            )
        }
        else { 
            return (
            <div></div>
        )}
    }
}

export default ConnectionTest