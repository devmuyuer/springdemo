package com.muyuer.springdemo.dao;

import com.muyuer.springdemo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author muyuer 182443947@qq.com
 * @date 2018-11-30 14:22
 */

public interface AddressRepository extends JpaRepository<Address, Long> {

}
