package com.hexaware.fastx.repository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	List<Schedule> findByRoute_RouteId(int routeId);
	List<Schedule> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);

}
