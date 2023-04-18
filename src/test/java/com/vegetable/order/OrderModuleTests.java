//package com.vegetable.order;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.vegetable.dto.OrderDTO;
//import com.vegetable.entity.Order;
//import com.vegetable.entity.Status;
//import com.vegetable.exception.DuplicateOrderFoundException;
//import com.vegetable.exception.OrderNotFoundException;
//import com.vegetable.service.OrderService;
//
//@SpringBootTest
//public class OrderModuleTests {
//	
//	@Autowired
//	private OrderService orderService;
//
//	@Test
//	void createOrder() throws DuplicateOrderFoundException {
//		OrderDTO orderDTO = new OrderDTO(100.0, Status.Success);
//		Order order = this.orderService.createOrder(orderDTO);
//		assertEquals(orderDTO.getBillingAmount(), order.getBillingAmount());
//	}
//	
//	@Test
//	void updateOrder() throws OrderNotFoundException {
//		OrderDTO orderDTO = new OrderDTO(100.0, Status.Success);
//		Long orderId = 1L;
//		Order order = this.orderService.updateOrder(orderDTO,orderId);
//		assertEquals(orderDTO.getBillingAmount(), order.getBillingAmount());
//	}
//	
//	@Test
//	void deleteOrder() throws OrderNotFoundException, DuplicateOrderFoundException {
//		OrderDTO orderDTO = new OrderDTO(200.0, Status.Success);
//		Order order = this.orderService.createOrder(orderDTO);
//		Order deletedOrder = this.orderService.deleteOrder(order.getOrderId());
//		assertEquals(deletedOrder.getBillingAmount(), order.getBillingAmount());
//	}
//	
//	@Test
//	void getOrderById() throws OrderNotFoundException, DuplicateOrderFoundException {
//		OrderDTO orderDTO = new OrderDTO(500.0, Status.Success);
//		Order order = this.orderService.createOrder(orderDTO);
//		Order getOrderById = this.orderService.getOrderById(order.getOrderId());
//		assertNotNull(getOrderById);
//	}
//	
//	@Test
//	void getAllOrder(){
//		List<Order> order = this.orderService.getAllOrders();
//		assertNotNull(order);
//	}
//}
