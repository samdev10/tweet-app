import gql from "graphql-tag";

export const USER_INFO_MUTATION = gql`
  mutation saveUser($userName: String!, $emailId: String, $password: String!) {
    saveUserInfo(
      input: { userName: $userName, emailId: $emailId, password: $password }
    ) {
      userName
    }
  }
`;
