import { gql } from '@apollo/client';

export const GET_STARS = gql `
query getPonderationByPlaceName( $place_id:String){
getPonderationByPlaceName(
        place_id: $place_id
        )

   }

`;