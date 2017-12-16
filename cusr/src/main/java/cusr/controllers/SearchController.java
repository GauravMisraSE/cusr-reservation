package cusr.controllers;

import cusr.model.Trains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cusr.services.SearchService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	// return all train objects
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Trains> allTrains(){
		return searchService.getAllTrains();
	}

	// retrieving the list of train options based on journey times
	// check the request parameters while integration
	@RequestMapping(method = RequestMethod.GET, value = "")
	public List<Trains> trains(@RequestParam(value = "startStation") Character startStation,
	                           @RequestParam(value = "startTime") String startTime,
	                           @RequestParam(value = "endStation") Character endStation,
	                           @RequestParam(value = "trainType") Character trainType,
	                           @RequestParam(value = "date") String date) {

		List<Trains> trainOptions = searchService.searchTrains(startStation, startTime, endStation, trainType, date);

		return trainOptions;
	}

}
