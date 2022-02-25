import logo from '../../resources/logo/novi_logo.PNG';
import './App.css';
import '../algemeen/algemeen.css';
import LoginPage from "../login-page/login-page";

function App() {
    return (
        <div className="background">
            <div className="outer_content_container">
                <div className="inner_content_container">
                    <img src={logo} className="novi-logo" alt="novi-logo"/>
                    <div className="alternating_content_container">
                        <LoginPage/>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;
