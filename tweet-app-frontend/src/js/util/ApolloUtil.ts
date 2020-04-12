import ApolloClient from "apollo-boost";

export const client = (token: string) =>
  new ApolloClient({
    uri: "/graphql",
    credentials: "include",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
