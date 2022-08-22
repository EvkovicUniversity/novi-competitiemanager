import React, {useState, useRef} from "react";
import {useNavigate} from 'react-router-dom';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import AuthService from "../../../services/auth.service";
import "./login-page-css.css";

const required = (value) => {
    if (!value) {
        return (
            <div className="alert-message">
                Dit is een verplicht veld!
            </div>
        );
    }
};
const Login = () => {
    let navigate = useNavigate();
    const form = useRef();
    const checkBtn = useRef();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");
    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
    };
    const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
    };
    const handleLogin = (e) => {
        e.preventDefault();
        setMessage("");
        setLoading(true);
        form.current.validateAll();
        if (checkBtn.current.context._errors.length === 0) {
            AuthService.login(username, password).then(
                () => {
                    navigate("/menu");
                    window.location.reload();
                },
                (error) => {
                    const resMessage =
                        (error.response &&
                            error.response.data &&
                            error.response.data.message) ||
                        error.message ||
                        error.toString();
                    setLoading(false);
                    setMessage(resMessage);
                }
            );
        } else {
            setLoading(false);
        }
    };

    return (
        <div className="content">

            <h1>Novi's competitiemanager</h1>

            <div>
                <Form onSubmit={handleLogin} ref={form}>
                    <div className="login_invoervelden">
                        <div id="username-invoer">
                            <label htmlFor="username">Gebruikersnaam</label>
                            <Input
                                type="text"
                                placeholder="gebruikersnaam"
                                className="form-control"
                                name="username"
                                value={username}
                                onChange={onChangeUsername}
                                validations={[required]}
                            />
                        </div>
                        <div id="password-invoer">
                            <label htmlFor="password">Wachtwoord</label>
                            <Input
                                type="password"
                                placeholder="wachtwoord"
                                name="password"
                                value={password}
                                onChange={onChangePassword}
                                validations={[required]}
                            />
                        </div>
                    </div>
                    <div>
                        <button className="button01" id="login-button" disabled={loading}>
                            {loading && (
                                <p>Loading...</p>
                            )}
                            <span>Login</span>
                        </button>
                    </div>
                    {message && (
                        <div className="alert-container">
                            <div className="alert-message">
                                {message}
                            </div>
                        </div>
                    )}
                    <CheckButton style={{display: "none"}} ref={checkBtn}/>
                </Form>
            </div>

            <p id="geen_wachtwoord_paragraaf">
                Neem contact op met de beheerder in geval van
                wachtwoord vergeten of het aanmaken van een account.
            </p>

        </div>
    );
};
export default Login;