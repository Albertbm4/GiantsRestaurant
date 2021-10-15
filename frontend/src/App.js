import './App.css';

import React, { useRef, useEffect, useState } from 'react';
import Simple from './COMPONENTS/carousel'
import "react-multi-carousel/lib/styles.css";
//const mapboxgl = require('react-mapbox-gl');
import mapboxgl from 'mapbox-gl'; 

export default function App() {
  const mapContainer = useRef(null);
  const map = useRef(null);
  const [lng, setLng] = useState(2.14);
  const [lat, setLat] = useState(41.38);
  const [zoom, setZoom] = useState(12);

  mapboxgl.accessToken = 'pk.eyJ1IjoiYWRyaWFsZW9uIiwiYSI6ImNrdXIzaDl3NzBnMWwyb2wwNXd3enN2aGgifQ.EO0AaoMf1sOhOxneYMBJBw';


  useEffect(() => {
    if (map.current) return; // initialize map only once
    map.current = new mapboxgl.Map({
      container: mapContainer.current,
      style: 'mapbox://styles/mapbox/streets-v11',
      center: [lng,lat],
      zoom: zoom
    });
    new mapboxgl.Marker().setLngLat([2.15, 41.40]).addTo(map);
  });

  

  return (
    

      <body> 
        <Simple /> 
        <div ref={mapContainer} className="map-container" style={{'height': 800}}/>

      </body>
    
  );
}


