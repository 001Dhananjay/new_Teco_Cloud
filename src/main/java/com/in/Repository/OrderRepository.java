package com.in.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.entity.TacoOrder;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
	
	
	List<TacoOrder> findByDeliveryZip(String deliveryZip);
	
	List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
		      String deliveryZip, Date startDate, Date endDate);

}
