package com.patnana.myshop.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.patnana.myshop.Entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

//	@Query(value="SELECT orderId FROM Order", nativeQuery = true)
//	List<Integer> findIds();
	
	@Transactional
	@Modifying
	//@Query("update Order order set order.orderValue = :value where order.orderId = :id ")
	@Query(value = "update Order u set u.orderValue = ? where u.orderId = ?", 
  nativeQuery = true)
	int updateOrderValueById(Float value, Integer id);
}