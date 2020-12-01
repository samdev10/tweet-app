import { MockedProvider } from "@apollo/react-testing";
import { waitFor } from "@testing-library/react";
import { mount } from "enzyme";
import React from "react";
import { GET_USER_INFO } from "../../src/graphql/GetUserInfo";
import Home from "../../src/js/components/Home";

describe("<Home />", () => {
  const mocks = [
    {
      request: {
        query: GET_USER_INFO,
        variables: { username: "user" },
      },
      result: {
        data: {
          getUserInfo: {
            username: "sam",
            emailId: "sam@gmail.com",
          },
        },
      },
    },
  ];

  it("will render welcome note", async () => {
    // When
    const wrapper = mount(
      <MockedProvider mocks={mocks} addTypename={false}>
        <Home logoutHandler={() => {}} />
      </MockedProvider>
    );

    // Then
    await waitFor(() => {
      wrapper.update();
      expect(wrapper.find("#welcome").text()).toBe("Welcome! sam");
    });
  });
});
