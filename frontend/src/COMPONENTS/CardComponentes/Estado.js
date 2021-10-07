import React from "react";
import {TypingStyle, ButtonStyle} from "./EstiloLetra";

const rating = {

    fontSize:30,
    textAlign: 'center',
    color: 'green',
     
}


function Status(){

    return (
        <button style = {ButtonStyle}> 
            <div style= {TypingStyle}>
                Abierto
            </div>
        </button>
    )

}


export default Status