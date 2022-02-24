import logo from '../../resources/logo/Novi_Logo_Schematisch.png';
import './App.css';
import '../algemeen/algemeen.css';

function App() {
  return (
    <div className="background">

        <div className="content_container">

            <img src={logo} className="novi-logo" alt="novi-logo" />

            <div className="alternating_content">
                <p>
                    Ik verander wel eens.
                </p>
            </div>

            <p>
                <button className="button01" id="testbutton">KNOP</button>
            </p>
        </div>
    </div>
  );
}

export default App;
