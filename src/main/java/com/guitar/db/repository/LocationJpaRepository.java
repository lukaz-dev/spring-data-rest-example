package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

//    @Query("select l from Location l where l.state like ?1%")
//    List<Location> getLocationByStateName(String state);

    Location findFirstByStateIgnoreCaseStartingWith(String stateName);

    List<Location> findByStateIgnoreCaseStartingWith(String stateName);

    List<Location> findByStateNotLikeOrderByStateAsc(String stateName);

    List<Location> findByStateOrCountry(String value1, String value2);

    List<Location> findByStateNot(String state);
}
