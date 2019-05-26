package com.task.mbccs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.mbccs.dao.DataPckDao;
import com.task.mbccs.entity.DataPck;

@Service
public class DataPckService {

	@Autowired
	private DataPckDao dataPckDao;

	public List<DataPck> getAllPck() {
		return dataPckDao.findAll();
	}

	public DataPck getPckid(Long id) {
		return dataPckDao.findOne(id);
	}

	public List<DataPck> findPck(String packageCode, String packageName, String status) {
		return dataPckDao.findPck(packageCode, packageName, status);
	}

	public DataPck addPck(DataPck dataPck) {
		return this.dataPckDao.save(dataPck);
	}

	public DataPck updatePck(DataPck dataPck) {
		return this.dataPckDao.save(dataPck);
	}

	public void deletePCkbyId(long id) {
		this.dataPckDao.delete(id);
	}
}
