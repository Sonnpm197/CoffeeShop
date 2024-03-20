package com.coffeeshop.repository;

import com.coffeeshop.model.OrderQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderQueueRepository extends JpaRepository<OrderQueue, Integer> {
}
