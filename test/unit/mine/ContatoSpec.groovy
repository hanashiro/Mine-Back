package mine

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Contato)
class ContatoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraints"() {
		when:
		def pessoa = new Pessoa()
		
		def contato = new Contato()
		contato.tipo = 'telefone'
		contato.contato = '3159874521'
		contato.categoria = 'residencial'
		contato.pessoa = pessoa
		
		then:
		contato.validate()
		!contato.hasErrors()		
    }
}
