package com.example.mvc.repositories;

import com.example.mvc.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,Long> {
    @Query(value = "select * from car where about_car like %:description%", nativeQuery = true)
    List<Car> findAllByDescription(@Param("description") String description);
    @Query(value = "select * from car where id=:id ",nativeQuery = true)
    Car finByI(@Param("id") Long id);
}
