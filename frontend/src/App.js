import './App.css';
import RestaurantCard from './COMPONENTS/Card.js'
import React from 'react';
import Simple from './COMPONENTS/Carousel'
import "react-multi-carousel/lib/styles.css";
//const mapboxgl = require('react-mapbox-gl');
import mapboxgl from 'mapbox-gl'; 

function App() {
  return (
    

      <body> 
        <Simple /> 
        <div ref={mapContainer} className="map-container" style={{'height': 800}}/>

      </body>
    
  );
}


