package mine

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(FornecedorController)
@Mock([Fornecedor, Contato, Endereco])
class FornecedorControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test cadastrar"() {
		when:
		def end = new Endereco(tipoLogradouro:'rua',logradouro:'rua1',numero:'123',zona:'zona1',
			bairro:'aqui',estado:'sp',cidade:'lorena')
		
		def cont = new Contato(tipo:'telefone',contato:'3159874521',categoria:'residencial')
		
		request.json = new Fornecedor(ativo:true,endereco:end,contato:cont,id:1,nomeFantasia:'Fornecedor1')
		controller.cadastrar()
		
		then:
		response.json.nomeFantasia == 'Fornecedor1'
		response.json.errors == null
	}
}
