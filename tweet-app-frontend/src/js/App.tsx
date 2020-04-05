import { gql } from "apollo-boost";
import * as React from "react";
import { Query } from "react-apollo";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Signup from "../pages/Signup";
import LoginForm from "./components/LoginForm";
import { login, logout } from "./services/AuthService";
import { getCookie } from "./util/CookiesUtil";

const USER_INFO = gql`
  query {
    getUserInfo {
      userName
      emailId
    }
  }
`;

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
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    const user = getCookie("username");
    const token = getCookie("token");
    if (token === null || user === null) {
      return (
        <BrowserRouter>
          <div>
            <Switch>
              <Route exact path="/">
                <h1>Tweet</h1>
                <LoginForm
                  handleSubmit={this.handleSubmit}
                  error={this.state.error}
                ></LoginForm>
              </Route>
              <Route exact path="/signup">
                <Signup />
              </Route>
            </Switch>
          </div>
        </BrowserRouter>
      );
    } else {
      return (
        <Query query={USER_INFO}>
          {({ loading, error, data }) => {
            if (loading) return <div>Loading...</div>;
            if (error) return `Error!: ${error}`;

            return (
              <div>
                <h1>Tweet</h1>
                <div id="welcome">
                  Welcome!{" "}
                  {
                    data.getUserInfo.find((user) => user.userName != null)
                      .userName
                  }
                </div>
                <button onClick={this.handleLogout}>logout</button>
              </div>
            );
          }}
        </Query>
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
      .then((response) => response.json())
      .then((data) => {
        document.cookie = "token=" + data.token;
        document.cookie = "username=" + data.username;
        this.setState({ isAuthenticated: true, error: "" });
      })
      .catch((error) => {
        this.setState({ isAuthenticated: false, error: error.message });
      });
  };
}

export default App;
