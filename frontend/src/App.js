import './App.css';

import React, { useRef, useEffect, useState } from 'react';
import Simple from './COMPONENTS/carousel'
import "react-multi-carousel/lib/styles.css";
import mapboxgl from 'mapbox-gl'; 

const BCN_LNG = 2.14;
const BCN_LAT = 42.35;

export default function App() {
  const mapContainer = useRef(null);
  const map = useRef(null);
  const [lng, setLng] = useState(BCN_LNG);
  const [lat, setLat] = useState(BCN_LAT);
  const [zoom, setZoom] = useState(11);

  mapboxgl.accessToken = 'pk.eyJ1IjoiYWRyaWFsZW9uIiwiYSI6ImNrdXIzaDl3NzBnMWwyb2wwNXd3enN2aGgifQ.EO0AaoMf1sOhOxneYMBJBw';


  useEffect(() => {
    if (map.current) return; // initialize map only once
    map.current = new mapboxgl.Map({
      container: mapContainer.current,
      style: 'mapbox://styles/mapbox/streets-v11',
      center: [lng,lat],
      zoom: zoom
    });
  });

  return (
      <body> 
        <Simple /> 
        <div ref={mapContainer} className="map-container" style={{'height': 800}}/>
      </body>
  );
}