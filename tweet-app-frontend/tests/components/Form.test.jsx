import { shallow } from "enzyme";
import React from "react";
import Form from "../../src/js/components/Form";

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
  action: "/auth/signin",
  contentType: "application/json",
  inputs: inputs
};

describe("<Form />", () => {
  it("will render", () => {
    // When
    const wrapper = shallow(<Form {...props} />);

    // Then
    expect(wrapper.exists()).toBeTruthy();
  });

  it("will render heading", () => {
    // When
    const wrapper = shallow(<Form {...props} />);

    // Then
    expect(wrapper.find("h1").text()).toBe("Please sign in");
  });

  it("will submit", () => {
    // Given
    const mockSuccessResponse = {};
    const mockJsonPromise = Promise.resolve(mockSuccessResponse); // 2
    const mockFetchPromise = Promise.resolve({
      // 3
      json: () => mockJsonPromise
    });
    jest.spyOn(global, "fetch").mockImplementation(() => mockFetchPromise); // 4

    // When
    const wrapper = shallow(<Form {...props} />);

    wrapper.update();
    console.log(wrapper.debug());
    wrapper.find("form").simulate("submit", { value: "1" });

    // Then
    expect(wrapper.find("h1").text()).toBe("Please sign in");
  });
});
