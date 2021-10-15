import React from 'react';
import Foto from './CardComponentes/foto'
import Titulo from './CardComponentes/Titulo'
import RatingButton from './CardComponentes/rating';
import Status from './CardComponentes/Estado';


/*   E  S  T  I  L  O  S  */
const card = {
  maxWidth: '75%',
  margin:'auto',
  backgroundColor: 'grey',
  borderRadius: '20px'

}


export default function Card(props) {
  return (
    
    <div style= {card} border="true" border-dark="true">
      <Foto url = {props.icon}></Foto>
      <Titulo name ={props.name}></Titulo>
      <RatingButton rating = {props.rating}> </RatingButton>
      <Status status = {props.status} phone = {props.phone}></Status>
</div>
  );
}