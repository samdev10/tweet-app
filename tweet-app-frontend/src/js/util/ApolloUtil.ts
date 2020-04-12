import ApolloClient from "apollo-boost";
import { HttpLink } from "apollo-link-http";

export const client = (token: string) =>
  new ApolloClient({
    link: new HttpLink({ uri: "/graphql" }),
    credentials: "include",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
