import { useQuery } from "@apollo/client";
import { useEffect, useState } from "react";
import Carousel from "react-multi-carousel";
import { GET_RESTAURANTS } from "../Schema/Queries";
//import {GET_STARS} from "../Schema/QueriesStar";
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

    /*,
    setStars(data.getAllStars)*/
// Because this is an inframe, so the SSR mode doesn't not do well here.
// It will work on real devices.
const SimpleCarousel = ({ deviceType }) => {

  const { loading, error, data } = useQuery(GET_RESTAURANTS);
  //const { loading2, error2, data2 } = useQuery(GET_STARS);
  const [restaurants, setRestaurants] = useState([]);
  const [stars, setStars] = useState([]);
  const [currentStar, setCurrentStar] = useState();

  useEffect(() => {
    if (data){ setRestaurants(data.getAllRestaurants)
    setStars(data.getAllStars)


    }
  }, [data]);


    const funCurrentStar = place_id => { return stars?.find(stars => stars.place_id === place_id).ponderation}
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
            rating= {funCurrentStar(restaurants[index].name)}
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

