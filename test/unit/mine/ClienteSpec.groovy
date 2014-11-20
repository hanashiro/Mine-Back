package mine

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Cliente)
@TestMixin(GrailsUnitTestMixin )
class ClienteSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraints"() {
		when:
		def endereco = new Endereco()
		
		def cliente = new Cliente()
		cliente.nome = 'cliente1'
		cliente.sexo = 'M'
		cliente.ativo = true
		cliente.endereco = endereco
		
		then:
		cliente.validate()
		!cliente.hasErrors()		
    }
}
