const app = require("../../../src/app");
const request = require("supertest");



describe("Testes client", () => {

	it('Deve mostrar todos os clients', async () => {
		const response = await request(app).get("/clients");
		expect(response.statusCode).toBe(200);
   })

})


