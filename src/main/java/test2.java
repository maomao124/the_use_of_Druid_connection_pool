import java.sql.Connection;
import java.sql.SQLException;

/**
 * Project name(项目名称)：Druid连接池的使用
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/22
 * Time(创建时间)： 20:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test2
{
    public static void main(String[] args)
    {
        try
        {
            for (int i = 0; i < 151; i++)
            {
                Connection connection = Druid.getConnection();
                //System.out.println(connection);
                connection.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
