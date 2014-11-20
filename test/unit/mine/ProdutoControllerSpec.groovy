package mine

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ProdutoController)
@Mock([Produto, Categoria])
class ProdutoControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test cadastrar"() {
		when:	
		def cat = new Categoria(id:1,nome:'Categoria1',ativo:true)
		
		request.json = new Produto(id:1,nome:'Produto1',ativo:true,categoria:cat)
		controller.cadastrar()
		
		then:
		response.json.nome == 'Produto1'
		response.json.errors == null
	}
}
