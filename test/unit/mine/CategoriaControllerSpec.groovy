package mine

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CategoriaController)
@Mock(Categoria)
class CategoriaControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test cadastrar"() {
		when:	
		request.json = new Categoria(id:1,nome:'Categoria1',ativo:true)
		controller.cadastrar()
		
		then:
		response.json.nome == 'Categoria1'
		response.json.errors == null
	}
	
	/*
	void "test alterar"() {
		given:
		request.json = new Categoria(id:1,nome:'Categoria1',ativo:true)
		controller.cadastrar()
		
		when:
		request.json = new Categoria(id:1,nome:'Categoria2',ativo:true)
		controller.alterar()
		
		then:
		response.json.nome == 'Categoria2'
		response.json.errors == null
	}
	*/
}
