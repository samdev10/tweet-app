import { MockedProvider } from "@apollo/react-testing";
import { waitFor } from "@testing-library/react";
import { mount } from "enzyme";
import React from "react";
import { USER_INFO } from "../../src/graphql/UserInfo";
import Home from "../../src/js/components/Home";

describe("<Home />", () => {
  const mocks = [
    {
      request: {
        query: USER_INFO,
      },
      result: {
        data: {
          getUserInfo: [
            {
              userName: "sam",
              emailId: "sam@gmail.com",
            },
          ],
        },
      },
    },
  ];

  it.only("will render welcome note", async () => {
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
