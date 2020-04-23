package Service;

import Dao.HouseHolderDao;
import Entity.HouseHolder;

import java.util.List;

//业务逻辑层:逻辑性的增删改查(增:查+增 ),对Dao层进行的组装
public class HouseHolderService {
    HouseHolderDao houseHolderDao = new HouseHolderDao();

    //增加户主
    public boolean addHouseHolder(HouseHolder houseHolder){
        //判断户主是否存在
        if(houseHolderDao.isExist(houseHolder.getHouseHolderNumber())){  //存在就报已经存在
            System.out.println("户主已经存在");
            return false;
        }else {//不存在就添加
            houseHolderDao.addHouseHolder(houseHolder);
            System.out.println("HouseHolderService:添加成功");
            return true;
        }
    }

    //删除户主
    public boolean deleteHouseHolderByNumber(int number){
        if(houseHolderDao.isExist(number)){
            return houseHolderDao.deleteHouseHolderByNumber(number);
        }else {
            return false;
        }
    }

    //修改户主
    public boolean updateHouseHolderByNumber(int number, HouseHolder houseHolder){
        if(houseHolderDao.isExist(number)){
            return houseHolderDao.updateHouseHolderByNumber(number, houseHolder);
        }else {
            return false;
        }
    }

    //根据学号查询一个户主
    public HouseHolder queryHouseHolderByNumber(int number){
        return houseHolderDao.queryHouseHolderByNumber(number);
    }

    //查询所有户主
    public List<HouseHolder> queryAllHouseHolders(){
        return houseHolderDao.queryAllHouseHolders();
    }

}
