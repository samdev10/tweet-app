import React, { Component } from "react";

interface Props {}
interface State {}

class Signup extends Component<Props, State> {
  render() {
    return (
      <>
        <form className="form-signup" action="/save_user" method="Post">
          <div className="form-row">
            <div className="col-md-4 mb-3">
              <label for="validationDefault01">First name</label>
              <input
                type="text"
                className="form-control"
                id="validationDefault01"
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
                id="validationDefault02"
                defaultValue=""
                placeholder="Last name"
                required
              />
            </div>
            <div className="col-md-4 mb-3">
              <label for="validationDefaultUsername">Username</label>
              <div className="input-group">
                <div className="input-group-prepend">
                  <span className="input-group-text" id="inputGroupPrepend2">
                    @
                  </span>
                </div>
                <input
                  type="text"
                  className="form-control"
                  id="validationDefaultUsername"
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
                id="validationDefaultEmailid"
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
                id="validationDefaultPassword"
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
                id="validationDefaultConfirmPassword"
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
                id="validationDefaultDateOfBirth"
              />
            </div>
          </div>

          <div className="form-group">
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                defaultValue="false"
                id="invalidCheck2"
                required
              />
              <label className="form-check-label" for="invalidCheck2">
                Agree to terms and conditions
              </label>
            </div>
          </div>
          <button className="btn btn-primary" type="submit">
            Signup
          </button>
        </form>
      </>
    );
  }
}

export default Signup;
