import { shallow } from "enzyme";
import React from "react";
import App from "../../src/js/components/App";

describe("<App />", () => {
  it("will render", () => {
    // When
    const wrapper = shallow(<App />);

    // Then
    expect(wrapper.exists()).toBeTruthy();
  });

  it("will render", () => {
    // When
    const wrapper = shallow(<App />);

    // Then
    expect(wrapper.find("h1").text()).toBe("Tweet");
  });
});