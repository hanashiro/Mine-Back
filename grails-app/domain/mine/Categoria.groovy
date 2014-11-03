package mine
import grails.rest.*

@Resource(uri='/categoria', formats=['json', 'xml'])
class Categoria {
	
	String nome
	Boolean ativo
	static hasMany = [produtos:Produto]

    static constraints = {
		nome nullable:false, blank:false
		ativo nullable:false, blank:false
    }
	
	static mapping = {
		sort "nome"
	}
}
