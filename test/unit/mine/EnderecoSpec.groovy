package mine

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Endereco)
class EnderecoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraints"() {
		when:
		def pessoa = new Pessoa()
		
		def endereco = new Endereco()
		endereco.tipoLogradouro = 'tipo'
		endereco.logradouro = 'rua tal'
		endereco.numero = '123'
		endereco.zona = 'zona1'
		endereco.bairro = 'bairro tal'
		endereco.estado = 'sp'
		endereco.cidade = 'lorena'
		endereco.pessoa = pessoa
		
		then:
		endereco.validate()
		!endereco.hasErrors()		
    }
}
