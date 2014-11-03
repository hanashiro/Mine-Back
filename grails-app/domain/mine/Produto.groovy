package mine
import grails.rest.*

@Resource(uri='/produto', formats=['json', 'xml'])
class Produto {
	
	String codigoBarras
	String nome
	String descricao
	String fabricante
	Double precoEntrada
	Double precoSaida
	Double quantidade
	Boolean ativo
	Double estoqueMinimo
	Double icms
	Categoria categoria
	static belongsTo = [categoria: Categoria]
	
    static constraints = {
		codigoBarras nullable:true, blank:true
		nome nullable:false, blank:false
		descricao nullable:true, blank:true
		fabricante nullable:true, blank:true
		precoEntrada nullable:true, blank:true
		precoSaida nullable:true, blank:true
		quantidade nullable:true, blank:true
		ativo nullable:false, blank:false
		estoqueMinimo nullable:true, blank:true
		icms nullable:true, blank:true
		categoria nullable:false
    }
	
	static mapping = {
		sort "nome"
	}
}
