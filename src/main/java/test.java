import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project name(项目名称)：Druid连接池的使用
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/22
 * Time(创建时间)： 20:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void main(String[] args)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            connection = Druid.getConnection();
            //编写sql语句
            String sql = "select * from information";
            //获得一个prepareStatement对象,预编译
            preparedStatement = connection.prepareStatement(sql);
            //传递参数

            //执行sql语句，返回结果集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                System.out.println("学号：" + resultSet.getInt("no") + "\t" + "姓名：" + resultSet.getString("name") + "\t" + "性别："
                        + resultSet.getString("sex") + "\t" + "年龄：" + resultSet.getInt("age"));
            }
        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            Druid.close(connection, preparedStatement, resultSet);
        }
    }
}
