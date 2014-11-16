package mine

import org.codehaus.groovy.grails.web.json.JSONObject;

import grails.converters.JSON
import grails.rest.RestfulController;


class FornecedorController extends RestfulController<Fornecedor> {

	static responseFormats = ['json', 'xml']
    FornecedorController(){
		super(Fornecedor)
	}
	
	def buscaPorNome(String nome){
		def fornecedores = Fornecedor.createCriteria().list{
			ilike("nomeFantasia", "%" + nome + "%")
		}
		for(fornecedor in fornecedores){
			buscarContatos(fornecedor)
		}
		render fornecedores as JSON
	}
	
	def cadastrar(){
		def jsonObj = request.JSON
		println jsonObj
		def fornecedor = new Fornecedor(jsonObj)
		fornecedor.contato = null
		if(fornecedor.save(flush: true)){
			for (cont in jsonObj.contato) {
				Contato contato = new Contato()
				contato.tipo = cont.tipo
				contato.contato = cont.contato
				contato.categoria = cont.categoria
				contato.pessoa = fornecedor
				contato.save(flush:true)
			}
			response.status = 200
			render fornecedor as JSON
		}else{
			response.status = 400
			render fornecedor.errors as JSON
		}
	}
	
	def alterar(){
		def jsonObj = request.JSON
		def fornecedor = Fornecedor.get(jsonObj.id)
		if(fornecedor){
			atualizarContatos(fornecedor, jsonObj)
			fornecedor.properties = jsonObj
			fornecedor.contato = null
			if(fornecedor.save(flush: true)){
				response.status = 200
				render fornecedor as JSON
			}else{
				response.status = 400
				render fornecedor.errors as JSON
			}
		}
	}
	
	def desativar(){
		def fornecedor = Fornecedor.get(params.id)
		if(fornecedor){
			fornecedor.ativo = !fornecedor.ativo
			if(fornecedor.save(flush: true)){
				response.status = 200
				render fornecedor as JSON
			}else{
				response.status = 400
				render fornecedor.errors as JSON
			}
		}
	}
	
	def buscarContatos(Fornecedor fornecedor){
		def contatos = Contato.createCriteria().list{
			eq("pessoa.id", fornecedor.id)
		}
		fornecedor.contato = contatos
	}
	
	def atualizarContatos(Fornecedor fornecedor, JSONObject jsonObj){
		if(jsonObj.contato.size() < fornecedor.contato.size()){
			buscarContatos(fornecedor)
			HashSet<Contato> remover = new HashSet<Contato>()
			for(contato in jsonObj.contato){
				Contato cont = Contato.get(contato.id)
				remover.add(cont)
			}
			fornecedor.contato.removeAll(remover)
			for(con in fornecedor.contato){
				Contato.executeUpdate("Delete from mine.Contato where id = ?", [con.id])
			}
		}else if(jsonObj.contato.size() > fornecedor.contato.size()){
			for(cont in jsonObj.contato){
				if(cont.id == null){
					Contato contato = new Contato()
					contato.tipo = cont.tipo
					contato.contato = cont.contato
					contato.categoria = cont.categoria
					contato.pessoa = fornecedor
					contato.save(flush:true)
				}
			}
		}
	}
}
