import { ApolloProvider } from "@apollo/react-components";
import ApolloClient from "apollo-boost";
import { HttpLink } from "apollo-link-http";
import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import ReactDOM from "react-dom";
import "../css/signin.css";
import App from "./App";
import { getCookie } from "./util/CookiesUtil";

const httpLink = new HttpLink({ uri: "/graphql" });
const client = new ApolloClient({
  link: httpLink,
  headers: {
    Authorization: "Bearer " + getCookie("token"),
  },
});

ReactDOM.render(
  <ApolloProvider client={client}>
    <App />
  </ApolloProvider>,
  document.getElementById("root")
);
