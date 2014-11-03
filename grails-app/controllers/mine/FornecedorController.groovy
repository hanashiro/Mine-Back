package mine

import grails.converters.JSON
import grails.rest.RestfulController;


class FornecedorController extends RestfulController<Fornecedor> {

	static responseFormats = ['json', 'xml']
    FornecedorController(){
		super(Fornecedor)
	}
	
	def buscaPorNome(String nome){
		def fornecedores = Fornecedor.findAllByNomeFantasiaIlike("%" + nome + "%")
		render fornecedores as JSON
	}
	
	def cadastrar(){
		def fornecedor = new Fornecedor(params)
		if(fornecedor.save(flush: true)){
			response.status = 200
			render fornecedor as JSON
		}else{
			response.status = 400
			render fornecedor.errors as JSON
		}
	}
	
	def alterar(){
		def fornecedor = Fornecedor.get(params.id)
		if(fornecedor){
			fornecedor.properties = params
			if(fornecedor.save(flush: true)){
				response.status = 200
			}else{
				response.status = 400
				render fornecedor.errors as JSON
			}
		}
	}
	
	def desativar(){
		def fornecedor = Fornecedor.get(params.id)
		if(fornecedor){
			fornecedor.ativo = false
			if(fornecedor.save(flush: true)){
				response.status = 200
			}else{
				response.status = 400
				render fornecedor.errors as JSON
			}
		}
	}
}
