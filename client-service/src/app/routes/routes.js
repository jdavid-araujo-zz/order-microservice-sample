const express = require('express');
const ClientController = require("../controllers/ClientController");
const AddressController = require("../controllers/AddressController");

const routes = express.Router();
routes.use(express.json());

routes.get("/clients",ClientController.findAll);
routes.get("/clients/:email", ClientController.findByEmail);
routes.post("/clients", ClientController.create);

module.exports = routes;
