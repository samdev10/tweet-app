import { gql } from "apollo-boost";

export const GET_USER_INFO = gql`
  query getUserInfo($username: String) {
    getUserInfo(username: $username) {
      username
      emailId
    }
  }
`;
