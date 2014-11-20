package mine

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Fornecedor)
class FornecedorSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraints"() {
		when:
		def endereco = new Endereco()
		
		def fornecedor = new Fornecedor()
		fornecedor.nomeFantasia = 'fornecedor1'
		fornecedor.ativo = true
		fornecedor.endereco = endereco
		
		then:
		fornecedor.validate()
		!fornecedor.hasErrors()		
    }
}
