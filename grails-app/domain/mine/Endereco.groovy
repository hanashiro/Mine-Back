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

}
