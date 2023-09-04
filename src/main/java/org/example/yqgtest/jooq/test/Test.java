package org.example.yqgtest.jooq.test;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.example.yqgtest.jooq.generated.tables.Author.AUTHOR;

/**
 * 测试类
 * Created by jan on 2017/7/30.
 */
public class Test {

  public static void main(String[] args) {
    // 用户名
    String userName = "root";
    // 密码
    String password = null;
    // mysql连接url
    String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";

    // Connection is the only JDBC resource that we need
    // PreparedStatement and ResultSet are handled by jOOQ, internally
    try (Connection conn = DriverManager.getConnection(url, userName, password)) {
      DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
      Result<Record> result = create.select().from(AUTHOR).fetch();

      for (Record r : result) {
        Integer id = r.getValue(AUTHOR.ID);
        String firstName = r.getValue(AUTHOR.FIRST_NAME);
        String lastName = r.getValue(AUTHOR.LAST_NAME);

        /**
         * 控制台输出
         * ID: 1 first name: 3 last name: zhang
         * ID: 2 first name: 4 last name: li
         */
        System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
      }
    }
    // For the sake of this tutorial, let's keep exception handling simple
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}
