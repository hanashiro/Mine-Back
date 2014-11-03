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

<<<<<<< HEAD
    static constraints = {
		tipoLogradouro nullable:false, blank:false
		logradouro nullable:false, blank:false
		numero nullable:false, blank:false
		complemento nullable:true, blank:true
		zona nullable:false, blank:true
		bairro nullable:false, blank:false
		estado nullable:false, blank:false
		cidade nullable:false, blank:false
		cep nullable:true, blank:true
		coordenadas nullable:true, blank:true		
		referencia nullable:true, blank:true		
		pessoa nullable:false
    }
=======
>>>>>>> 153c8dcdf0aa06c32a592fc206c5af4437eaf8ff
}
