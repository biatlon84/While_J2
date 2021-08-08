package com.mysql.ferst.test;

import java.util.ArrayList;

//systemctl stop mysql
//mysql_secure_installation
//>CREATE USER 'user_name'@'localhost' IDENTIFIED BY 'password';
//>GRANT ALL PRIVILEGES ON * . * TO 'user_name'@'localhost';
//systemctl start mysql
//>flush privileges;
//"Logging into MySQL server"
//mysql -u username –p 
//"Tnen enter password"
//>CREATE DATABASE database_name;
//>show databases;
//>use "databas_wich_you_want"
//>select * from ///
//>SELECT user,host FROM mysql.user;
//>select user();
//>create table users (id integer auto_increment primary key, name varchar(30), age integer);
//>insert into users (name, age) values ('Tom', 34);
//>select * from lib;
//>select * from lib where id = 4;
public class Main {

	public static void main(String args[]) {
		Connector cn = new Connector();

		// cn.setS("metro", 1884);

		ArrayList<String> rs = new ArrayList<String>(cn.getS("SELECT * FROM employee"));

		System.out.print(rs);
	}
}