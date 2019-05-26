package com.task.mbccs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.mbccs.entity.DataPck;
import com.task.mbccs.service.DataPckService;

@RestController
@RequestMapping("/dataPck")
public class DataPckController {

	@Autowired
	private DataPckService dataPckService;

	@GetMapping(value = "/all")
	public List<DataPck> getAllPck() {
		return dataPckService.getAllPck();
	}

	@GetMapping(value = "/{id}")
	public DataPck getPckById(@PathVariable Long id) {
		return this.dataPckService.getPckid(id);
	}

	@GetMapping("/findPck")
	@ResponseBody()
	public List<DataPck> findPck(@RequestParam String packageCode, @RequestParam String packageName, @RequestParam String status) {
		return dataPckService.findPck(packageCode, packageName, status);
	}

	@PostMapping(value = "/addPck", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public DataPck addPck(@RequestBody DataPck dataPck, @RequestParam String username) {
		dataPck.setCreateDate(new Date());
		dataPck.setCreateUser(username);
		return dataPckService.addPck(dataPck);
	}

	@PutMapping(value = "/updatePck", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public DataPck updatePck(@RequestBody DataPck dataPck, @RequestParam String username) {
		dataPck.setUpdateDate(new Date());
		dataPck.setUpdateUser(username);
		return dataPckService.updatePck(dataPck);
	}

	@DeleteMapping(value = "/{id}")
	public void deletePckById(@PathVariable Long id) {
		dataPckService.deletePCkbyId(id);
	}

}
