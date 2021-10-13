import React from "react";
import {TypingStyle, ButtonStyle} from "./EstiloLetra";

const rating = {

    fontSize:30,
    textAlign: 'center',
    color: 'green',
     
}


function Status(props){

    if(props.status){
        var ButtonStyleOpt = {

    borderRadius: 15,
    width: '40%',
    marginLeft: '5%',
    marginRight: '5%',
    backgroundColor: 'red',
    borderWidth: 2,
    borderColor: 'black'
        };

        var textToShow = 'Closed'
    
    }else{
        var ButtonStyleOpt = {

            borderRadius: 15,
            width: '40%',
            marginLeft: '5%',
            marginRight: '5%',
            backgroundColor: 'green',
            borderWidth: 2,
            borderColor: 'black'
            
        };

        var textToShow = 'Opened';

        var tel = 'tel: ' + props.phone;
    }


console.log(props.status)

    return (
        <a href={tel} >
        <button style = {ButtonStyleOpt} > 
            <div style= {TypingStyle}>
            
                {textToShow}
                
            </div>
        </button>
        </a>
    )

}


export default Status