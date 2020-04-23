package Dao;

import Entity.Account;
import Entity.HouseHolder;
import java.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    //传入账号对象 添加账号
    public boolean addAccount(Account account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            connection = JDBCUtils.getConncetion();
            String sql = "INSERT INTO account values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUname());
            preparedStatement.setString(2,account.getUpwd());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.close(connection, preparedStatement);
        }

        return result;
    }

    //根据用户名 删除账号
    public boolean deleteAccountByNumber(String uname){
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        boolean result = false;

        try {
            connection = JDBCUtils.getConncetion();

            String sql = "delete from account where uname = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,uname);
            int count = preparedStatement.executeUpdate();
            if(count>0){
                JDBCUtils.close(connection,preparedStatement);
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally{
            JDBCUtils.close(connection,preparedStatement);
        }
        return result;
    }

    //根据用户名 修改密码
    public boolean updatePassword(String uname,String upwd){
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        boolean result = false;

        try {
            connection = JDBCUtils.getConncetion();
            String sql = "update account set upwd = ? where uname = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,upwd);
            preparedStatement.setString(2,uname);
            int count = preparedStatement.executeUpdate();
            if(count>0){
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JDBCUtils.close(connection,preparedStatement);
        }
        return result;
    }

    //登录账号
    public boolean loginAccount(Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean result = false;

        try {
            connection = JDBCUtils.getConncetion();
            String sql = "SELECT * FROM account WHERE uname = ? and upwd = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUname());
            preparedStatement.setString(2,account.getUpwd());
            resultSet = preparedStatement.executeQuery();

            if (resultSet == null) { //账号或者密码错误
                throw new SQLException("账号或密码不存在");
            }
            if (resultSet.next()) { //登录账号
                String name = resultSet.getString("uname");
                String pwd = resultSet.getString("upwd");
                //封装
                account = new Account(name,pwd);
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return result;
    }

    //判断账户是否存在
    public boolean accountIsExist(Account account){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean result = false;

        try {
            connection = JDBCUtils.getConncetion();
            String sql = "SELECT * FROM account WHERE uname = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUname());
            resultSet = preparedStatement.executeQuery();

            if (resultSet == null) { //账号不存在 返回False
                throw new SQLException("账号或密码不正确");
            }
            if (resultSet.next()) { //账号存在 返回True
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return result;
    }

}
