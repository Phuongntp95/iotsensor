package com.example.demo.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Bomnuoc;
import com.example.demo.model.BomNuocResponse;
import com.example.demo.model.EndPoint;
import com.example.demo.repositories.BomnuocRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bomnuoc")
public class BomnuocController {
	
	private static String status = "off";
	
	@Autowired
	BomnuocRepository mRepository;
	
	
	@RequestMapping(value = { "/", "" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Lấy all thông tin bơm nước")
	public EndPoint<List<Bomnuoc>> getAll() {
		List<Bomnuoc> lists = mRepository.findAll();
		return new EndPoint<List<Bomnuoc>>(HttpStatus.OK.value(), "Thành công", lists);
	}
	
	@RequestMapping(value = { "/on" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Gửi yêu cầu bơm nước")
	public EndPoint<Bomnuoc> onBomNuoc(@RequestBody Bomnuoc bomNuoc) {
		bomNuoc.setId(0);
		bomNuoc.setDate(new Date());
		bomNuoc = mRepository.save(bomNuoc);
		BomnuocController.status = "on";
		return new EndPoint<Bomnuoc>(HttpStatus.CREATED.value(), "Thành công", bomNuoc);
	}
	
	
	@RequestMapping(value = { "/off" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Gửi yêu cầu tắt nước")
	public EndPoint<Bomnuoc> offBomnuoc(@RequestBody Bomnuoc bomNuoc) {
		bomNuoc.setId(0);
		bomNuoc.setDate(new Date());
		bomNuoc = mRepository.save(bomNuoc);
		BomnuocController.status = "off";
		return new EndPoint<Bomnuoc>(HttpStatus.CREATED.value(), "Thành công", bomNuoc);
	}
	

	@RequestMapping(value = { "/thongbao" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("nhận thông báo")
	public EndPoint<BomNuocResponse> getAccountById() {
		BomNuocResponse response = new BomNuocResponse();
		response.setStatus(BomnuocController.status);
		return new EndPoint<BomNuocResponse>(HttpStatus.OK.value(), "Thành công", response);
	}
}
