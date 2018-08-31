package com.rainbowsix.cbec.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.OrderModel;
import com.rainbowsix.cbec.service.IOrderService;
import com.rainbowsix.cbec.service.impl.OrderServiceImpl;

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
		return "Add OK!!!";
	}
	
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public String modify(OrderModel order) throws Exception{
		orderService.modify(order);
		return "Modify OK!!!";
	}
	
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public String delete(int orderid) throws Exception{
		orderService.delete(orderid);
		return "Delete OK!!!";
	}
	
	@RequestMapping(value="/list/all",method= {RequestMethod.GET})
	public List<OrderModel> getOrderListByAll() throws Exception{
		return orderService.getOrderListByAll();
	}
	
	@RequestMapping(value="/get",method= {RequestMethod.GET})
	public OrderModel getOrderListById(int orderid) throws Exception{
		return orderService.getOrderListById(orderid);
	}
	
	@RequestMapping(value="/listwithgoods/all",method= {RequestMethod.GET})
	public List<OrderModel> getOrderListWithGoodsByAll() throws Exception{
		return orderService.getOrderListWithGoodsByAll();
	}
	
	@RequestMapping(value="/getwithgoods",method= {RequestMethod.GET})
	public OrderModel getOrderListWithGoodsById(int orderid) throws Exception{
		return orderService.getOrderListWithGoodsById(orderid);
	}

}
