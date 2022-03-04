import React from "react";

function getF1Coureurs() {

    // constructor(props) {
    //     super(props);
    //
    //     this.state={
    //         coureurs: [],
    //         DataisLoaded: false
    //     };
    // }
    //
    // componentDidMount() {
    //     fetch(
    //         "localhost:8080/formula1/coureurs")
    //         .then((res) => res.json())
    //         .then((json) => {
    //             this.setState({
    //                 coureurs: json,
    //                 DataisLoaded: true
    //             });
    //         })
    // }

        return(
            <div>
                <h1>Henk Spencer</h1>
            </div>
        )

        //
        // const { DataisLoaded, coureurs} = this.state;
        // if (!DataisLoaded) return <div>
        //     <h1>Please wait, motherfucker!</h1>
        // </div>
        //
        // else return (
        //     <div>
        //         <h1>data fetched!</h1>
        //         {
        //             coureurs.map((coureur) => (
        //                 <ol key = {coureur.id} >
        //                     Name: {coureur.name}
        //                     Winfactor: {coureur.winfactor}
        //                 </ol>
        //             ))
        //         }
        //     </div>
        // )
    
}

export default getF1Coureurs;