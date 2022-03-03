import React from "react";

function Competitie(){

    return (
        <div>
            <h1>Competitienaam</h1>

            <div className={'competitietabel'}>
                <table className='tabel'>
                    <tr>
                        <th>Positie</th>
                        <th>Naam</th>
                    </tr>
                    <tr>
                        <td>1e</td>
                        <td>willy</td>
                    </tr>
                    <tr>
                        <td>2e</td>
                        <td>willy</td>
                    </tr>
                    <tr>
                        <td>3e</td>
                        <td>willy</td>
                    </tr>
                </table>
            </div>
        </div>
    );
}

export default Competitie;
