import AuthenticationRequest from "../entities/AuthenticationRequest";
import SignupRequest from "../entities/SignupRequest";
import { getCookie } from "../util/CookiesUtil";

export async function logout(): Promise<Response> {
  const response = await fetch("/signout", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: "Bearer " + getCookie("token"),
    },
    body: "",
  });
  if (response.ok) {
    return Promise.resolve(response);
  } else {
    return Promise.reject(new Error("Logout unsuccesful"));
  }
}

export async function login(
  username: string,
  password: string
): Promise<Response> {
  const response = await fetch("/auth/signin", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(new AuthenticationRequest(username, password)),
  });
  if (response.ok) {
    return Promise.resolve(response);
  } else {
    return Promise.reject(new Error("Username and password are invalid"));
  }
}

export async function signup(
  firstname: string,
  lastname: string,
  username: string,
  dateOfBirth: Date,
  password: string,
  emailId: string,
  agreeTerms: boolean
): Promise<Response> {
  const response = await fetch("/save_user", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(
      new SignupRequest(
        firstname,
        lastname,
        username,
        dateOfBirth,
        password,
        emailId,
        agreeTerms
      )
    ),
  });
  if (response.ok) {
    return Promise.resolve(response);
  } else {
    return Promise.reject(new Error("Enter valid details"));
  }
}
