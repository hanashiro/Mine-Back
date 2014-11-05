package mine
import grails.rest.*

@Resource(uri='/cliente', formats=['json', 'xml'])
class Cliente extends Pessoa {
	
	String nome
	String sexo
	String aniversario
	String anotacao
	String cpf
	
    static constraints = {
		nome nullable:false, blank:false
		sexo nullable:false, blank:false, inList: ["F","M"]
		aniversario nullable:true, blank:true
		anotacao nullable:true, blank:true
		cpf nullable:true, blank:true		
    }
	
	static mapping = {
		discriminator value: "CLIENTE"
		sort "nome"
	}
}
