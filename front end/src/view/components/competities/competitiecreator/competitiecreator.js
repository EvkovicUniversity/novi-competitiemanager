import React from "react";
import '../competities.css';

function CompetitieCreator() {
    return (
        <div>
            <h1>Competitie Creator</h1>

            <form action="" className="formulier">
                <div className="creator_invoerveldcontainer">
                    <input type="text"
                           placeholder="Competitienaam"
                           className="creator_invoervelden"/>
                    <br/>

                    <select name="Novi Team" id="Novi_Team_selector">
                        <option value="henk">Novi Team A</option>
                        <option value="henk">Novi Team B</option>
                        <option value="henk">Novi Team C</option>
                    </select>
                    <br/>

                    <input type="text"
                           placeholder="Voeg een extra speler toe"
                           className="creator_invoervelden"
                           id="creator_addSpeler"/>
                    <button className="button01" id="creator_addSpelerButton">+</button>
                    <br/>

                    <input type="datetime-local"
                           className="creator_invoervelden"
                           id="creator_"/>
                    <br/>

                    <input type="text"
                           placeholder="Voer aantal racen in"
                           className="creator_invoervelden"
                           id="creator_"/>
                    <br/>

                    <label htmlFor="">Nieuwe race elke:</label>

                    <input type="text"
                           className="creator_invoervelden"/>
                    <select name="tijdseenheid" id="tijdseenheid_creator">
                        <option value="minuut">Minuut</option>
                        <option value="uur">Uur</option>
                        <option value="dag">Dag</option>
                        <option value="week">Week</option>
                        <option value="maand">Maand</option>
                    </select>
                    <br/>

                </div>
                <button className='button01'>Creër</button>
            </form>

        </div>
    )
}

export default CompetitieCreator;
