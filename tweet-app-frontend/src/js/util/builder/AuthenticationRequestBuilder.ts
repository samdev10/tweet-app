import AuthenticationRequest from "../../entities/AuthenticationRequest";
import { getRandomString } from "../RandomUtil";

export default class AuthenticationRequestBuilder {
  static get Builder() {
    class Builder {
      private username: string = getRandomString(6);
      private password: string = getRandomString(6);
      withUserName(name: string) {
        this.username = name;
        return this;
      }
      withPassword(password: string) {
        this.password = password;
        return this;
      }
      build() {
        return new AuthenticationRequest(this.username, this.password);
      }
    }
    return Builder;
  }
}
