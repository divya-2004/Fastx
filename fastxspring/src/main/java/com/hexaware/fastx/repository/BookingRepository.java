package com.hexaware.fastx.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	List<Booking> findByUser_UserId(int userId);


}
