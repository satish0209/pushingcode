package com.example.DatabseConnection

import org.jetbrains.exposed.sql.Table

object usertable: Table("users"){
    //  val id = integer("id")
    val fullname= varchar ("fullname",256)
    val mail = varchar("mail",256)
    //    val age = integer("age")
    val password = text("password")
    val avatar = text("avatar")

//    override val primaryKey=PrimaryKey(id)
}
