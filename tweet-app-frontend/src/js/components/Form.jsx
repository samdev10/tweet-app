import PropTypes from "prop-types";
import React, { Component } from "react";
import Input from "./Input";

class Form extends Component {
  renderError = () => {
    if (this.props.error) {
      const errmsg = this.props.error;
      return <div className="error">{errmsg}</div>;
    }
  };

  render() {
    const inputs = this.props.inputs.map(
      ({ name, placeholder, type, value, className }, index) => (
        <div key={"div" + index} className="form-group">
          <Input
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
    const errors = this.renderError();
    return (
      <form
        className="form-signin"
        {...this.props}
        onSubmit={this.props.handleSubmit}
      >
        <h1 className="h3 mb-3 font-weight-normal">Please sign in</h1>
        {inputs}
        {errors}
      </form>
    );
  }
}

Form.propTypes = {
  name: PropTypes.string,
  action: PropTypes.string,
  method: PropTypes.string,
  inputs: PropTypes.array,
  error: PropTypes.string,
  handleSubmit: PropTypes.func
};

export default Form;
