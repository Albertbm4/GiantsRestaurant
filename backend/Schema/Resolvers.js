const resolvers = {
    Query: {
        getAllRestaurants: async (_, __, { dataSources }) => {
            return dataSources.restaurantAPI.getAllRestaurants();
        }
    }
};

module.exports = resolvers;