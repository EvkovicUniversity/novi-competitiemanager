import React from "react";
import '../competities.css';

function CompetitieCreator() {
    return (
        <div>
            <h1>Competitie Creator</h1>


            <form action="" className="formulier">
                <div className="creator_invoerveldencontainer">
                    <input type="text"/><br/>
                    <input type="text"/><br/>
                    <input type="text"/><br/>
                    <input type="text"/><br/>
                    <input type="text"/><br/>
                </div>
                <button className='button01'>Creër</button>
            </form>

        </div>
    )
}

export default CompetitieCreator;
