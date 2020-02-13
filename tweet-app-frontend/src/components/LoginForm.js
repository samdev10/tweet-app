import React, {Component} from 'react';

class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userNameValue: '',
            passwordValue: ''
        };

        this.handleUsernameChange = this
            .handleUsernameChange
            .bind(this);
        this.handlePasswordChange = this
            .handlePasswordChange
            .bind(this);
        this.handleSubmit = this
            .handleSubmit
            .bind(this);
    }

    handleUsernameChange(event) {
        this.setState({userNameValue: event.target.value});
    }

    handlePasswordChange(event) {
        this.setState({passwordValue: event.target.value});
    }

    handleSubmit = (event) => {
        event.preventDefault()
        const data = new FormData(event.target)
        console.log(data)
        console.log(event.target.action)
        fetch(event.target.action, {
                method: 'POST',
                body: new URLSearchParams(data)
            })
            .then(v => {
            if (v.redirected) 
                window.location = v.url
        })
            .catch(e => console.warn(e));
    }

    render() {
        return (
            <React.Fragment>
                <form action="/perform_login" onSubmit={this.handleSubmit}>
                    <label>
                        Username:
                        <input
                            key='username'
                            name='username'
                            placeholder='username'
                            value={this.state.userNameValue}
                            onChange={this.handleUsernameChange}
                            type='text'/>
                    </label>
                    <label>
                        Password:
                        <input
                            key='password'
                            name='password'
                            placeholder='password'
                            value={this.state.passwordValue}
                            onChange={this.handlePasswordChange}
                            type='password'/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>
            </React.Fragment>
        );
    }
}

export default LoginForm;