package com.pd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "pditems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdItem implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.id
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    @Id
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.brand
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private String brand;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.model
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private String model;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.title
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.sell_point
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    @Field("sell_point")
    private String sellPoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.price
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.num
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.barcode
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private String barcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.image
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.cid
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private Long cid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.status
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.created
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    @Field(type = FieldType.Date, name = "create_time",format = {},
            pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd'T'HH:mm:ss'+08:00' || strict_date_optional_time || epoch_millis")
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pd_item.updated
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    @Field(type = FieldType.Date, name = "create_time",format = {},
            pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd'T'HH:mm:ss'+08:00' || strict_date_optional_time || epoch_millis")
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pd_item
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pd_item.id
     *
     * @return the value of pd_item.id
     *
     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
     */
//    public Long getId() {
//        return id;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.id
//     *
//     * @param id the value for pd_item.id
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.brand
//     *
//     * @return the value of pd_item.brand
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public String getBrand() {
//        return brand;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.brand
//     *
//     * @param brand the value for pd_item.brand
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setBrand(String brand) {
//        this.brand = brand == null ? null : brand.trim();
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.model
//     *
//     * @return the value of pd_item.model
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public String getModel() {
//        return model;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.model
//     *
//     * @param model the value for pd_item.model
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setModel(String model) {
//        this.model = model == null ? null : model.trim();
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.title
//     *
//     * @return the value of pd_item.title
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public String getTitle() {
//        return title;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.title
//     *
//     * @param title the value for pd_item.title
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setTitle(String title) {
//        this.title = title == null ? null : title.trim();
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.sell_point
//     *
//     * @return the value of pd_item.sell_point
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public String getSellPoint() {
//        return sellPoint;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.sell_point
//     *
//     * @param sellPoint the value for pd_item.sell_point
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setSellPoint(String sellPoint) {
//        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.price
//     *
//     * @return the value of pd_item.price
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public Double getPrice() {
//        return price;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.price
//     *
//     * @param price the value for pd_item.price
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.num
//     *
//     * @return the value of pd_item.num
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public Integer getNum() {
//        return num;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.num
//     *
//     * @param num the value for pd_item.num
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setNum(Integer num) {
//        this.num = num;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.barcode
//     *
//     * @return the value of pd_item.barcode
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public String getBarcode() {
//        return barcode;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.barcode
//     *
//     * @param barcode the value for pd_item.barcode
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setBarcode(String barcode) {
//        this.barcode = barcode == null ? null : barcode.trim();
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.image
//     *
//     * @return the value of pd_item.image
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public String getImage() {
//        return image;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.image
//     *
//     * @param image the value for pd_item.image
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setImage(String image) {
//        this.image = image == null ? null : image.trim();
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.cid
//     *
//     * @return the value of pd_item.cid
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public Long getCid() {
//        return cid;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.cid
//     *
//     * @param cid the value for pd_item.cid
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setCid(Long cid) {
//        this.cid = cid;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.status
//     *
//     * @return the value of pd_item.status
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public Byte getStatus() {
//        return status;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.status
//     *
//     * @param status the value for pd_item.status
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setStatus(Byte status) {
//        this.status = status;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.created
//     *
//     * @return the value of pd_item.created
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public Date getCreated() {
//        return created;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.created
//     *
//     * @param created the value for pd_item.created
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column pd_item.updated
//     *
//     * @return the value of pd_item.updated
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public Date getUpdated() {
//        return updated;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column pd_item.updated
//     *
//     * @param updated the value for pd_item.updated
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    public void setUpdated(Date updated) {
//        this.updated = updated;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table pd_item
//     *
//     * @mbg.generated Thu Oct 11 11:44:42 CST 2018
//     */
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", brand=").append(brand);
//        sb.append(", model=").append(model);
//        sb.append(", title=").append(title);
//        sb.append(", sellPoint=").append(sellPoint);
//        sb.append(", price=").append(price);
//        sb.append(", num=").append(num);
//        sb.append(", barcode=").append(barcode);
//        sb.append(", image=").append(image);
//        sb.append(", cid=").append(cid);
//        sb.append(", status=").append(status);
//        sb.append(", created=").append(created);
//        sb.append(", updated=").append(updated);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
}