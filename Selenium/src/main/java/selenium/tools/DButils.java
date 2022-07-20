package selenium.tools;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 数据库的操作
 *
 * @ClassName: DButils
 * @Author: 阿达
 * @date: 2020年08月25日  09:18
 * @Description: TODO
 **/
public class DButils {

    private static String url;
    private static String userName;
    private static String passWord;

    /**
     *自动注册
     */
    static {
        init();
    }


    /**
     * 初始化方法：从属性文件加载出数据库连接信息、把驱动加载到jvm
     */
    //region 从属性文件加载出数据库连接信息、把驱动加载到jvm
    private static void init() {
//       从jdbc.properties配置文件中拿到属性
       /* Properties properties = new Properties();
        InputStream inputStream = DButils.class.getResourceAsStream("/settings.properties");
        try {
            properties.load(inputStream);

            url = properties.getProperty("jdbc_url");
            userName = properties.getProperty("jdbc_userName");
            passWord = properties.getProperty("jdbc_passWord");*/
        url = "jdbc:mysql://h128.ad99.cc:13309/dlcms_hospital?useSSL=false";
        userName = "root";
        passWord = "Ad123@546db";

//       装载Mysql驱动程序的Driver，安装驱动管理器DriverManager
//            String driverName = properties.getProperty("jdbc_driver");
        String driverName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("注册驱动找不到");
        }
    }
    //endregion


    /**
     * 获取数据库连接
     *
     * @return 返回连接对象
     */
    //region 获取数据库连接
    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("连接异常，请检验传入地址，账户和密码等信息");
        }
        return null;
    }
    //endregion


    /**
     * 增删改
     *
     * @param sql 要执行的sql语句
     */

    public static void excute(String sql) {
        Connection conn = null;
        Statement stmt = null;

        conn = getConnection();
//       获得陈述，描述要做的事情那么这个陈述对象就有执行查询、新增、修改删除等能力
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("sql执行异常，检查陈述对象或执行的语句");
        } finally {
            close(conn, stmt);
        }
    }

    /**
     * 查询
     * 如果查询的某个字段在数据库的类型为tinyint小整形，且查询出来的结果为1，jdbc会把它翻译为true
     *
     * @param sql 执行的sql语句,tinyint小整形字段表达为：name*1 as newName 乘以1变成int类型然后命名为别名，建议和原名一致
     * @return 返回查询结果集，LinkedHashMap有序链表
     */
    public static List<LinkedHashMap<String, Object>> excuteQuery(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
//      1.创建一个列表List里面是一个有序的链表LinkedHashMap，Key是string类型，value是Object
        List<LinkedHashMap<String, Object>> allResultSet = new ArrayList<LinkedHashMap<String, Object>>();
//       2.建立连接
        conn = getConnection();
//       3.获得陈述对象，陈述，描述要做的事情那么这个陈述对象就有执行查询、新增、修改删除等能力
        try {
            stmt = conn.createStatement();

//       4.执行sql语句，返回一个结果集（在内存中）
            resultSet = stmt.executeQuery(sql);
//       ---获得结果集的元数据（描述数据的数据，resultSet就是一个返回的数据，然后用getMetaData方法就可以获取这个数据的一些数据，比如得到resultSet的行数，列数这些数据，说以成为描述数据的数据也叫做元数据）
            ResultSetMetaData metaData = resultSet.getMetaData();
//       ---得到这个元数据的列数（有几个属性（有几列、字段））
            int columnCount = metaData.getColumnCount();

//       1：结果可能没有，1条或者多条，每条有1个字段和多个字段
//       移动游标，当查询的结果集中有一条元组（记录）就会返回true会一直执行while里面的内容直到移动到没有数据了返回false停止循环
            while (resultSet.next()) {
//           查询出来的每条记录都是一个map，如果查询3个属性如：select id,user,password from member;
//           那么每一次移动游标就会返回3列，id=aaa  user=bbb password=ccc,因此创建一个有序的map来保存每一此游标移动后的数据，目的是后面添加到list里面
                LinkedHashMap<String, Object> resultMap = new LinkedHashMap<String, Object>();
//           这一行有很多列表，现在要把列名作为key，对应记录的的列值作为map的值
//           动态获得记录的列数
//           循环所有列(jdbc列从1开始计算，这里也可以用0和<只要不超出最大列就可以)
                for (int i = 1; i <= columnCount; i++) {
//               metaData.getColumnLabel()或者每列的标签名，防止查询的时候如果有用as给列起别名，metaData.getColumnName()获得列名也就是数据库里面表属性名，如果有用别名的话还是会读取表属性名
                    String columnName = metaData.getColumnLabel(i);
                    Object colunValue = resultSet.getObject(i);
                    resultMap.put(columnName, colunValue);
                }
//           把个游标里面的map添加到list里面
                allResultSet.add(resultMap);
            }
            return allResultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(conn, stmt, resultSet);
        }
        return null;
    }

    /**
     * 关闭连接
     *
     * @param conn      连接对象
     * @param stmt      陈述对象
     * @param resultSet 结果集
     */
    private static void close(Connection conn, Statement stmt, ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        刚好和更新（增删改）的SQL关闭一样，就不重复写if判断直接调用
        close(conn, stmt);
    }

    /**
     * 关闭连接
     *
     * @param conn 连接对象
     * @param stmt 陈述对象
     */
    private static void close(Connection conn, Statement stmt) {
//        关闭资源（关闭陈述对象，关闭连接）
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
       /* List<LinkedHashMap<String, Object>> allResultSet = excuteQuery("select * from member");
        for (LinkedHashMap<String, Object> hashMap : allResultSet) {
            System.out.println(hashMap);
        }*/
//        excute("UPDATE member SET leave_amount ='2000' WHERE id = '1';");
    }
}
