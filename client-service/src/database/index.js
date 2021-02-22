const Sequelize = require('sequelize');

const Client = require('../app/models/Client');
const Address = require('../app/models/Address');
const databaseConfig = require('../config/database');

const models = [Client, Address];

class Database {
  constructor() {
    this.init();
  }

  init() {
    this.connection = new Sequelize(databaseConfig);
	console.log(databaseConfig)
    models
      .map((model) => model.init(this.connection))
    //   .map(
    //     (model) => model.associate && model.associate(this.connection.models)
    //   );

  }
}

module.exports = new Database();
