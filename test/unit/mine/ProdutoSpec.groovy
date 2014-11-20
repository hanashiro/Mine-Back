package mine

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Produto)
class ProdutoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test constraints"() {
		when:
		def categoria = new Categoria()
		
		def produto = new Produto()
		produto.nome = 'produto1'
		produto.ativo = true
		produto.categoria = categoria
		
		then:
		produto.validate()
		!produto.hasErrors()		
    }
}
