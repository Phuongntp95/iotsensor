package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Sensor;
import com.example.demo.model.EndPoint;
import com.example.demo.repositories.SensorRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sensor")
public class SensorController {
	@Autowired
	SensorRepository mRepository;
	
	@RequestMapping(value = {"/new" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Lấy  sensor mới")
	public EndPoint<Sensor> getNew() {
		List<Sensor> list = mRepository.findAll();
		Sensor lists = list.size() > 0 ? list.get(list.size() - 1) : null;
		return new EndPoint<Sensor>(HttpStatus.OK.value(), "Thành công", lists);
	}
	
	@RequestMapping(value = { "/", "" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Lấy tất cả sensor")
	public EndPoint<List<Sensor>> getAll() {
		List<Sensor> lists = mRepository.findAll();
		return new EndPoint<List<Sensor>>(HttpStatus.OK.value(), "Thành công", lists);
	}

	@RequestMapping(value = { "/", "" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("tạo sensor")
	public EndPoint<Sensor> createSensor(@RequestBody Sensor sensor) {
		sensor.setDate(new Date());
		sensor.setId(0);
		sensor=mRepository.save(sensor);
		return new EndPoint<Sensor>(HttpStatus.OK.value(), "Thành công", sensor);
	}

	@RequestMapping(value = { "/{id}" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Lấy sensor theo id")
	public EndPoint<Sensor> getAccountById(@PathVariable("id") int id) {
		Sensor sensor = mRepository.findById(id).get();
		
		return new EndPoint<Sensor>(HttpStatus.OK.value(), "Thành công", sensor);
	}

}
