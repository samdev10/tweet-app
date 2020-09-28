import { mount } from "enzyme";
import React from "react";
import { MemoryRouter } from "react-router-dom";
import LoginForm from "../../src/js/components/LoginForm";

describe("<LoginForm />", () => {
  it("will render", () => {
    // When
    const wrapper = mount(
      <MemoryRouter initialEntries={["/singup"]}>
        <LoginForm handleSubmit={() => {}} error="" />
      </MemoryRouter>
    );

    // Then
    expect(wrapper.exists()).toBeTruthy();
  });

  it("will render error", () => {
    // Given
    let errmsg = "error";

    // When
    const wrapper = mount(
      <MemoryRouter initialEntries={["/singup"]}>
        <LoginForm handleSubmit={() => {}} error={errmsg} />
      </MemoryRouter>
    );

    // Then
    expect(wrapper.find(".error").text()).toBe("error");
  });

  it("will render inputs", () => {
    // When
    const wrapper = mount(
      <MemoryRouter initialEntries={["/singup"]}>
        <LoginForm handleSubmit={() => {}} error="" />
      </MemoryRouter>
    );

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
    const wrapper = mount(
      <MemoryRouter initialEntries={["/singup"]}>
        <LoginForm handleSubmit={stub} error="" />
      </MemoryRouter>
    );

    // When
    wrapper.find("form").simulate("submit");

    // Then
    expect(isCalled).toBeTruthy();
  });
});
