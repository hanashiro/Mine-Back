package mine
import grails.rest.*

@Resource(uri='/pessoa', formats=['json', 'xml'])
class Pessoa {
	
	Boolean ativo
	static hasMany = [contatos: Contato]
	static hasOne = [endereco: Endereco]

    static constraints = {
		ativo nullable:false
    }
	
	static mapping = {
		tablePerHierarchy false
	}
}
