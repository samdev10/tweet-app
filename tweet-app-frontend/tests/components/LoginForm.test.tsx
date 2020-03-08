import { shallow } from "enzyme";
import React from "react";
import LoginForm from "../../src/js/components/LoginForm";

describe("<LoginForm />", () => {
  it("will render", () => {
    // When
    const wrapper = shallow(<LoginForm handleSubmit={() => {}} error="" />);

    // Then
    expect(wrapper.exists()).toBeTruthy();
  });

  it("will render error", () => {
    // Given
    let errmsg = "error";

    // When
    const wrapper = shallow(
      <LoginForm handleSubmit={() => {}} error={errmsg} />
    );

    // Then
    expect(wrapper.find(".error").text()).toBe("error");
  });

  it("will render inputs", () => {
    // When
    const wrapper = shallow(<LoginForm handleSubmit={() => {}} error="" />);

    // Then
    expect(
      wrapper
        .find("input")
        .at(0)
        .prop("name")
    ).toBe("username");
    expect(
      wrapper
        .find("input")
        .at(1)
        .prop("name")
    ).toBe("password");
    expect(
      wrapper
        .find("input")
        .at(2)
        .prop("type")
    ).toBe("submit");
  });

  it("will call handle submit", () => {
    // Given
    let isCalled = false;
    const stub = () => {
      isCalled = true;
    };
    const wrapper = shallow(<LoginForm handleSubmit={stub} error="" />);

    // When
    wrapper.find("form").simulate("submit");

    // Then
    expect(isCalled).toBeTruthy();
  });
});
