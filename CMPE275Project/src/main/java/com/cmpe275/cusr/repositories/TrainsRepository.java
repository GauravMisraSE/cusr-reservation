package com.cmpe275.cusr.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cmpe275.cusr.model.Trains;

import java.time.LocalTime;
import java.util.List;


public interface TrainsRepository extends CrudRepository<Trains, String> {

	List<Trains> findByDirection(Character direction);
	
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.A >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndA(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
	                                                          @Param("endStation") Character endStation,
	                                                          @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.B >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndB(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.C >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndC(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.D >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndD(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.E >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndE(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.F >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndF(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.G >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndG(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.H >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndH(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.I >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndI(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.J >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndJ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.K >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndK(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.L >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndL(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.M >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndM(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.N >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndN(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.O >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndO(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.P >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndP(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Q >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndQ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.R >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndR(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.S >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndS(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.T >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndT(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.U >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndU(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.V >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndV(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.W >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndW(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.X >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndX(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Y >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndY(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Z >= :startTime ORDER BY :endStation LIMIT 5")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndZ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
	                                                         @Param("endStation") Character endStation,
                                                             @Param("startTime")String startTime);



}
