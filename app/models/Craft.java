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
@Table(name = "tb_craft")
public class Craft {

    final static Logger logger = LoggerFactory.getLogger(Craft.class);

    @Id
    private Long id;

    @Required(message = "Username cannot be empty")
    private String name;

    private String tag;

    @Required(message = "Status cannot be empty")
    private Boolean status;

    private Float price;

    private Integer position;

    private String pic1, pic2;

    private String createBy, modifiedBy;

    private Date createDate, modifiedDate;


    /* the following are service methods */
    public static List<Craft> findForPublic() {
        return Ebean.find(Craft.class).select("id, name, tag, pirce").where().eq("status", true).findList();
    }

    public static List<Craft> findAll() {
        return Ebean.find(Craft.class).select("id, name, tag, pirce").where().findList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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


    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }
}
