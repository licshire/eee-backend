package club.zenyuca.eee.beans;

import club.zenyuca.core.template.BaseBean;
import java.io.Serializable;
import java.util.Date;

public class User extends BaseBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Integer id;
    /** 用户名称 */
    private String name;
    /** 密码 */
    private String pwd;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /** 最近一次登陆时间 */
    private Date loginTime;
    /** 最近一次登出时间 */
    private Date logoutTime;

}