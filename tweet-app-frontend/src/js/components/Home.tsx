import React, { Component } from "react";
import { Query } from "react-apollo";
import { GET_USER_INFO } from "../../graphql/GetUserInfo";
import GetUserInfo from "../entities/GetUserInfo";

interface Props {
  logoutHandler(event: React.MouseEvent<HTMLButtonElement>): void;
}
interface State {}

class Home extends Component<Props, State> {
  constructor(props: Props) {
    super(props);
  }

  render() {
    return (
      <Query<GetUserInfo>
        query={GET_USER_INFO}
        variables={{ username: "user" }}
      >
        {({ loading, error, data }) => {
          if (loading) return <div>Loading...</div>;
          if (error) return <div>`Error! ${error.message}`</div>;

          if (data?.getUserInfo) {
            return (
              <div>
                <h1>Tweet</h1>
                <div id="welcome">
                  Welcome! {data && data.getUserInfo.username}
                </div>
                <button id="logout" onClick={this.props.logoutHandler}>
                  logout
                </button>
              </div>
            );
          }
          return <></>;
        }}
      </Query>
    );
  }
}

export default Home;
