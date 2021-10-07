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

function Foto (){

    return (

        <img  
        src='https://images.unsplash.com/photo-1514933651103-005eec06c04b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3474&q=80'
        style= {foto}
        />
    )
}

export default Foto;
