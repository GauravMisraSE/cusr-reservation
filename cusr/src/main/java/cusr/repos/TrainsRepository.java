package cusr.repos;

import cusr.model.Trains;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface TrainsRepository extends CrudRepository<Trains, String> {

	List<Trains> findByDirection(Character direction);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.A >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndA(@Param("direction") Character direction,
	                                                          @Param("trainType") Character trainType,
//	                                                          @Param("startStation") Character startStation,
	                                                          @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.B >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndB(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.C >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndC(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.D >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndD(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.E >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndE(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.F >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndF(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.G >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndG(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.H >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndH(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.I >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndI(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.J >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndJ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.K >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndK(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.L >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndL(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.M >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndM(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.N >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndN(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.O >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndO(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.P >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndP(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Q >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndQ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.R >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndR(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.S >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndS(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.T >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndT(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);
	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.U >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndU(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.V >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndV(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.W >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndW(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.X >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndX(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Y >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndY(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);

	@Query(nativeQuery = true, value = "select * from trains where trains.direction = :direction and trains.type = :trainType and trains.Z >= :startTime")
	List<Trains> findByDirectionAndTrainTypeAndStartTimeAndZ(@Param("direction") Character direction,
	                                                         @Param("trainType") Character trainType,
                                                             @Param("startTime")String startTime);



}
