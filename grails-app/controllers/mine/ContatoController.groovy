package mine

import grails.converters.JSON;

class ContatoController {

    def search() {
		def contatos = Contato.findAllByContatoIlike("%" + params.valor + "%")
		render contatos as JSON
	}
}
