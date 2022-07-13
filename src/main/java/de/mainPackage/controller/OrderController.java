package de.mainPackage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mainPackage.model.order.Order;
import de.mainPackage.model.product.Product;
import de.mainPackage.service.OrderService;
import de.mainPackage.service.ProductService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/{order_id}")
	public Optional<Order> getOrder(@PathVariable int order_id){
		return orderService.getOrder(order_id);
	}
	
	
	@GetMapping("/all")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@PostMapping("/create")
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@PutMapping("/{order_id}/products/{product_id}")
	Order enrollProductToOrder(
			@PathVariable int order_id,
			@PathVariable int product_id
	) {
		Order order = orderService.getOrder(order_id).get();
		Product product = productService.getProduct(product_id).get();
		order.enrollProduct(product);
		return orderService.createOrder(order);
		
	}
}
