console.log("Before the React stuff.");

class HelloWorld extends React.Component {
  constructor(props) {
    super(props);
    this.state = {bangs: ""};
  }

  render() {
    return React.createElement('h1', {onClick: e => this.clickHandler(e)}, `Hello ${this.props.name}!${this.state.bangs}`);
  }

  clickHandler(e) {
    this.setState({bangs: this.state.bangs + '!'})
  }
}

function HelloWorld2(props) {
  return React.createElement('h1', null, `Hello ${props.name}!`);
}

ReactDOM.render(
  React.createElement('div', null,
    React.createElement(HelloWorld, {name: 'Pat'}, null),
    React.createElement(HelloWorld2, {name: 'Morgan'}, null)
  ),
  document.getElementById('react-root')
)
