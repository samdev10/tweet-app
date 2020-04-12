import { waitFor } from "@testing-library/react";
import { mount, shallow } from "enzyme";
import React from "react";
import { MemoryRouter } from "react-router-dom";
import App from "../src/js/App";
import * as CookiesUtil from "../src/js/util/CookiesUtil";

describe("<App />", () => {
  beforeEach(() => jest.spyOn(CookiesUtil, "getCookie").mockReturnValue(null));

  it("will render", () => {
    // When
    const wrapper = shallow(<App />);

    // Then
    expect(wrapper.exists()).toBeTruthy();
  });

  it("will render heading", () => {
    // When
    const wrapper = mount(
      <MemoryRouter initialEntries={["/singup"]}>
        <App />
      </MemoryRouter>
    );

    // Then
    expect(wrapper.find("h1").at(0).text()).toBe("Tweet");
  });

  it("will render login form", () => {
    // When
    const wrapper = mount(
      <MemoryRouter initialEntries={["/singup"]}>
        <App />
      </MemoryRouter>
    );

    // Then
    expect(wrapper.find("h1").at(1).text()).toBe("Please sign in");
  });

  it("will render home page", async () => {
    // Given
    jest.spyOn(CookiesUtil, "getCookie").mockReturnValue("1");

    // When
    const wrapper = shallow(<App />);

    // Then
    await waitFor(() => {
      wrapper.update();
      expect(wrapper.find("Home").exists()).toBeTruthy();
    });
  });
});
