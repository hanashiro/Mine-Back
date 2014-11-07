package mine

import grails.converters.JSON
import grails.rest.RestfulController;

class ProdutoController extends RestfulController<Produto> {

	static responseFormats = ['json', 'xml']
	ProdutoController(){
		super(Produto)
	}
	
	def buscaPorNome(String nome){
		def produtos = Produto.findAllByNomeIlike("%" + nome + "%")
		render produtos as JSON
	}
	
	def buscaPorCodigoBarras(String cdbarras){
		def produtos = Produto.findAllByCodigoBarrasIlike("%" + cdbarras + "%")
		render produtos as JSON
	}
	
	def buscaPorEstoque(){
		List<Produto> produtos = Produto.createCriteria().list{
			leProperty("quantidade", "estoqueMinimo")
		}
		render produtos as JSON
	}
	
	def cadastrar(){
		def produto = new Produto(params)
		if(produto.save(flush: true)){
			response.status = 200
			render produto as JSON
		}else{
			response.status = 400
			render produto.errors as JSON
		}
	}
	
	def alterar(){
		def jsonObj = request.JSON
		def produto = Produto.get(params.id)
		if(produto){
			produto.properties = jsonObj.params
			if(produto.save(flush: true)){
				response.status = 200
				render produto as JSON
			}else{
				response.status = 400
				render produto.errors as JSON
			}
		}
	}
	
	def desativar(){
		def produto = Produto.get(params.id)
		if(produto){
			produto.ativo = !produto.ativo
			if(produto.save(flush: true)){
				response.status = 200
				render produto as JSON
			}else{
				response.status = 400
				render produto.errors as JSON
			}
		}
	}
}
