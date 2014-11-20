package mine

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Pessoa)
class PessoaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraints"() {
		when:
		def endereco = new Endereco()
		
		def pessoa = new Pessoa()
		pessoa.ativo = true
		pessoa.endereco = endereco
		
		then:
		pessoa.validate()
		!pessoa.hasErrors()		
    }
}
