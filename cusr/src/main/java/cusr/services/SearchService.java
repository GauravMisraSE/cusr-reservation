package cusr.services;

import cusr.model.Trains;
import cusr.repos.TrainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import java.time.*;


@Service
@Transactional
public class SearchService {

	@Autowired
	private TrainsRepository trainsRepository;

	public List<Trains> getAllTrains(){

		List<Trains> allTrains = new ArrayList<>();
		trainsRepository.findAll().forEach((allTrains::add));
//		for(Trains t: allTrains){
//			System.out.println(t.getName());
//		}
		return allTrains;
	}

	public List<Trains> searchTrains(Character startStation, String startTime, Character endStation, Character trainType, String date){

		Character direction = null;
		LocalTime st = LocalTime.parse(startTime);
		List<Trains> trains = null;

		if (Character.getNumericValue(startStation) - Character.getNumericValue(endStation) < 0)
			direction = 'S';
		else
			direction = 'N';

		if (startStation == 'A')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndA(direction,trainType,startTime);
		if (startStation == 'B')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndB(direction,trainType,startTime);
		if (startStation == 'C')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndC(direction,trainType,startTime);
		if (startStation == 'D')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndD(direction,trainType,startTime);
		if (startStation == 'E')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndE(direction,trainType,startTime);
		if (startStation == 'F')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndF(direction,trainType,startTime);
		if (startStation == 'G')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndG(direction,trainType,startTime);
		if (startStation == 'H')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndH(direction,trainType,startTime);
		if (startStation == 'I')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndI(direction,trainType,startTime);
		if (startStation == 'J')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndJ(direction,trainType,startTime);
		if (startStation == 'K')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndK(direction,trainType,startTime);
		if (startStation == 'L')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndL(direction,trainType,startTime);
		if (startStation == 'M')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndM(direction,trainType,startTime);
		if (startStation == 'N')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndN(direction,trainType,startTime);
		if (startStation == 'O')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndO(direction,trainType,startTime);
		if (startStation == 'P')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndP(direction,trainType,startTime);
		if (startStation == 'Q')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndQ(direction,trainType,startTime);
		if (startStation == 'R')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndR(direction,trainType,startTime);
		if (startStation == 'S')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndS(direction,trainType,startTime);
		if (startStation == 'T')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndT(direction,trainType,startTime);
		if (startStation == 'U')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndU(direction,trainType,startTime);
		if (startStation == 'V')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndV(direction,trainType,startTime);
		if (startStation == 'W')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndW(direction,trainType,startTime);
		if (startStation == 'X')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndX(direction,trainType,startTime);
		if (startStation == 'Y')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndY(direction,trainType,startTime);
		if (startStation == 'Z')
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndZ(direction,trainType,startTime);

		return trains;
	}
}
