package com.rainbowsix.cbec.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.OrderModel;
import com.rainbowsix.cbec.result.LdjControllerResult;
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

	//员工的登录验证方法
		@RequestMapping(value="/validate",method=RequestMethod.POST)
		public LdjControllerResult validate(int orderid,int comid,HttpSession session) throws Exception{
			
			LdjControllerResult result=new LdjControllerResult();
			if(orderService.validate(orderid, comid)) {
				OrderModel em=orderService.getOrderListById(orderid);
				session.setAttribute("orderInfo", em);
				
				result.setStatus("Y");
				result.setMessage("员工验证通过");
			}
			else {
				result.setStatus("N");
				result.setMessage("员工验证失败");
			}
			
			return result;
		}
		
		//检查员工是否登录
		@RequestMapping(value="/checkLogin",method=RequestMethod.GET)
		public LdjControllerResult checkLogin(HttpSession session) throws Exception{
			
			LdjControllerResult result=new LdjControllerResult();
			if(session.getAttribute("orderInfo")!=null) {
				
				result.setStatus("Y");
				result.setMessage("员工已登录");
			}
			else {
				result.setStatus("N");
				result.setMessage("员工未登录");
			}
			
			return result;
		}
		//取得已经登录员工的对象
		@RequestMapping(value="/getLoginOrder",method=RequestMethod.GET)
		public OrderModel getEmployeeInfoFromSession(HttpSession session) throws Exception{
			return (OrderModel)session.getAttribute("orderInfo");
		}
		//登录注销方法
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public LdjControllerResult logout(HttpSession session) throws Exception{
			
			session.invalidate(); //销毁session对象
			LdjControllerResult result=new LdjControllerResult();
			
			result.setStatus("Y");
			result.setMessage("员工注销成功");
			
			
			
			return result;
			
		}
}
