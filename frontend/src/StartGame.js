import React from "react";
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';

import '../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';

class StartGame extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            id: String,
            rounds: []
        }
    }

    userOption = (option) => {
        fetch('/rock-paper-scissors/user-option/' + this.props.id + '/' + option, {method: 'POST'})
            .then(response => response.status)
            .then(status => {
                console.log("User option status " + status);
            })
            .then(() =>
                fetch('/rock-paper-scissors/game-status/' + this.props.id)
                .then(response => response.json())
                .then(data => {
                    console.log("Game status " + data);
                    this.setState({ rounds: data.rounds })})
                );
    };

    clickRock = () => this.userOption('rock');
    clickPaper = () => this.userOption('paper');
    clickScissors = () => this.userOption('scissors');


    render() {
        return (
            <section className="container">
                <div className="player1">
                    <h5>Player1</h5>
                    <h5>Please select an option</h5>
                    <div>
                        <button onClick={this.clickRock} className="option" type="button">Rock</button>
                        <button onClick={this.clickPaper} className="option" type="button">Paper</button>
                        <button onClick={this.clickScissors} className="option" type="button">Scissors</button>
                    </div>
                </div>
                <div className="player2">
                    <h5>Player2</h5>
                    <h5>Player2 already chose</h5>
                </div>
                <p>Rounds played = {this.state.rounds.length}</p>
                <BootstrapTable data={this.state.rounds}>
                    <TableHeaderColumn dataField='player1Option' isKey>Player1</TableHeaderColumn>
                    <TableHeaderColumn dataField='player2Option'>Player2</TableHeaderColumn>
                    <TableHeaderColumn dataField='roundResult'>Round result</TableHeaderColumn>
                </BootstrapTable>
            </section>

    );
        
    }
}


export default StartGame