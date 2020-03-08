import { mount, shallow } from "enzyme";
import React from "react";
import App from "../src/js/App";

describe("<App />", () => {
  const mockCookie = (value: string) => {
    Object.defineProperty(document, "cookie", {
      value: value,
      writable: true
    });
  };

  beforeEach(() => mockCookie(""));

  it("will render", () => {
    // When
    const wrapper = shallow(<App />);

    // Then
    expect(wrapper.exists()).toBeTruthy();
  });

  it("will render heading", () => {
    // When
    const wrapper = mount(<App />);

    // Then
    expect(
      wrapper
        .find("h1")
        .at(0)
        .text()
    ).toBe("Arupu");
  });

  it("will render login form", () => {
    // When
    const wrapper = mount(<App />);

    // Then
    expect(
      wrapper
        .find("h1")
        .at(1)
        .text()
    ).toBe("Please sign in");
  });

  it("will render user name", () => {
    // Given
    mockCookie("token=123; username=sam");

    // When
    const wrapper = mount(<App />);

    // Then
    expect(wrapper.find("#welcome").text()).toBe("Welcome! sam");
  });
});
