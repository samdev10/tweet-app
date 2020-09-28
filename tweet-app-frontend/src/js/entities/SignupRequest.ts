class SignupRequest {
  firstname: string;
  lastname: string;
  username: string;
  dateOfBirth: string;
  password: string;
  emailId: string;
  agreeTerms: boolean;

  constructor(
    firstname: string,
    lastname: string,
    username: string,
    dateOfBirth: string,
    password: string,
    emailId: string,
    agreeTerms: boolean
  ) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.dateOfBirth = dateOfBirth;
    this.password = password;
    this.emailId = emailId;
    this.agreeTerms = agreeTerms;
  }
}

export default SignupRequest;
