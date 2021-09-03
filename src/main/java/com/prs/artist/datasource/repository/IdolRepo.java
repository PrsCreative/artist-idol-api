package com.prs.artist.datasource.repository;

import com.prs.artist.datasource.entity.Idol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface IdolRepo extends JpaRepository<Idol, BigInteger>
{
	@Query("SELECT i FROM Idol i WHERE i.name = :name")
	List<Idol> findByName(@Param("name") String name);
}
