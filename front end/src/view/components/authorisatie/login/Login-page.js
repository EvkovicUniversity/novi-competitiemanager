import React, {Component} from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import AuthService from "../../../../controller/services/auth.service";
import "./login-page-css.css";


const required = value => {
    if (!value) {
        return (
            <div className="alert alert-danger" role="alert">
                This field is required!
            </div>
        );
    }
};
export default class Login extends Component {
    constructor(props) {
        super(props);
        this.handleLogin = this.handleLogin.bind(this);
        this.onChangeUsername = this.onChangeUsername.bind(this);
        this.onChangePassword = this.onChangePassword.bind(this);
        this.state = {
            username: "",
            password: "",
            loading: false,
            message: ""
        };
    }

    onChangeUsername(e) {
        this.setState({
            username: e.target.value
        });
    }

    onChangePassword(e) {
        this.setState({
            password: e.target.value
        });
    }

    handleLogin(e) {
        e.preventDefault();
        this.setState({
            message: "",
            loading: true
        });
        this.form.validateAll();
        if (this.checkBtn.context._errors.length === 0) {
            AuthService.login(this.state.username, this.state.password).then(
                () => {
                    this.props.history.push("/menu");
                    window.location.reload();
                },
                error => {
                    const resMessage =
                        (error.response &&
                            error.response.data &&
                            error.response.data.message) ||
                        error.message ||
                        error.toString();
                    this.setState({
                        loading: false,
                        message: resMessage
                    });
                }
            );
        } else {
            this.setState({
                loading: false
            });
        }
    }

    render() {
        return (
            <div>
                <h1>Novi's Competitiemanager</h1>

                <Form
                    onSubmit={this.handleLogin}
                    ref={c => {
                        this.form = c;
                    }}
                >
                    <Input
                        type="text"
                        name="username"
                        className="login_invoervelden"
                        placeholder="Gebruikersnaam"
                        value={this.state.username}
                        onChange={this.onChangeUsername}
                        validations={[required]}
                    />
                    <Input
                        type="password"
                        name="password"
                        className="login_invoervelden"
                        placeholder="Wachtwoord"
                        value={this.state.password}
                        onChange={this.onChangePassword}
                        validations={[required]}
                    />
                    <button
                        className="button01"
                        id="login_button"
                        disabled={this.state.loading}
                    >
                        {this.state.loading && (
                            <span className="spinner-border spinner-border-sm"></span>
                        )}
                        <span>Login</span>
                    </button>

                    {this.state.message && (
                        <div className="form-group">
                            <div className="alert alert-danger" role="alert">
                                {this.state.message}
                            </div>
                        </div>
                    )}
                    <CheckButton
                        style={{display: "none"}}
                        ref={c => {
                            this.checkBtn = c;
                        }}
                    />
                </Form>

                <p id="geen_wachtwoord_paragraaf">
                    Neem contact op met de beheerder in geval van
                    wachtwoord vergeten of het aanmaken van een account.
                </p>

            </div>
        );
    }
}