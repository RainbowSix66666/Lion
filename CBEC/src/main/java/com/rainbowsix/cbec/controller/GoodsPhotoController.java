package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.GoodsPhotoModel;
import com.rainbowsix.cbec.service.IGoodsPhotoService;

@RestController
@RequestMapping("/goodsphoto")
public class GoodsPhotoController {
	private IGoodsPhotoService  goodsPhotoService = null;

	@Autowired
	public void setGoodsPhotoService(IGoodsPhotoService goodsPhotoService) {
		this.goodsPhotoService = goodsPhotoService;
	}
	
	@RequestMapping(value="/list/all",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectListByAll() throws Exception{
		return goodsPhotoService.selectListByAll();
	}


	
}
