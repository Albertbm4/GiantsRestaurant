const { RESTDataSource } = require('apollo-datasource-rest');

class RestaurantsAPI extends RESTDataSource {
  constructor() {
    // Always call super()
    super();
    // Sets the base URL for the REST API
    this.baseURL = '';
  }

  async getAllRestaurants() {
    // Send a GET request to the specified endpoint
    return this.get(`restaurants`);
  }
}

module.exports = RestaurantsAPI;