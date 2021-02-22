const HttpStatus = require('http-status-codes');
const Client = require('../models/Client');

class ClientController {

  async findAll(req, res) {
	// res.json({test: 'pass'})
	   try {
		let allClients = await Client.findAll();
		res.status(HttpStatus.StatusCodes.OK).json(allClients);

	  } catch (error) {
		// console.log(`${error}`)
		res.status(HttpStatus.StatusCodes.BAD_REQUEST).json(error);
	  }
  }

  async findByEmail(req, res){
	  try {
		let {email} = req.params.email;
		let client = await Client.findOne({where: {email: email}})
		client ? res.status(HttpStatus.StatusCodes.OK).json(client) : res.status(HttpStatus.StatusCodes.NO_CONTENT);
	  } catch (error) {
		res.status(HttpStatus.StatusCodes.BAD_REQUEST).json(error);
	  }
  }

  async create(req, res){
	  try {
		  let {name, email} = req.body;
		  const client = await Client.create({
			name: name,
			email: email
		  });
		  res.status(HttpStatus.StatusCodes.CREATED).json(client)

	  } catch (error) {
		res.status(HttpStatus.StatusCodes.BAD_REQUEST).json(error);
	  }
  }

  async update(req, res){

  }

  async delete(req, res){

  }


}

module.exports = new ClientController();
