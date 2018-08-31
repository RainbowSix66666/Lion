package com.rainbowsix.cbec.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rainbowsix.cbec.model.GoodsPhotoModel;
import com.rainbowsix.cbec.result.JqGridJson;
import com.rainbowsix.cbec.service.IGoodsPhotoService;

@RestController
@RequestMapping("/goodsphoto")
public class GoodsPhotoController {
	private IGoodsPhotoService  goodsPhotoService = null;

	@Autowired
	public void setGoodsPhotoService(IGoodsPhotoService goodsPhotoService) {
		this.goodsPhotoService = goodsPhotoService;
	}
	
	//取得所有照片列表有商品   无分页（无图片）
	@RequestMapping(value="/list/all/withgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectListWithGoodsByAll() throws Exception{
		return goodsPhotoService.selectListWithGoodsByAll();
	}
	
	//取得所有照片列表无商品   无分页（无图片）
	@RequestMapping(value="/list/all/withoutgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectListWithoutGoodsByAll() throws Exception{
		return goodsPhotoService.selectListWithoutGoodsByAll();
	}

	//取得单个商品照片列表 
	@RequestMapping(value="/list/byphotoid/withgoods",method={RequestMethod.POST})
	@ResponseBody
	public GoodsPhotoModel selectByPhotoId(int photoId) throws Exception{
		return goodsPhotoService.selectByPhotoId(photoId);
	}
	
	//取得所有GoodsPhoto列表有商品   无分页（有图片）	
	@RequestMapping(value="/list/byphotoid/allwithgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectLisAllWithGoods() throws Exception{
		return goodsPhotoService.selectLisAllWithGoods();
	}
	
	//取得所有GoodsPhoto列表无商品   无分页（有图片）	
	@RequestMapping(value="/list/byphotoid/allwithoutgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectLisAllWithoutGoods() throws Exception{
		return goodsPhotoService.selectLisAllWithoutGoods();
	}
	
	//取得所有GoodsPhoto列表商品   无分页（有图片）	
		@RequestMapping(value="/list/byphotoid/all",method={RequestMethod.GET})
		@ResponseBody
	public List<GoodsPhotoModel> selectListByCondition(@RequestParam(required=false,defaultValue="0") int photoId,
			@RequestParam(required=false,defaultValue="0") int proid,  
			@RequestParam(required=false,defaultValue="") String des, 
			@RequestParam(required=false,defaultValue="0") int rank)throws Exception{
			if(des!=null&&des.trim().length()>0) {
				des="%"+des+"%";
			}
			
			return goodsPhotoService.selectListByCondition(photoId, proid, des, rank);
		}
	
		//根据条件取照片列表 分页
		@RequestMapping(value="/list/byphotoid/allwithoutgoods/page",method={RequestMethod.GET})
		@ResponseBody
		public JqGridJson<GoodsPhotoModel> selectListByConditionWithPage(@RequestParam(required=false,defaultValue="0") int photoId,
				@RequestParam(required=false,defaultValue="0") int proid,  
				@RequestParam(required=false,defaultValue="") String des, 
				@RequestParam(required=false,defaultValue="0") int rank,
				@RequestParam(required=false,defaultValue="10") int rows, 
				@RequestParam(required=false,defaultValue="1") int page,
				@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
				@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
				@RequestParam(required=false) int[] colors) throws Exception{
			
			if(des!=null&&des.trim().length()>0) {
				des="%"+des+"%";
			}
			JqGridJson<GoodsPhotoModel> result = new JqGridJson<GoodsPhotoModel>();
			
			result.setRecords(goodsPhotoService.getCountWithPhoto(photoId, proid, des, rank, colors));
			int pageCount = goodsPhotoService.getPageWithPhoto(photoId, proid, des, rank, rows, colors);
			if(page>pageCount) {
				page = pageCount;
			}
			if(page<1) {
				page = 1;
			}
			
			result.setTotal(pageCount);
			result.setRows(goodsPhotoService.selectListByConditionWithPage(photoId, proid, des, rank, rows, page, startDate, endDate, colors));
			result.setPage(page);

			return result;
		}
		
		 //取得照片等级
		@RequestMapping(value="/list/photorank",method={RequestMethod.GET})
		@ResponseBody
		 public List<GoodsPhotoModel> selectRankCondition() throws Exception{
			 return goodsPhotoService.selectRankCondition();
		 }
		
		//取得商品id
		@RequestMapping(value="/list/proid",method={RequestMethod.GET})
		@ResponseBody
		public List<GoodsPhotoModel> selectProidCondition() throws Exception{
			return goodsPhotoService.selectProidCondition();
		}
		
		//增加照片信息和上传照片
		@RequestMapping(value="/add",method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
		public String  add(GoodsPhotoModel goodsPhoto,@RequestParam(required=false) MultipartFile loadPhoto,@RequestParam(required=false) int[] colors) throws Exception{
			int photoId=0;
			if(loadPhoto==null || loadPhoto.isEmpty()) {
				//无图片提交
				photoId=goodsPhotoService.addWithoutPhoto(goodsPhoto);
			}
			else {
				//有图片提交
				goodsPhoto.setPhoto(loadPhoto.getBytes());
				goodsPhoto.setPhotoContentType(loadPhoto.getOriginalFilename());
				goodsPhoto.setPhotoFileName(loadPhoto.getOriginalFilename());
				photoId=goodsPhotoService.addWithPhoto(goodsPhoto);
			}
			if(colors!=null) {
				goodsPhotoService.grantColor(goodsPhoto.getPhotoId(), colors);
			}
			return "添加照片成功";
		}
		
		//修改照片信息和上传照片
		@RequestMapping(value="/modify",method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
		public String  modify(GoodsPhotoModel goodsPhoto,@RequestParam(required=false) MultipartFile loadPhoto,@RequestParam(required=false) int[] colors) throws Exception{
			if(loadPhoto==null || loadPhoto.isEmpty()) {
				//无图片提交
				goodsPhotoService.modifyWithoutPhoto(goodsPhoto);
			}
			else {
				//有图片提交
				goodsPhoto.setPhoto(loadPhoto.getBytes());
				goodsPhoto.setPhotoContentType(loadPhoto.getOriginalFilename());
				goodsPhoto.setPhotoFileName(loadPhoto.getOriginalFilename());
				goodsPhotoService.modifyWithPhoto(goodsPhoto);
			}
			if(colors!=null) {
				goodsPhotoService.grantColor(goodsPhoto.getPhotoId(), colors);
			}
			return "修改照片成功";
		}

		
}























