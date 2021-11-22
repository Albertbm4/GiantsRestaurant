const { gql } = require("apollo-server");

const typeDefs = gql`
    type Restaurant {
        place_id: String!
        name: String!
        address: String!
        latitude: Float!
        longitude: Float!
        phone: String!
        status: Boolean!
        icon: String!
        rating: Float!
    }

    type Star {
        place_id: String!
        ponderation: Float!
    }

    type Query {
        getAllRestaurants: [Restaurant!]!
        getAllStars: [Star!]!
        getPonderationByPlaceName(place_id: String!): Star!
    }
`;

module.exports = typeDefs;