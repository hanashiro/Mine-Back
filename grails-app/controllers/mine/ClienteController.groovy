package mine

import grails.converters.JSON
import grails.rest.RestfulController;

class ClienteController extends RestfulController<Cliente>{

	static responseFormats = ['json', 'xml']
    ClienteController(){
		super(Cliente)
	}
	
	def buscaPorNome(String nome){
		def clientes = Cliente.findAllByNomeIlike("%" + nome + "%")
		render clientes as JSON
	}
	
	def buscaPorTelefone(String telefone){
		List<Cliente> clientes = Cliente.createCriteria().list{
			createAlias("contatos", "c")
			eq("c.contato", telefone)
			and{
				eq("c.tipo", "telefone")
			}
		}
		render clientes as JSON
	}
	
	def cadastrar(){
		def cliente = new Cliente(params)
		if(cliente.save(flush: true)){
			response.status = 200
			render cliente as JSON
		}else{
			response.status = 400
			render cliente.errors as JSON
		}
	}
	
	def alterar(){
		def cliente = Cliente.get(params.id)
		if(cliente){
			cliente.properties = params
			if(cliente.save(flush: true)){
				response.status = 200
				render cliente as JSON
			}else{
				response.status = 400
				render cliente.errors as JSON
			}
		}
	}
	
	def desativar(){
		def cliente = Cliente.get(params.id)
		if(cliente){
			cliente.ativo = !cliente.ativo
			if(cliente.save(flush: true)){
				response.status = 200
				render cliente as JSON
			}else{
				response.status = 400
				render cliente.errors as JSON
			}
		}
	}
}
