import './App.css';
import RestaurantCard from './COMPONENTS/Card.js'
import React from 'react';
import Simple from './COMPONENTS/carousel'
import "react-multi-carousel/lib/styles.css";

const responsive = {
  desktop: {
    breakpoint: { max: 3000, min: 1024 },
    items: 3,
    slidesToSlide: 3 // optional, default to 1.
  },
  tablet: {
    breakpoint: { max: 1024, min: 464 },
    items: 2,
    slidesToSlide: 2 // optional, default to 1.
  },
  mobile: {
    breakpoint: { max: 464, min: 0 },
    items: 1,
    slidesToSlide: 1 // optional, default to 1.
  }
};




function App() {
  return (
    <div className="App">
      <header className="App-header"/>
      <body> 
        <Simple />  
      </body>
    </div>
  );
}





export default App;

