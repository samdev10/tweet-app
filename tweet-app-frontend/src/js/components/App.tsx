import * as React from "react";
import AuthenticationRequest from "../entities/AuthenticationRequest.ts";
import Form from "./Form.jsx";

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
  authToken: string;
  error: string;
}

class App extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.state = { authToken: "", error: "" };
    this.login = this.login.bind(this);
  }

  handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const username = event.target[0].value;
    const password = event.target[1].value;
    this.login(username, password)
      .then(response => response.json())
      .then(data => {
        localStorage.setItem("token", data.token);
        localStorage.setItem("username", data.username);
        this.setState({ authToken: data.token, error: "" });
      })
      .catch(error => {
        this.setState({ authToken: "", error: error.message });
      });
  };

  render() {
    if (
      window.localStorage.getItem("token") === null ||
      window.localStorage.getItem("token") === undefined
    ) {
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
          <div>Welcome! {window.localStorage.getItem("username")}</div>
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
