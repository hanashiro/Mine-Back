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
		def jsonObj = request.JSON
		println jsonObj
		def produto = new Produto(jsonObj)
		produto.precoSaida = Double.valueOf(jsonObj.precoSaida)
		produto.precoEntrada = Double.valueOf(jsonObj.precoEntrada)
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
			String desc = jsonObj.descricao == "null" ? null : jsonObj.descricao 
			String codBarras = jsonObj.codigoBarras == "null" ? null : jsonObj.codigoBarras
			String estMin = jsonObj.estoqueMinimo == "" ? "0" : jsonObj.estoqueMinimo
			String precEnt = jsonObj.precoEntrada == "" ? "0.0" : jsonObj.precoEntrada
			String precSaida = jsonObj.precoSaida == "" ? "0.0" : jsonObj.precoSaida
			String qtd = jsonObj.quantidade == "" ? "0.0" : jsonObj.quantidade
			if(Produto.executeUpdate("Update mine.Produto set categoria_id=:nCategoria, codigo_barras=:nCodigoBarras, descricao=:nDesc, estoque_minimo=:nEstoque, nome=:nNome, preco_entrada=:nPrecEnt, preco_saida=:nPrecSaida, quantidade=:nQtd where id=:nId", 
				[nCategoria: jsonObj.categoria.id, nCodigoBarras: codBarras, nDesc: desc, nEstoque: estMin, nNome: jsonObj.nome, nPrecEnt: Double.valueOf(precEnt), nPrecSaida: Double.valueOf(precSaida), nQtd: Double.valueOf(qtd), nId: Long.valueOf(jsonObj.id)])){
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
