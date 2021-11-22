const resolvers = {
    Query: {
        getAllRestaurants: async (_, __, { dataSources }) => {
            return dataSources.restaurantAPI.getAllRestaurants();
        },

        getAllStars: async (_, __, { dataSources }) => {
            return dataSources.starsAPI.getAllStars();
        },

        getPonderationByPlaceName: async (_, { place_id }, { dataSources }) => {
          return dataSources.starsAPI.getPonderationByPlaceName(place_id)

        },

    },
};

module.exports = resolvers;