package com.hexaware.fastx.repository;
import com.hexaware.fastx.entity.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusOperatorRepository extends JpaRepository<BusOperator, Integer>  {

}
