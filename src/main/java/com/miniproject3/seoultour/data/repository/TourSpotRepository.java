package com.miniproject3.seoultour.data.repository;

import com.miniproject3.seoultour.data.entity.TourSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourSpotRepository extends JpaRepository<TourSpot, Long> {
    List<TourSpot> findByTourtypeIn(List<String> tourTypes);
}
