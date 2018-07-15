package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.model.EndPoint;
import com.example.demo.repositories.AccountRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/account")
public class AccountController {

	
	@Autowired
	AccountRepository mRepository;

	@RequestMapping(value = { "/", "" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Lấy tất cả account")
	public EndPoint<List<Account>> getAll() {
		List<Account> lists = mRepository.findAll();
		return new EndPoint<List<Account>>(HttpStatus.OK.value(), "Thành công", lists);
	}

	@RequestMapping(value = { "/Register" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Tạo account")
	public EndPoint<Account> createAccount(@RequestBody Account account) {
		mRepository.save(account);
		return new EndPoint<Account>(HttpStatus.CREATED.value(), "Thành công", account);
	}

	@RequestMapping(value = { "/{id}" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Lấy account theo id")
	public EndPoint<Account> getAccountById(@PathVariable("id") String id) {
		Account account = mRepository.findById(id).get();
		
		return new EndPoint<Account>(HttpStatus.OK.value(), "Thành công", account);
	}
	
	@RequestMapping(value = { "/login" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Lấy account theo id")
	public EndPoint<Account> login(@RequestBody Account account) {
		String message = "";
		Account a = null;
		Optional<Account> temp = mRepository.findById(account.getUserid());
		if(temp == null) {
			message = "Tài khoản không đúng";
			return new EndPoint<Account>(HttpStatus.NOT_FOUND.value(),message, a);
		}else {
			a = mRepository.findByUserIdAndPassword(account.getUserid(), account.getPassword());
			if(a == null) {
				message = "Mật khẩu không đúng";
				return new EndPoint<Account>(HttpStatus.NOT_FOUND.value(),message, a);
			}else {
				message = "Đăng nhập thành công";
				return new EndPoint<Account>(HttpStatus.OK.value(),message, a);
			}
		}		
	}

	@RequestMapping(value = { "/{id}" }, //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Cập nhật account")
	public EndPoint<Account> updateAcount(@PathVariable("id") String id, @RequestBody Account account) {

		Account temp = mRepository.findById(id).get();

		temp.setPassword(account.getPassword());

		temp = mRepository.save(temp);

		return new EndPoint<Account>(HttpStatus.OK.value(), "Thành công", temp);
	}

	@RequestMapping(value = { "/{id}" }, //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ApiOperation("Xóa account")
	public EndPoint<Account> deletetAccountById(@PathVariable("id") String id) {
		Account account = mRepository.findById(id).get();
		mRepository.delete(account);
		return new EndPoint<Account>(HttpStatus.OK.value(), "Thành công", account);
	}

}
