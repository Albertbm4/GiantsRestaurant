const resolvers = {
    Query: {
        getAllRestaurants: async (_, __, { dataSources }) => {
            return dataSources.restaurantsAPI.getAllRestaurants();
        }
    }
};

export default resolvers;