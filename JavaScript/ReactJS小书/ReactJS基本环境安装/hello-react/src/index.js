import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class Title extends Component {
  handleClickOnTitle () {
    console.log('Click on title.')
  }
  render () {
    return (
      <h1 onClick={this.handleClickOnTitle}>React 小书</h1>
    )
  }
}
class Header extends Component {
  render () {
    return (
      <div>
        <Title />
      </div>
    )
  }
}
class Main extends Component {
  render () {
    return (
      <div>
        <h2>This is main content</h2>
      </div>
    )
  }
}
class Footer extends Component {
  render () {
    return (
      <div>
        <h2>This is footer</h2>
      </div>
    )
  }
}
class Index extends Component {
  render () {
    return (
      <div>
        <Header />
        <Main />
        <Footer />
      </div>
    )
  }
}
ReactDOM.render(
  <Index />,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
// serviceWorker.unregister();
