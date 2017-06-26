package com.chicootec.dbcomparator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Util {
  public static Set<String> compare(Connection connSrc, Connection connDest) throws Exception {
    Map<String, MetadataTable> src = getTableMetadata(connSrc);
    Map<String, MetadataTable> dest = getTableMetadata(connDest);

    Set<String> set = src.keySet();

    Set<String> res = new TreeSet<>();

    for (String str : set) {
      MetadataTable tmDest = (MetadataTable) dest.get(str);
      if (tmDest == null) {
        res.add("不存在：" + str);
      } else {
        MetadataTable tmSrc = (MetadataTable) src.get(str);
        boolean eq = tmSrc.equals(tmDest);
//        System.out.println(eq + ":" + tmSrc + "=" + tmDest);
        if (eq) {
          res.add("一致：" + str);
        } else {
          res.add(str + "正确的：" + tmSrc);
          res.add(str + "错误的：" + tmDest + System.lineSeparator());
        }
      }
    }
    return res;
  }

  public static Map<String, MetadataTable> getTableMetadata(Connection conn) throws Exception {
    Map<String, MetadataTable> map = new HashMap<>();
    DatabaseMetaData meta = conn.getMetaData();
    ResultSet tableRet = meta.getTables(null, null, null, null);
    while (tableRet.next()) {
      String tableName = tableRet.getString("TABLE_NAME");
      ResultSet colRet = meta.getColumns(null, null, tableName, null);

      MetadataTable tm = new MetadataTable();
      tm.setTableName(tableName);

      List<MetadataColumn> colMetas = new ArrayList<>();

      while (colRet.next()) {
        int columnSize = colRet.getInt("COLUMN_SIZE");
        String columnType = colRet.getString("TYPE_NAME");
        String columnName = colRet.getString("COLUMN_NAME");

        MetadataColumn cm = new MetadataColumn(columnName, columnType, columnSize);
        colMetas.add(cm);
      }
      tm.setCols(colMetas);

      map.put(tableName, tm);
    }

    return map;
  }

  public static Connection getConn(DbCfg dbcfg) {
    try {
      return DriverManager.getConnection(dbcfg.getUrl(), dbcfg.getUserName(), dbcfg.getPassword());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void close(AutoCloseable ac) {
    if (ac == null)
      return;
    try {
      ac.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    ac = null;
  }
}
