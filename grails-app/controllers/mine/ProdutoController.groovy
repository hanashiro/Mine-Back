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
		def produto = Produto.get(jsonObj.id)
		if(produto){
			produto.properties = jsonObj
			if(Produto.executeUpdate("Update mine.Produto set ativo=:nAtivo, categoria_id=:nCategoria, codigo_barras=:nCodigoBarras, descricao=:nDesc, estoque_minimo=:nEstoque, nome=:nNome, preco_entrada=:nPrecEnt, preco_saida=:nPrecSaida, quantidade=:nQtd where id=:nId", 
				[nAtivo: jsonObj.ativo, nCategoria: jsonObj.categoria.id, nCodigoBarras: jsonObj.codigoBarras, nDesc: jsonObj.descricao, nEstoque: jsonObj.estoqueMinimo, nNome: jsonObj.nome, nPrecEnt: Double.valueOf(jsonObj.precoEntrada), nPrecSaida: Double.valueOf(jsonObj.precoSaida), nQtd: Double.valueOf(jsonObj.quantidade), nId: Long.valueOf(jsonObj.id)])){
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
