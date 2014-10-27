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
	
    static constraints = {
		/*razao nullable:false, blank:false
		nomeFantasia blank:false , nullable:false
		inscricaoMunicipal blank:true,  nullable:true
		cnpj blank:false, nullable:false*/
    }
}
