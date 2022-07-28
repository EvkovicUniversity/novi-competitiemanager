// import React from "react";

// import NavigeerNaar from "../../../controller/Navigatie/NavigeerNaar";


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
            <div className="alert alert-danger" role="alert">
                This field is required!
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
        <main>

            <h1>Novi's competitiemanager</h1>

            <Form onSubmit={handleLogin} ref={form}>
                <div className="form-group">
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
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <Input
                        type="password"
                        placeholder="wachtwoord"
                        className="form-control"
                        name="password"
                        value={password}
                        onChange={onChangePassword}
                        validations={[required]}
                    />
                </div>
                <div className="form-group">
                    <button className="button01" disabled={loading}>
                        {loading && (
                            <span className="spinner-border spinner-border-sm"></span>
                        )}
                        <span>Login</span>
                    </button>
                </div>
                {message && (
                    <div className="form-group">
                        <div className="alert alert-danger" role="alert">
                            {message}
                        </div>
                    </div>
                )}
                <CheckButton style={{display: "none"}} ref={checkBtn}/>
            </Form>

            <p id="geen_wachtwoord_paragraaf">
                Neem contact op met de beheerder in geval van
                wachtwoord vergeten of het aanmaken van een account.
            </p>

        </main>
    );
};
export default Login;