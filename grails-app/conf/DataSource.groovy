dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    //dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	dialect = "mine.ImprovedMySQLDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
		show_sql=true
		loggingSql=true
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'create-drop', 'validate', ''
            url = "jdbc:mysql://localhost/mine?useUnicode=yes&characterEncoding=UTF-8"
            username = "root"
            password = "123"
        }
    }
    test {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:mysql://localhost/mine?useUnicode=yes&characterEncoding=UTF-8"
            username = "root"
            password = "123"
        }
    }
    production {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:mysql://localhost/mine?useUnicode=yes&characterEncoding=UTF-8"
            username = "root"
            password = "123"

        }
    }
}
