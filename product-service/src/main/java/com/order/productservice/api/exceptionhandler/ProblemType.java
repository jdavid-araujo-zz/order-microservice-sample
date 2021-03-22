package com.order.productservice.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	INVALID_DATA("/dados-invalidos", "Dados inválidos"),
	ACCESS_DENIED("/acesso-negado", "Acesso negado"),
	SYSTEM_ERROR("/erro-de-sistema", "Erro de sistema"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
	RESOURCE_NOT_FOUND("/recurso-nao-encontrado", "Resource not found"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio");
	
	private String title;

	ProblemType(String path, String title) {
		this.title = title;
	}
	
}
