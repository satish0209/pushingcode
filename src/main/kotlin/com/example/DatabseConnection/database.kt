package com.example.DatabseConnection

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object databasefactory {
    fun init() {
        Database.connect(hikari())
        transaction {
            SchemaUtils.create(usertable)
        }
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = "jdbc:postgresql:postgres?user=bommidisatish&password=1234"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)
    }

    suspend fun <T> dbquery(block: () -> T): T = withContext(Dispatchers.IO) {
        transaction {
            block()
        }

    }

}

//private fun SchemaUtils.create(tables: String) {
//
//}



