const { RESTDataSource } = require('apollo-datasource-rest');

class StarsAPI extends RESTDataSource {
  constructor() {
    // Always call super()
    super();
    // Sets the base URL for the REST API
    this.baseURL = 'http://localhost:8080/api/';
  }

  async getAllStars(){
  return this.get(`stars`);
  }

  async getPonderationByPlaceName(place_id){
    return this.get(`stars/?id=${place_id}`)
  }

}

module.exports = StarsAPI;