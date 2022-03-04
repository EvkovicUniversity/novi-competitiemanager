// fetchMeTheirSouls(){
//     fetch('localhost:8080/formula1/coureurs')
//         .then(response => {
//             const users = response.json();
//             this.setState({users})
//         })
//         .catch(err=> {
//             throw new Error(err)
//         })
// }

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

// import React from "react";
//
// class LoginPage extends React.Component {
//     constructor(props) {
//         super(props);
//
//         this.state={
//             coureurs: [],
//             DataisLoaded: false
//         };
//     }

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