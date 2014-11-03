package mine
import grails.rest.*

@Resource(uri='/cliente', formats=['json', 'xml'])
class Cliente extends Pessoa {
	
	String nome
	String sexo
	String aniversario
	String anotacao
	String cpf
	
<<<<<<< HEAD
    static constraints = {
		nome nullable:false, blank:false
		sexo nullable:false, blank:false, inList: ["feminino","masculino"]
		aniversario nullable:true, blank:true
		anotacao nullable:true, blank:true
		cpf nullable:true, blank:true		
    }
	
=======
>>>>>>> 153c8dcdf0aa06c32a592fc206c5af4437eaf8ff
	static mapping = {
		discriminator value: "CLIENTE"
		sort "nome"
	}
}
