package com.muyuer.springdemo.entity;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-11-30 14:16
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String areaCode;
    private String country;
    private String province;
    private String city;
    private String area;
    private String detailAddress;

    public Address() {
        super();
    }

    public Address(String areaCode, String country, String province, String city, String area,
                   String detailAddress) {
        super();
        this.areaCode = areaCode;
        this.country = country;
        this.province = province;
        this.city = city;
        this.area = area;
        this.detailAddress = detailAddress;
    }

    public Long getAddressId() {
        return addressId;
    }
    // getter, setter

    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", areaCode=" + areaCode + ", country=" + country + ", province="
                + province + ", city=" + city + ", area=" + area + ", detailAddress=" + detailAddress + "]";
    }

}