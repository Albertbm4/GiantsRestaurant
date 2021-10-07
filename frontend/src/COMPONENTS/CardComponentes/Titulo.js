import React from "react";
import {TypingStyle, ButtonStyle} from "./EstiloLetra";

const titulo = {

    fontSize:20,
    textAlign: 'center',
    color: 'white',



}


function Titulo(){

    return (
        <h1 style = {TypingStyle}> 
            Nombre Restaurante
        </h1>
    )

}


export default Titulo