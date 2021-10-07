import Carousel from "react-multi-carousel";
import { Image } from "semantic-ui-react";
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
const restaurantes = [
  "a",
  "b",
  "c",
  "d",
  "e",
  "f",
  "g",
  "h",
  "i",
  "j",
  "k",
  "l"
];

// Because this is an inframe, so the SSR mode doesn't not do well here.
// It will work on real devices.
const SimpleCarousel = ({ deviceType }) => {
  return (
    <Carousel
      ssr
      partialVisbile
      deviceType={deviceType}
      responsive={responsive}
    >
      {restaurantes.slice(0, 7).map(image => { //el uso del .slice es basicamente para poder variar el numero de archivos que se acaban mapeando y poder asi hacer un carousel mas peque
        return (
          <div>

          <RestaurantCard> </RestaurantCard>
          
          </div>
        );
      })}
    </Carousel>
  );
};

export default SimpleCarousel;
