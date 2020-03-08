import React, { Component } from "react";

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

interface Props {
  handleSubmit(event: React.FormEvent<HTMLFormElement>): void;
  error: string;
}
interface State {}

class LoginForm extends Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.renderError = this.renderError.bind(this);
    this.renderInputs = this.renderInputs.bind(this);
  }

  renderError = (): JSX.Element => {
    if (this.props.error) {
      const errmsg = this.props.error;
      return <div className="error">{errmsg}</div>;
    }
    return <></>;
  };

  renderInputs = (): JSX.Element[] => {
    if (inputs) {
      return inputs.map(
        ({ name, placeholder, type, value, className }, index) => (
          <div key={"div" + index} className="form-group">
            <input
              key={index}
              name={name}
              placeholder={placeholder}
              type={type}
              value={value}
              className={className}
            />
          </div>
        )
      );
    }
    return [<></>];
  };

  render() {
    const errors = this.renderError();
    const inputs = this.renderInputs();
    return (
      <form
        className="form-signin"
        name="loginForm"
        onSubmit={this.props.handleSubmit}
      >
        <h1 className="h3 mb-3 font-weight-normal">Please sign in</h1>
        {inputs}
        {errors}
      </form>
    );
  }
}

export default LoginForm;
