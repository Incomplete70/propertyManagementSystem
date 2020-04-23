package Entity;
//登录账号实体类
public class Account {
    private String uname;        //用户名
    private String upwd;         //密码
    private String accountRights;//账户权限

    public Account(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public Account(String uname, String upwd, String accountRights) {
        this.uname = uname;
        this.upwd = upwd;
        this.accountRights = accountRights;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getAccountRights() {
        return accountRights;
    }

    public void setAccountRights(String accountRights) {
        this.accountRights = accountRights;
    }
}
