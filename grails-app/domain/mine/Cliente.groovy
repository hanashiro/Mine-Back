package mine
import grails.rest.*

@Resource(uri='/cliente', formats=['json', 'xml'])
class Cliente extends Pessoa {
	
	String nome
	String sexo
	String aniversario
	String anotacao
	String cpf
	
	static mapping = {
		discriminator value: "CLIENTE"
		sort "nome"
	}
}
