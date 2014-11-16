package mine

import org.codehaus.groovy.grails.web.json.JSONObject;

import grails.converters.JSON
import grails.rest.RestfulController;

class ClienteController extends RestfulController<Cliente>{

	static responseFormats = ['json', 'xml']
    ClienteController(){
		super(Cliente)
	}
	
	def buscaPorNome(String nome){
		def clientes = Cliente.createCriteria().list{
			ilike("nome", "%" + nome + "%")
		}
		for(cliente in clientes){
			buscarContatos(cliente)
		}
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
		def jsonObj = request.JSON
		println jsonObj
		def cliente = new Cliente(jsonObj)
		cliente.contato = null
		if(cliente.save(flush: true)){
			for (cont in jsonObj.contato) {
				Contato contato = new Contato()
				contato.tipo = cont.tipo
				contato.contato = cont.contato
				contato.categoria = cont.categoria
				contato.pessoa = cliente
				contato.save(flush:true)
			}
			response.status = 200
			render cliente as JSON
		}else{
			response.status = 400
			render cliente.errors as JSON
		}
	}
	
	def alterar(){
		def jsonObj = request.JSON
		def cliente = Cliente.get(jsonObj.id)
		if(cliente){
			atualizarContatos(cliente, jsonObj)
			cliente.properties = jsonObj
			cliente.contato = null
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
	
	def buscarContatos(Cliente cliente){
		def contatos = Contato.createCriteria().list{
			eq("pessoa.id", cliente.id)
		}
		cliente.contato = contatos
	}
	
	def atualizarContatos(Cliente cliente, JSONObject jsonObj){
		if(jsonObj.contato.size() < cliente.contato.size()){
			buscarContatos(cliente)
			HashSet<Contato> remover = new HashSet<Contato>()
			for(contato in jsonObj.contato){
				Contato cont = Contato.get(contato.id)
				remover.add(cont)
			}
			cliente.contato.removeAll(remover)
			for(con in cliente.contato){
				Contato.executeUpdate("Delete from mine.Contato where id = ?", [con.id])
			}
		}else if(jsonObj.contato.size() > cliente.contato.size()){
			for(cont in jsonObj.contato){
				if(cont.id == null){
					Contato contato = new Contato()
					contato.tipo = cont.tipo
					contato.contato = cont.contato
					contato.categoria = cont.categoria
					contato.pessoa = cliente
					contato.save(flush:true)
				}
			}
		}
	}
}
