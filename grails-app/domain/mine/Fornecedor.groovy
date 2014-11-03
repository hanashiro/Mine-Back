package mine
import grails.rest.*

@Resource(uri='/fornecedor', formats=['json', 'xml'])
class Fornecedor extends Pessoa {
	
	String razao
	String nomeFantasia
	String inscricaoEstadual
	String inscricaoMunicipal
	String cnpj

	
	static mapping = {
		discriminator value: "FORNECEDOR"
		sort "nome"
	}
	
<<<<<<< HEAD
    static constraints = {
		razao nullable:true, blank:true
		nomeFantasia blank:false , nullable:false
		inscricaoEstadual blank:true,  nullable:true
		inscricaoMunicipal blank:true,  nullable:true
		cnpj blank:false, nullable:false
    }
=======
>>>>>>> 153c8dcdf0aa06c32a592fc206c5af4437eaf8ff
}
