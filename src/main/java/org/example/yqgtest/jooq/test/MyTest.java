package org.example.yqgtest.jooq.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.yqgtest.jooq.generated.Tables;
import org.example.yqgtest.jooq.generated.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 测试类
 * Created by jan on 2017/7/30.
 */
public class MyTest {

  @Data
  public static class Inner {
    private Integer id;
    @JsonProperty("first_name")
    private String name;
  }

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
      // 新增
//      create.insertInto(Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME).values("kai11", "zeng").
      AuthorRecord authorRecord = create.newRecord(Tables.AUTHOR);
//      authorRecord.setId(null);
      authorRecord.setFirstName("kai12");
      authorRecord.setLastName("zeng");
      authorRecord.store();
      // 更新
//      AuthorRecord authorRecord = create.selectFrom(Tables.AUTHOR).where(AUTHOR.ID.eq(3)).fetchOne();
//      authorRecord.setFirstName("first");
//      authorRecord.update();
      // 删除
//      AuthorRecord authorRecord = create.selectFrom(Tables.AUTHOR).where(AUTHOR.ID.eq(3)).fetchOne();
//      authorRecord.delete();
      // 查询
//      Inner inner = create.select(Tables.AUTHOR.ID, Tables.AUTHOR.FIRST_NAME).from(Tables.AUTHOR)
//          .where(AUTHOR.ID.eq(4)).fetchOne().into(Inner.class);
//      Integer id = inner.getId();
//      String name = inner.getName();
//
//      List<Inner> inners = create.select(Tables.AUTHOR.ID, Tables.AUTHOR.FIRST_NAME).from(Tables.AUTHOR)
//          .limit(1).fetchInto(Inner.class);
//      Object inner1 = inners.get(0);
    }
    // For the sake of this tutorial, let's keep exception handling simple
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}
