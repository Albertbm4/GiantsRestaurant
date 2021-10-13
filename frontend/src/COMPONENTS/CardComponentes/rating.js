import React from "react";
import {TypingStyle, ButtonStyle} from "./EstiloLetra";
import Rating from "react-rating";



const ratingStyle = {

    fontSize:30,
    textAlign: 'center',
    color: 'white',
}




function RatingButton(props){

    return (
        <button style = {ButtonStyle} disabled>
            <div style= {TypingStyle}>
                {props.rating} <img src = "https://image.flaticon.com/icons/png/512/130/130188.png"  style= {{width:'25px'}} /> 
            </div>
        </button>
    )

}


export default RatingButton