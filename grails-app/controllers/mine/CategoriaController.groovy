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
		def categoria = new Categoria(params)
		if(categoria.save(flush:true)){
			response.status = 200
			render categoria as JSON
		} else {
			response.status = 400
			render categoria.errors as JSON
		}
	}
	
	def alterar() {
		def categoria = Categoria.get(params.id)
		if(categoria){
			categoria.properties = params
			if(categoria.save(flush:true)){
				response.status = 200
			} else {
				response.status = 400
				render categoria.errors as JSON
			}
		}
	}
	
	def desativar() {
		def categoria = Categoria.get(params.id)
		if (categoria){
			categoria.ativo = false
			if(categoria.save(flush:true)){
				response.status = 200
			} else {
				response.status = 400
				render categoria.errors as JSON
			}
		}
	}
}
