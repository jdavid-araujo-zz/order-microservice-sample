const Sequelize = require('sequelize');
const { Model } = require('sequelize');

class Address extends Model {
  static init(sequelize) {
    super.init(
      {
        country: Sequelize.STRING,
        city: Sequelize.STRING,
        postal: Sequelize.STRING,
        streetHouse: Sequelize.STRING,
      },
      {
        sequelize,
      }
    );

    return this;
  }

  static associate(models) {
    this.belongsTo(models.Client, { foreignKey: 'client_id', as: 'client' });
  }
}

module.exports = Address;
