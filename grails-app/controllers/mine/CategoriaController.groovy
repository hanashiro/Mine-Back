package mine

import grails.converters.JSON
import grails.rest.RestfulController;

class CategoriaController extends RestfulController<Categoria> {
	
	static responseFormats = ['json', 'xml']
	CategoriaController(){
		super(Categoria)
	}
	
	def buscaPorNome() {
		def categorias = Categoria.findAllByNomeIlike("%" + params.nome + "%")
		render categorias as JSON
	}
	
	def cadastrar() {
		def jsonObj = request.JSON
		def categoria = new Categoria(jsonObj)
		if(categoria.save(flush:true)){
			response.status = 200
			render categoria as JSON
		} else {
			response.status = 400
			render categoria.errors as JSON
		}
		
	}
	
	def alterar() {
		def jsonObj = request.JSON
		def categoria = Categoria.get(jsonObj.id)
		if(categoria){
			categoria.properties = jsonObj
			if(categoria.save(flush:true)){
				response.status = 200
				render categoria as JSON
			} else {
				response.status = 400
				render categoria.errors as JSON
			}
		}
	}
	
	def desativar() {
		def categoria = Categoria.get(params.id)
		if (categoria){
			categoria.ativo = !categoria.ativo
			if(categoria.save(flush:true)){
				response.status = 200
				render categoria as JSON
			} else {
				response.status = 400
				render categoria.errors as JSON
			}
		}
	}
}
