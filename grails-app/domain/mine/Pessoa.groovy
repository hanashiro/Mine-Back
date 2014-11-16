package mine
import grails.rest.*

@Resource(uri='/pessoa', formats=['json', 'xml'])
class Pessoa {
	
	Boolean ativo
	static hasMany = [contato: Contato]
	static hasOne = [endereco: Endereco]

    static constraints = {
		ativo nullable:false
    }
}
