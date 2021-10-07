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


export default function App() {
  return (
    
    <div style= {card} border="true" border-dark="true">
      <Foto></Foto>
      <Titulo></Titulo>
      <RatingButton> </RatingButton>
      <Status></Status>
</div>
  );
}