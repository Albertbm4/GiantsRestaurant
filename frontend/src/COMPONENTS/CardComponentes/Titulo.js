import React from "react";
import {TypingStyle, ButtonStyle} from "./EstiloLetra";




function Titulo(props){
console.log(props.name);
    return (
        <h1 style = {TypingStyle}>
            {props.name} 
        </h1>
    )

}


export default Titulo