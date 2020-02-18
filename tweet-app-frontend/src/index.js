import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import ReactDOM from "react-dom";
import "../src/css/signin.css";
import Form from "./components/Form.jsx";

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
  method: "POST",
  action: "/perform_login",
  inputs: inputs
};

const params = new URLSearchParams(window.location.search);

ReactDOM.render(
  <Form {...props} error={params.get("error")} />,
  document.getElementById("loginContainer")
);
