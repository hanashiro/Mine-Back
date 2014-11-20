package mine

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ClienteController)
@Mock([Cliente, Endereco, Contato])
class ClienteControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
		
	
	void "test cadastrar"() {
		when:
		def end = new Endereco(tipoLogradouro:'rua',logradouro:'rua1',numero:'123',zona:'zona1',
			bairro:'aqui',estado:'sp',cidade:'lorena')
		
		def cont = new Contato(tipo:'telefone',contato:'3159874521',categoria:'residencial')
		
		request.json = new Cliente(ativo:true,endereco:end,contato:cont,id:1,nome:'Cliente1',sexo:'M')
		controller.cadastrar()
		
		then:
		response.json.nome == 'Cliente1'
		response.json.errors == null
	}
	
	/*
	void "test alterar"() {
		given:
		def end = new Endereco(tipoLogradouro:'rua',logradouro:'rua1',numero:'123',zona:'zona1',
			bairro:'aqui',estado:'sp',cidade:'lorena')
		
		def cont = new Contato(tipo:'telefone',contato:'3159874521',categoria:'residencial')
		
		request.json = new Cliente(ativo:true,endereco:end,contato:cont,id:1,nome:'Cliente1',sexo:'M')
		controller.cadastrar()
		
		when:
		request.json = new Cliente(ativo:true,endereco:end,contato:cont,id:1,nome:'Cliente2',sexo:'F')
		controller.alterar()
		
		then:
		response.json.nome == 'Cliente2'
		response.json.errors == null
	}
	
	void "test desativar"() {
		given:
		def end = new Endereco(tipoLogradouro:'rua',logradouro:'rua1',numero:'123',zona:'zona1',
			bairro:'aqui',estado:'sp',cidade:'lorena')
		
		def cont = new Contato(tipo:'telefone',contato:'3159874521',categoria:'residencial')
		
		request.json = new Cliente(ativo:true,endereco:end,contato:cont,id:1,nome:'Cliente1',sexo:'M')
		controller.cadastrar()
		
		when:
		controller.desativar(id=1)
		
		then:
		response.json.errors == null
	}
	
	void "test buscaPorNome"() {
		given:
		def end = new Endereco(tipoLogradouro:'rua',logradouro:'rua1',numero:'123',zona:'zona1',
			bairro:'aqui',estado:'sp',cidade:'lorena')
		
		def cont = new Contato(tipo:'telefone',contato:'3159874521',categoria:'residencial')
		
		request.json = new Cliente(ativo:true,endereco:end,contato:cont,id:1,nome:'Cliente1',sexo:'M')
		controller.cadastrar()
		
		when:
		controller.buscaPorNome('Cliente1')
		
		then:
		response.json.nome == 'Cliente1'
	}
	*/

}
