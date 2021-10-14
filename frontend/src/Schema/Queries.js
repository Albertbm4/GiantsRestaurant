import { gql } from '@apollo/client';

export const GET_RESTAURANTS = gql `
query {
    getAllRestaurants {
        place_id
        address
        name
        latitude
        longitude
        phone
        status
        icon
        rating
    }
}
`