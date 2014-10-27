package mine
import grails.rest.*

@Resource(uri='/endereco', formats=['json', 'xml'])
class Endereco {
	
	String tipoLogradouro
	String logradouro
	String numero
	String complemento
	String zona
	String bairro
	String estado
	String cidade
	String cep
	String coordenadas
	String referencia
	Pessoa pessoa
	static belongsTo = [pessoa:Pessoa]

    static constraints = {
		/*tipoLogradouro nullable:false, blank:false
		logradouro nullable:false, blank:false
		numero nullable:false, blank:false
		bairro nullable:false, blank:false
		estado nullable:false, blank:false
		cidade nullable:false, blank:false
		cep nullable:true, blank:true
		complemento nullable:true
		referencia nullable:true
		
		pessoa nullable:false*/
    }
}
