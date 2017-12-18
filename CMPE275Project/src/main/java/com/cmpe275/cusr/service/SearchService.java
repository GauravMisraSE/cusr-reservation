package com.cmpe275.cusr.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe275.cusr.model.Trains;
import com.cmpe275.cusr.repositories.TrainsRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.*;


@Service
@Transactional
public class SearchService {

	@Autowired
	private TrainsRepository trainsRepository;

	public List<Trains> getAllTrains(){

		List<Trains> allTrains = new ArrayList<>();
		trainsRepository.findAll().forEach((allTrains::add));
		for(Trains t: allTrains){
			System.out.println(t.getName());
		}
		return allTrains;
	}
	
	public void setStations(List<Trains> trains, Character startStation, Character endStation)
	{
		for(Trains t: trains){
			t.setendStation(endStation);
			t.setstartStation(startStation);
		}
	}

	public List<Trains> searchTrains(Character startStation, String startTime, Character endStation, Character trainType, String date){

		Character direction = null;
		LocalTime st = LocalTime.parse(startTime);
		List<Trains> trains = null;
		if (Character.getNumericValue(startStation) - Character.getNumericValue(endStation) < 0)
			direction = 'S';
		else
			direction = 'N';
		System.out.println("direction: " + direction);
		System.out.println("trainType: " + trainType);
		System.out.println("endStation: " + endStation);
		System.out.println("startTime: " + startTime);
		
		
		if (startStation == 'A') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndA(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'B') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndB(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'C') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndC(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'D') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndD(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'E') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndE(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'F') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndF(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'G') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndG(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'H') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndH(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'I') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndI(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'J') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndJ(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'K') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndK(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'L') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndL(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'M') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndM(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'N') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndN(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'O') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndO(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'P') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndP(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'Q') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndQ(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'R') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndR(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'S') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndS(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		
		if (startStation == 'T') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndT(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'U') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndU(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'V') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndV(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'W') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndW(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'X') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndX(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'Y') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndY(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}
		if (startStation == 'Z') {
			trains = trainsRepository.findByDirectionAndTrainTypeAndStartTimeAndZ(direction,trainType,endStation,startTime);
			setStations(trains,startStation,endStation);
		}

		return trains;
	}
}
