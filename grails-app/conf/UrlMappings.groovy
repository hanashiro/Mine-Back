class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		
		
		
		"/contato/$valor" {
			controller = 'contato'
			action = [GET: 'search']
		}
		
		"/cliente" (resources:'cliente')
		"/cliente/nome/$nome" {
			controller = 'cliente'
			action = [GET: 'buscaPorNome']
		}
		
		"/cliente/cadastrar"(parseRequest:true) {
			controller = 'cliente'
			action = [POST: 'cadastrar']
		}
		
		"/cliente/alterar" {
			controller = 'cliente'
			action = [PUT: 'alterar']
		}
		
		"/cliente/desativar" {
			controller = 'cliente'
			action = [PUT: 'desativar']
		}
		
		"/cliente/telefone/$telefone" {
			controller = 'cliente'
			action = [GET: 'buscaPorTelefone']
		}
		
		"/fornecedor" (resources:'fornecedor')
		"/fornecedor/nome/$nome" {
			controller = 'fornecedor'
			action = [GET: 'buscaPorNome']
		}
		
		"/fornecedor/cadastrar"(parseRequest:true) {
			controller = 'fornecedor'
			action = [POST: 'cadastrar']
		}
		
		"/fornecedor/alterar" {
			controller = 'fornecedor'
			action = [PUT: 'alterar']
		}
		
		"/fornecedor/desativar" {
			controller = 'fornecedor'
			action = [PUT: 'desativar']
		}
		
		"/categoria/buscaPorNome/$nome"{
			controller = 'categoria'
			action = [GET: 'buscaPorNome']
		}
		
		"/categoria/cadastrar"(parseRequest:true) {
			controller = 'categoria'
			action = [POST: 'cadastrar']
		}
		
		"/categoria/alterar" {
			controller = 'categoria'
			action = [PUT: 'alterar']
		}
		
		"/categoria/desativar" {
			controller = 'categoria'
			action = [PUT: 'desativar']
		}
	}
}
