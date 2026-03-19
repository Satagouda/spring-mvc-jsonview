package com.community.springmvcjsonview.repository;

import com.community.springmvcjsonview.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
