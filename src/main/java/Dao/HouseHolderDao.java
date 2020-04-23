package Dao;


import Entity.HouseHolder;
import Utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//数据访问层:原子性的增删改查

public class HouseHolderDao {

    //传入户主对象 增加户主
    public boolean addHouseHolder(HouseHolder houseHolder){
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            connection = JDBCUtils.getConncetion();

            String sql = "INSERT INTO householders values (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, houseHolder.getHouseHolderNumber());
            preparedStatement.setString(2, houseHolder.getHouseHoldername());
            preparedStatement.setInt(3, houseHolder.getHouseHolderId());
            int count = preparedStatement.executeUpdate();
            if(count>0) {
                JDBCUtils.close(connection, preparedStatement);
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
        //根据户号 删除户主
    public boolean deleteHouseHolderByNumber(int number){
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            connection = JDBCUtils.getConncetion();

            String sql = "delete from householders where houseHolderNumber = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,number);

            int count = preparedStatement.executeUpdate();
            if(count>0){
                JDBCUtils.close(connection,preparedStatement);
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    //根据户号 找到待修改的住户 把这个住户改成新的HouseHolder对象
    public boolean updateHouseHolderByNumber(int number, HouseHolder houseHolder){
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            connection = JDBCUtils.getConncetion();

            String sql = "update householders set houseHolderNumber= ? , houseHolderName = ? , houseHolderId= ? where houseHolderNumber = ?";
            preparedStatement = connection.prepareStatement(sql);
            //修改后的内容
            preparedStatement.setInt(1, houseHolder.getHouseHolderNumber());
            preparedStatement.setString(2, houseHolder.getHouseHoldername());
            preparedStatement.setInt(3, houseHolder.getHouseHolderId());
            //修改谁
            preparedStatement.setInt(4,number);

            int count = preparedStatement.executeUpdate();
            if(count>0){
                JDBCUtils.close(connection,preparedStatement);
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }

    //根据户号查询人是否存在 存在true 不存在false
    public boolean isExist(int number){
        if(queryHouseHolderByNumber(number)==null){
            return false;
        }else {
            return true;
        }
    }

    //查询全部户主
    public List<HouseHolder> queryAllHouseHolders(){
        List<HouseHolder> houseHolders = new ArrayList<>();
        HouseHolder houseHolder = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConncetion();
            String sql = "SELECT * FROM householders ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet == null) {
                System.out.println("结果集为空!");
                return null;
            }

            while (resultSet.next()) {
                int houseHolderNumber = resultSet.getInt("houseHolderNumber");
                String houseHolderName = resultSet.getString("houseHolderName");
                int houseHolderId = resultSet.getInt("houseHolderId");
                Double waterBalance = resultSet.getDouble("waterBalance");
                Double electricityBalance = resultSet.getDouble("electricityBalance");

                //Date chenckIndate = resultSet.getDate("checkInDate"); //入住日期 先不做

                houseHolder = new HouseHolder(houseHolderNumber,houseHolderName,houseHolderId);
                houseHolders.add(houseHolder);
            }
            return houseHolders;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    //根据姓名查询
    //根据身份证查询

    //根据户号 查询户主
    public HouseHolder queryHouseHolderByNumber(int number){
        HouseHolder houseHolder = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConncetion();
            String sql = "SELECT * FROM householders WHERE houseHolderNumber = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, number);
            resultSet = preparedStatement.executeQuery();

            if (resultSet == null) {
                System.out.println("结果集为空!");
                return null;
            }

            if (resultSet.next()) {
                int houseHolderNumber = resultSet.getInt("houseHolderNumber");
                String houseHolderName = resultSet.getString("houseHolderName");
                int houseHolderId = resultSet.getInt("houseHolderId");
                Double waterBalance = resultSet.getDouble("waterBalance");
                Double electricityBalance = resultSet.getDouble("electricityBalance");

                //Date chenckIndate = resultSet.getDate("checkInDate"); //入住日期 先不做

                houseHolder = new HouseHolder(houseHolderNumber,houseHolderName,houseHolderId,waterBalance,electricityBalance);
                return houseHolder;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }




}
