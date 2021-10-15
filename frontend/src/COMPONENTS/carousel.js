import { useQuery } from "@apollo/client";
import { useEffect, useState } from "react";
import Carousel from "react-multi-carousel";
import { GET_RESTAURANTS } from "../Schema/Queries";
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

  const { loading, error, data } = useQuery(GET_RESTAURANTS);
  const [restaurants, setRestaurants] = useState([]);

  useEffect(() => {
    if (data) setRestaurants(data.getAllRestaurants)
  }, [data]);

  return (
    <Carousel
      ssr
      partialVisbile
      deviceType={deviceType}
      responsive={responsive}
    >
      {restaurants.map((i, index) => { 
        return (
          <div>
            <RestaurantCard 
            name= {restaurants[index].name}
            icon= {restaurants[index].icon}
            rating= {restaurants[index].rating}
            status={restaurants[index].status}
            phone = {restaurants[index].phone}
            />
          </div>
        );
      })}
    </Carousel>
  );
};

export default SimpleCarousel;

