import React from "react";

const foto = {

    maxWidth: '80%',
    borderRadius: '20px',
    position: 'top',
    paddingLeft: '5%',
    paddingTop: '5%',
    borderColor: 'white',
    borderWidth: '5px',
    

}

function Foto (props){
console.log(props.url);
    return (

        <img  
        src={props.url}
        style= {foto}
        />
    )
}

export default Foto;
