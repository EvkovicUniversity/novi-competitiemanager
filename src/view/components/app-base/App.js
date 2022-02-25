import logo from '../../resources/logo/novi_logo.PNG';
import './App.css';
import '../algemeen/algemeen.css';

function App() {
    return (
        <div className="background">
            <div className="outer_content_container">
                <div className="inner_content_container">
                    <img src={logo} className="novi-logo" alt="novi-logo"/>
                    <div className="alternating_content_container">

                        <h1>Novi Competitiemanager</h1>

                        <p>
                            <button className="button01" id="testbutton">KNOP</button>
                        </p>
                    </div>

                </div>
            </div>
        </div>
    );
}

export default App;
