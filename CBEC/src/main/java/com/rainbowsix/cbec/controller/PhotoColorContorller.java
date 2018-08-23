package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.PhotoColorModel;
import com.rainbowsix.cbec.service.IPhotoColorService;

@RestController
@RequestMapping("/photocolor")
public class PhotoColorContorller {
	private IPhotoColorService photoColorService = null;
	
	@Autowired
	public void setPhotoColorService(IPhotoColorService photoColorService) {
		this.photoColorService = photoColorService;
	}
	
	@RequestMapping(value="/list/all/withoutphoto",method={RequestMethod.GET})
	@ResponseBody
	public List<PhotoColorModel> getListWithoutEmployeesByAll() throws Exception {
		List<PhotoColorModel>  pc =  photoColorService.getListWithoutPhotoByAll();
		
		System.out.println(pc.get(1).getName());
	
		return photoColorService.getListWithoutPhotoByAll();
	}
	

}
