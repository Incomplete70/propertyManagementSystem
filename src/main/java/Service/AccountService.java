package Service;

import Dao.AccountDao;
import Entity.Account;

//关于账号相关服务 组装Dao层
public class AccountService {
    AccountDao accountDao = new AccountDao();

    //账号登录
    public boolean login(Account account){
        if(accountDao.accountIsExist(account)==false){
            //账号不存在!
            return false;
        }
        if(accountDao.loginAccount(account)==false){
            //账号存在 但是密码错误
            return false;
        }else {
            //登陆成功
            return true;
        }
    }

    //注册(增加账号)

    //删除账号

    //修改账号密码




}

