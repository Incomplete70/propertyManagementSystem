package Service;

import Dao.AccountDao;
import Entity.Account;

//关于账号相关服务 组装Dao层
public class AccountService {
    AccountDao accountDao = new AccountDao();


    /*账号登录 返回int值
    * -1:账号不存在
    * 0:账号存在,但是密码错误
    * 1:账号密码都正确,登陆成功
    * */
    public int login(Account account){
        if(accountDao.accountIsExist(account)==false){
            return -1;
        }
        if(accountDao.loginAccount(account)==false){
            return 0;
        }else {
            return 1;
        }
    }

    //注册(增加账号)

    //删除账号

    //修改账号密码




}

