package com.hexaware.fastx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.hexaware.fastx.entity.BusRoute;

@Repository  
public interface BusRouteRepository extends JpaRepository<BusRoute, Integer> {

    List<BusRoute> findByOrginAndDestination(String orgin, String destination);
}
