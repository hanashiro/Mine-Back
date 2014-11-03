package mine
import grails.rest.*

@Resource(uri='/contato', formats=['json', 'xml'])
class Contato {

	String tipo
	String contato
	String categoria
	Pessoa pessoa	
	static belongsTo = [pessoa:Pessoa]
	
    static constraints = {
		tipo nullable:false, blank:false
		contato nullable:false, blank:false
		categoria nullable:false, blank:false		
		pessoa nullable:false
    }
	
	static mapping = {
		sort "contato" //ordena por contato
	}
}
