import * as H from "history";
import React, { Component } from "react";
import { RouteComponentProps, withRouter } from "react-router-dom";
import { signup as register } from "../js/services/AuthService";

interface Props extends RouteComponentProps {}
interface State {}

class Signup extends Component<RouteComponentProps, State> {
  constructor(props: Props) {
    super(props);
  }

  render() {
    return (
      <>
        <form
          className="form-signup"
          action="/save_user"
          onSubmit={(e) => {
            this.handleSubmit(e, this.props.history!);
          }}
          method="Post"
        >
          <div className="form-row">
            <div className="col-md-4 mb-3">
              <label for="validationDefault01">First name</label>
              <input
                type="text"
                className="form-control"
                id="firstname"
                defaultValue=""
                placeholder="First name"
                required
              />
            </div>
            <div className="col-md-4 mb-3">
              <label for="validationDefault02">Last name</label>
              <input
                type="text"
                className="form-control"
                id="lastname"
                defaultValue=""
                placeholder="Last name"
                required
              />
            </div>
            <div className="col-md-4 mb-3">
              <label for="validationDefaultUsername">Username</label>
              <div className="input-group">
                <div className="input-group-prepend">
                  <span className="input-group-text" id="usernameIcon">
                    @
                  </span>
                </div>
                <input
                  type="text"
                  className="form-control"
                  id="username"
                  aria-describedby="inputGroupPrepend2"
                  defaultValue=""
                  required
                />
              </div>
            </div>
            <div className="col-md-4 mb-3">
              <label for="validationDefaultEmailid">Email id</label>
              <input
                type="email"
                className="form-control"
                id="emailId"
                defaultValue=""
                placeholder="email"
                required
              />
            </div>
            <div className="col-md-4 mb-3">
              <label for="validationDefaultPassword">Password</label>
              <input
                type="password"
                className="form-control"
                id="password"
                defaultValue=""
                placeholder="password"
                required
              />
            </div>
            <div className="col-md-4 mb-3">
              <label for="validationDefaultConfirmPassword">
                Confirm Password
              </label>
              <input
                type="password"
                className="form-control"
                id="confirmPassword"
                defaultValue=""
                placeholder="Confirm password"
                required
              />
            </div>
            <div className="col-md-4 mb-3">
              <label for="validationDefault02">Date of birth</label>
              <input
                className="form-control"
                type="date"
                defaultValue=""
                id="dateOfBirth"
              />
            </div>
          </div>

          <div className="form-group">
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                defaultChecked={false}
                id="agreeTerms"
                required
              />
              <label className="form-check-label" for="agreeTerms">
                Agree to terms and conditions
              </label>
            </div>
          </div>
          <button id="signupButton" className="btn btn-primary" type="submit">
            Signup
          </button>
        </form>
      </>
    );
  }

  private handleSubmit(
    event: React.FormEvent<HTMLFormElement>,
    history: H.History
  ) {
    event.preventDefault();
    const firstname = (document?.getElementById(
      "firstname"
    ) as HTMLInputElement).value;
    const lastname = (document?.getElementById("lastname") as HTMLInputElement)
      .value;
    const username = (document?.getElementById("username") as HTMLInputElement)
      .value;
    const dateOfBirth = (document?.getElementById(
      "dateOfBirth"
    ) as HTMLInputElement).value;
    const emailId = (document?.getElementById("emailId") as HTMLInputElement)
      .value;
    const password = (document?.getElementById("password") as HTMLInputElement)
      .value;
    const agreeTerms = (document?.getElementById(
      "agreeTerms"
    ) as HTMLInputElement).checked;
    register(
      firstname,
      lastname,
      username,
      dateOfBirth,
      password,
      emailId,
      agreeTerms
    )
      .then(() => {
        history.push("/");
      })
      .catch((error) => {
        console.log(error);
      });
  }
}

export default withRouter(Signup);
