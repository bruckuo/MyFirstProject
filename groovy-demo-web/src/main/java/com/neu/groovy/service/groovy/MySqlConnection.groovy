package com.neu.groovy.service.groovy

import groovy.sql.Sql

/**
 * @description
 * @author guojiang.xiong@dmall.com
 * @since 2016-07-28 14:59
 */
class MySqlConnection {
    static void main(args) {
        def db_url="jdbc:MySql://m3308i.test.db.dmall.com:3308/dmall_cms?characterEncoding=UTF-8"
        def username="devtest"
        def password="WDevTest@Dmall"
        def driverClass="com.mysql.jdbc.Driver"
        def sql = Sql.newInstance(db_url, username, password, driverClass)
        sql.eachRow("SELECT * FROM CMS_TEMPLATE WHERE yn=1") {
            println it.id + ":" + it.name
        }
    }
}
