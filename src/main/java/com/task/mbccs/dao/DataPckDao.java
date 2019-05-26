package com.task.mbccs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.task.mbccs.entity.DataPck;

@Repository
public interface DataPckDao extends JpaRepository<DataPck, Long>{
	
	@Query("SELECT p FROM DataPck p WHERE p.packageCode = :packageCode or p.packageName = :packageName or p.status = :status")
	public List<DataPck> findPck(@Param("packageCode") String packageCode,@Param("packageName") String packageName, @Param("status") String status);
	

}
