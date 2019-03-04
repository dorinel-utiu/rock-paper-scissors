import React from 'react'
import ReactDOM from 'react-dom'

import './style.css'
import StartGame from "./StartGame";

class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            isShow: false,
            textValue: 'Start Game',
            id: String
        };
    }

    toggleShow = () => {
        if (this.state.textValue === "Start Game") {
            this.setState(state => ({isShow: !state.isShow, textValue: 'Restart Game'}));

            this.id = "id" + new Date().getTime();
            fetch('/rock-paper-scissors/game-start/' + this.id, {method: 'POST'})
                .then(response => response.status)
                .then(status => {
                    console.log("Game start status " + status);
                });
        } else {
            this.setState(state => ({isShow: !state.isShow, textValue: 'Start Game'}));
        }


    };

    render() {
        return <div className="main">
            <h1>Rock Paper Scissors</h1>
            {this.state.isShow ? <StartGame id={this.id}/> : null}
            <button className="button" onClick={this.toggleShow} type="button">
                {this.state.textValue}
            </button>
        </div>
    }
}

ReactDOM.render(<App/>, document.querySelector('#root'))