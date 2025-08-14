package com.hexaware.fastx.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.entity.Seat;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findBySchedule_ScheduleId(int scheduleId); // get seats by schedule
    List<Seat> findBySchedule_ScheduleIdAndIsBookedFalse(int scheduleId); // available seats
}
