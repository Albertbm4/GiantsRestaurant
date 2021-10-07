import React from "react";
import {TypingStyle, ButtonStyle} from "./EstiloLetra";
import Rating from "react-rating";



const ratingStyle = {

    fontSize:30,
    textAlign: 'center',
    color: 'white',
}


function RatingButton(){

    return (
        <button style = {ButtonStyle} disabled>
            <div style= {TypingStyle}>
                *****
            </div>
        </button>
    )

}


export default RatingButton