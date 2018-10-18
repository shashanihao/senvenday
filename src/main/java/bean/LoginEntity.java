package bean;

public class LoginEntity {
    private int id;
    private String loginname;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
