package de.mainPackage.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.mainPackage.model.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
