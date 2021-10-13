import Carousel from "react-multi-carousel";
import { Image } from "semantic-ui-react";
import dataRest from '../data';
import RestaurantCard from './Card';
const responsive = {
  desktop: {
    breakpoint: { max: 3000, min: 1024 },
    items: 3,
    paritialVisibilityGutter: 60
  },
  tablet: {
    breakpoint: { max: 1024, min: 464 },
    items: 2,
    paritialVisibilityGutter: 50
  },
  mobile: {
    breakpoint: { max: 464, min: 0 },
    items: 1,
    paritialVisibilityGutter: 30
  }
};

// Because this is an inframe, so the SSR mode doesn't not do well here.
// It will work on real devices.
const SimpleCarousel = ({ deviceType }) => {



console.log(dataRest[1].name)

  return (
    <Carousel
      ssr
      partialVisbile
      deviceType={deviceType}
      responsive={responsive}
    >

      {dataRest.map((i, index) => { 

console.log(dataRest[index].name);
return (
          <div>

          <RestaurantCard 
          name= {dataRest[index].name}
          icon= {dataRest[index].icon}
          rating= {dataRest[index].rating}
          status={dataRest[index].status}
          phone = {dataRest[index].phone}
          > </RestaurantCard>
          
          </div>
        );
      })}
    </Carousel>
  );
};

export default SimpleCarousel;

