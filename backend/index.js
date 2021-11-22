const { ApolloServer } = require('apollo-server');
const typeDefs = require('./Schema/TypesDefs');
const resolvers = require('./Schema/Resolvers');
const RestaurantAPI = require('./RestaurantsApi');
const StarsAPI = require('./StarsApi');

const server = new ApolloServer({
  typeDefs,
  resolvers,
  dataSources: () => ({
    restaurantAPI: new RestaurantAPI(),
    starsAPI: new StarsAPI()
  })
});

server.listen(port=3001).then(() => {
  console.log(`Server is running!`);
});