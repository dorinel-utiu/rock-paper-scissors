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
            id: String,
            totalRounds: 0,
            player1Wins: 0,
            player2Wins: 0,
            totalDraws: 0
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
                })
                .then(() =>
                    fetch('/rock-paper-scissors/overall-game-status')
                        .then(response => response.json())
                        .then(data => {
                            console.log("Game overall status " + data);
                            this.setState({
                                totalRounds: data.totalRounds,
                                player1Wins: data.playerOneWins,
                                player2Wins: data.playerTwoWins,
                                totalDraws: data.totalDraws})
                        }));
        } else {
            this.setState(state => ({isShow: !state.isShow, textValue: 'Start Game'}));
        }


    };

    totalRounds() {
        if (this.data.totalRounds !== 'undefined')
            return 0;
        else
            return this.data.totalRounds
    };

    render() {
        return (
            <div className="main">
                <h1>Rock Paper Scissors</h1>
                {this.state.isShow ? <StartGame id={this.id}/> : null}
                <button className="button" onClick={this.toggleShow} type="button">
                    {this.state.textValue}
                </button>
                <div className="main2">
                    <h2>Overall game summary</h2>
                    <p>Total rounds played: {this.state.totalRounds}</p>
                    <p>Total player1 wins: {this.state.player1Wins}</p>
                    <p>Total player2 wins: {this.state.player2Wins}</p>
                    <p>Total draws: {this.state.totalDraws}</p>
                </div>
            </div>
        )
    }
}

ReactDOM.render(<App/>, document.querySelector('#root'))