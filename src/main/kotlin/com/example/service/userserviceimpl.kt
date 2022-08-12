package com.example.service

import com.example.DatabseConnection.databasefactory.dbquery
import com.example.DatabseConnection.usertable
import com.example.models.user
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.statements.InsertStatement


class userserviceImpl : userservice {
    override suspend fun registeruser(params: CreateUserParams): user? {
        var statement: InsertStatement<Number>?=null
        dbquery{
            statement=usertable.insert {
                it[mail]=params.mail
                it[password]=params.password
                it[fullname]=params.fullname
                it[avatar]=params.avatar
            }


        }
        return rowtouser(statement?.resultedValues?.get(0))
    }

//     override suspend fun finduserbymail(mail: String): user? {
//        val user = dbquery { usertable.mail.eq(mail) }
//            .map { rowtouser(it)}.singleOrNull()
//    }
//    return user
}

private fun rowtouser(row: ResultRow?):user?{
    return if(row== null)null
    else user(

        avatar=row[usertable.avatar],
        name=row[usertable.fullname],
        mail=row[usertable.mail],
        password= row[usertable.password]

    )
}