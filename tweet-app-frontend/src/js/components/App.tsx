import * as React from "react";
import { login, logout } from "../services/AuthService";
import { getCookie } from "../util/CookiesUtil";
import Form from "./Form";

const inputs = [
  {
    name: "username",
    placeholder: "username",
    type: "text",
    className: "form-control"
  },
  {
    name: "password",
    placeholder: "password",
    type: "password",
    className: "form-control"
  },
  {
    type: "submit",
    value: "Submit",
    className: "btn btn-lg btn-primary btn-block"
  }
];

const props = {
  name: "loginForm",
  inputs: inputs
};

interface Props {}

interface State {
  isAuthenticated: boolean;
  error: string;
}

class App extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.state = { isAuthenticated: false, error: "" };
    this.handleLogout = this.handleLogout.bind(this);
  }

  render() {
    const user = getCookie("username");
    const token = getCookie("token");
    if (token === null || user === null) {
      return (
        <div>
          <h1>Tweet</h1>
          <Form
            {...props}
            error={this.state.error}
            handleSubmit={this.handleSubmit}
          />
        </div>
      );
    } else {
      return (
        <div>
          <h1>Tweet</h1>
          <div>Welcome! {user}</div>
          <button onClick={this.handleLogout}>logout</button>
        </div>
      );
    }
  }

  handleLogout(event: React.MouseEvent<HTMLButtonElement>) {
    event.preventDefault();
    logout().then(() => {
      this.setState({ isAuthenticated: false });
    });
  }

  handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const username = event.target[0].value;
    const password = event.target[1].value;
    login(username, password)
      .then(response => response.json())
      .then(data => {
        document.cookie = "token=" + data.token;
        document.cookie = "username=" + data.username;
        this.setState({ isAuthenticated: true, error: "" });
      })
      .catch(error => {
        this.setState({ isAuthenticated: false, error: error.message });
      });
  };
}

export default App;
