package com.muyuer.springdemo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-06 05:20
 */
@Data
@Entity
@Table(name = "all_user", schema = "tododb", catalog = "")
public class AllUserEntity {
    private Long userId;
    private String userName;
    private String userAccount;
    private String password;
    private String salt;
    private byte isAdmin;
    private byte isManage;
    private String descript;
    private Integer sortId;
    private byte isActivity;
    private String lockDescript;
    private Integer defaultUnitId;
    private Integer doneTime;
    private Integer cancelTime;
    private Integer closeTime;
    private Byte status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.muyuer.springdemo.core.CustomIDGenerator")
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_account")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "is_admin")
    public byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Basic
    @Column(name = "is_manage")
    public byte getIsManage() {
        return isManage;
    }

    public void setIsManage(byte isManage) {
        this.isManage = isManage;
    }

    @Basic
    @Column(name = "descript")
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Basic
    @Column(name = "sort_id")
    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Basic
    @Column(name = "is_activity")
    public byte getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(byte isActivity) {
        this.isActivity = isActivity;
    }

    @Basic
    @Column(name = "lock_descript")
    public String getLockDescript() {
        return lockDescript;
    }

    public void setLockDescript(String lockDescript) {
        this.lockDescript = lockDescript;
    }

    @Basic
    @Column(name = "default_unit_id")
    public Integer getDefaultUnitId() {
        return defaultUnitId;
    }

    public void setDefaultUnitId(Integer defaultUnitId) {
        this.defaultUnitId = defaultUnitId;
    }

    @Basic
    @Column(name = "done_time")
    public Integer getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Integer doneTime) {
        this.doneTime = doneTime;
    }

    @Basic
    @Column(name = "cancel_time")
    public Integer getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Integer cancelTime) {
        this.cancelTime = cancelTime;
    }

    @Basic
    @Column(name = "close_time")
    public Integer getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Integer closeTime) {
        this.closeTime = closeTime;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllUserEntity that = (AllUserEntity) o;

        if (userId != that.userId) return false;
        if (isAdmin != that.isAdmin) return false;
        if (isManage != that.isManage) return false;
        if (isActivity != that.isActivity) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (descript != null ? !descript.equals(that.descript) : that.descript != null) return false;
        if (sortId != null ? !sortId.equals(that.sortId) : that.sortId != null) return false;
        if (lockDescript != null ? !lockDescript.equals(that.lockDescript) : that.lockDescript != null) return false;
        if (defaultUnitId != null ? !defaultUnitId.equals(that.defaultUnitId) : that.defaultUnitId != null)
            return false;
        if (doneTime != null ? !doneTime.equals(that.doneTime) : that.doneTime != null) return false;
        if (cancelTime != null ? !cancelTime.equals(that.cancelTime) : that.cancelTime != null) return false;
        if (closeTime != null ? !closeTime.equals(that.closeTime) : that.closeTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

}
