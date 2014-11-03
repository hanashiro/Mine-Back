package mine
import grails.rest.*

@Resource(uri='/pessoa', formats=['json', 'xml'])
class Pessoa {
	
	Boolean ativo
	static hasMany = [contatos: Contato]
	static hasOne = [endereco: Endereco]


<<<<<<< HEAD
    static constraints = {
		ativo nullable:false
    }
=======
>>>>>>> 153c8dcdf0aa06c32a592fc206c5af4437eaf8ff
	
	static mapping = {
		tablePerHierarchy false
	}
}
