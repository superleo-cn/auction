package models;

import com.avaje.ebean.Ebean;
import forms.LoginForm;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.validation.Constraints.Required;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User {

    final static Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    private Long id;

    @Required(message = "Username cannot be empty")
    private String username;

    private String password;

    private String mobile;

    private String email;

    private String realname;

    @Required(message = "User type cannot be empty")
    private String userType;

    @Required(message = "Status cannot be empty")
    private Boolean status;

    private String createBy, modifiedBy;

    private Date createDate, modifiedDate, lastLoginDate;


    /* the following are service methods */
    public static User login(LoginForm form) {
        List<User> users = Ebean.find(User.class).select("id, username, email, realname, userType, status, lastLoginDate").where().eq("username", form.getUsername())
                .eq("password", form.getPassword()).eq("status", true).findList();
        if (CollectionUtils.size(users) > 0) {
            return users.get(0);
        }
        return null;
    }

    public static List<User> findAll() {
        return Ebean.find(User.class).select("id, username, email, userType, status").where().findList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
