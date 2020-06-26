import React from 'react';

const imagesPath = {
    inverted: "pngfind.com-wolf-face-png-2893279-Inverted.png",
    regular: "pngfind.com-wolf-face-png-2893279.png"
  }
  
  export class Toggle extends React.Component <{}, { invert: boolean }> {
    state = {
      invert: true,
    }
    toggleImage = () => {
      this.setState(state => ({ invert: !state.invert }))
    }
  
    getImageName = () => this.state.invert ? 'regular' : 'inverted';
    getBgColor = () => this.state.invert ? '#cddaf3' : '#13274b';
  
    render() {
      const imageName = this.getImageName();
      const bgColor = this.getBgColor();
      return (
        <div>
          <header className="App-header" style={{backgroundColor: bgColor}}>
            <img style={{height: "40vmin"}} src={imagesPath[imageName]} onClick={this.toggleImage} alt="logo_wolf"/>
            <p style={{color: "white", fontSize: 'calc(10px + 2vmin)'}}>Weerwolven van Wakkerdam WebApp{"\n"} </p>
          </header>
        </div>
      );
    }
  }