import * as React from "react";
import AuthenticationRequest from "../entities/AuthenticationRequest";
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
    this.login = this.login.bind(this);
    this.getCookie = this.getCookie.bind(this);
  }

  handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const username = event.target[0].value;
    const password = event.target[1].value;
    this.login(username, password)
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

  getCookie(name: string) {
    var cookieArr = document.cookie.split(";");

    for (var i = 0; i < cookieArr.length; i++) {
      var cookiePair = cookieArr[i].split("=");

      if (name === cookiePair[0].trim()) {
        return cookiePair[1];
      }
    }
    return null;
  }

  render() {
    const user = this.getCookie("username");
    const token = this.getCookie("token");
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
        </div>
      );
    }
  }

  private login(username: string, password: string) {
    return fetch("/auth/signin", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(new AuthenticationRequest(username, password))
    }).then(response => {
      if (response.ok) {
        return Promise.resolve(response);
      } else {
        return Promise.reject(new Error("Username and password are invalid"));
      }
    });
  }
}
export default App;
