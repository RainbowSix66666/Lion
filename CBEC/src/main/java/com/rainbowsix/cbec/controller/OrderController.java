package com.rainbowsix.cbec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.OrderModel;
import com.rainbowsix.cbec.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	private IOrderService orderService = null;
	
	@Autowired
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value="/add",method= {RequestMethod.POST})
	@ResponseBody	
	public String add(OrderModel order) throws Exception{
		orderService.add(order);
		return "OK!!!";
	}

}
