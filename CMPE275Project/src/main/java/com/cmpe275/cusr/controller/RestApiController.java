package com.cmpe275.cusr.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cmpe275.cusr.model.Ticket;
import com.cmpe275.cusr.model.Trains;
import com.cmpe275.cusr.model.User;
import com.cmpe275.cusr.service.SearchService;
import com.cmpe275.cusr.service.TicketService;
import com.cmpe275.cusr.service.UserService;
import com.cmpe275.cusr.util.CustomErrorType;




@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work

	@Autowired
	SearchService searchService; 
	
	@Autowired
	TicketService ticketService;
	
	// return all train objects
		@RequestMapping(method = RequestMethod.GET, value = "/search/all")
		public List<Trains> allTrains(){
			return searchService.getAllTrains();
		}
		

		// retrieving the list of train options based on journey times
		// check the request parameters while integration
		@RequestMapping(method = RequestMethod.GET, value = "/search")
		public List<Trains> trains(@RequestParam(value = "startStation") Character startStation,
		                           @RequestParam(value = "startTime") String startTime,
		                           @RequestParam(value = "endStation") Character endStation,
		                           @RequestParam(value = "trainType") Character trainType,
		                           @RequestParam(value = "date") String date) {

			List<Trains> trainOptions = searchService.searchTrains(startStation, startTime, endStation, trainType, date);

			return trainOptions;
		}

		
		// -------------------Book a Ticket-------------------------------------------
		
		@RequestMapping(value = "/ticket/", method = RequestMethod.POST)
		public ResponseEntity<?> bookTicket(@RequestBody Ticket ticket, UriComponentsBuilder ucBuilder) {
			logger.info("Creating Ticket... : {}");
			System.out.println("ticket details"+ticket);

			Long id = ticketService.bookTicket(ticket);
			
	        // outgoing message information
	        String mailTo = "poojaamin87@gmail.com";
	 
	        // message contains HTML markups
	        String message = "<i>Greetings!</i><br>";
	        String var = ticket.getDepTrainNo();
	        
	        if(ticket.getRetDate() != null) {
	        message +="<body style=\"margin: 0; padding: 0;\">\r\n" + 
	        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	        		"  <tr>\r\n" + 
	        		"   <td>\r\n" + 
	        		"<table align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n" + 
	        		" <tr><td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 40px 0 30px 0;\">\r\n" + 
	        		" <img src=\"http://preview.ibb.co/grPFem/Train.jpg\" alt=\"Booking Details\" width=\"500\" height=\"230\" border=\"0\" style=\"display: block;\" />\r\n" + 
	        		"</td>\r\n" + 
	        		"</tr>\r\n" + 
	        		" <tr>\r\n" + 
	        		"<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
	        		" <h1> Ticket#"+id+"<br>Passenger Details </h1>\r\n" + 
	        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"width:100%;font-family:Verdana;font-size: 15px\">\r\n" + 
	        		ticket.getPassengerList() +"\r\n" + 
	        		" </table>\r\n" + 
	        		"</td>\r\n" + 
	        		" </tr>\r\n" + 
	        		" <tr>\r\n" + 
	        		"  <td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
	        		"    <h1> Travel Itenary</h1>\r\n" + 
	        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	        		"  <tr>\r\n" + 
	        		"   <td><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size: 15px\">\r\n" + 
	        		"    Departure      "+ticket.getDepFrom()+"      --->      "+ticket.getDepTo()+" <br>    "+ticket.getDepDate()+"    "+ticket.getDepFromTime()+"            "+ticket.getDepToTime()+"\r\n" + 
	        		"   </td></pre>\r\n" + 
	        		"  </tr>\r\n" + 
	        		"  <tr>\r\n" + 
	        		"   <td><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size: 15px\">\r\n"+ 
	        		"    Return         " + ticket.getRetFrom()+"      --->      "+ticket.getRetTo()+" <br>    "+ticket.getRetDate()+"    "+ticket.getRetFromTime()+"            "+ticket.getRetToTime()+"\r\n" + 
	        		"   </td></pre>\r\n" + 
	        		"  </tr>\r\n" + 
	        		" </table>\r\n" + 
	        		"  </td>\r\n" + 
	        		" </tr>\r\n" + 
	        		"  <tr>\r\n" + 
	        		"  <td bgcolor=\"#ffffff\"><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size:15px;\"> \r\n" + 
	        		"   Total Fare" + "  $" +ticket.getTotalFare()+"\r\n" +
	        		"  </td>\r\n" + 
	        		" </tr>\r\n" + 
	        		"</body>";
	        }
	        else{
	                message +="<body style=\"margin: 0; padding: 0;\">\r\n" + 
	        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	        		"  <tr>\r\n" + 
	        		"   <td>\r\n" + 
	        		"<table align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\r\n" + 
	        		" <tr><td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 40px 0 30px 0;\">\r\n" + 
	        		" <img src=\"http://preview.ibb.co/grPFem/Train.jpg\" alt=\"Booking Details\" width=\"500\" height=\"230\" border=\"0\" style=\"display: block;\" />\r\n" + 
	        		"</td>\r\n" + 
	        		"</tr>\r\n" + 
	        		" <tr>\r\n" + 
	        		"<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
	        		" <h1> Ticket#"+id+"<br>Passenger Details </h1>\r\n" + 
	        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"width:100%;font-family:Verdana;font-size: 15px;\">\r\n" + 
	        		ticket.getPassengerList() +"\r\n" + 
	        		" </table>\r\n" + 
	        		"</td>\r\n" + 
	        		" </tr>\r\n" + 
	        		" <tr>\r\n" + 
	        		"  <td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" + 
	        		"    <h1> Travel Itenary</h1>\r\n" + 
	        		" <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	        		"  <tr>\r\n" + 
	        		"   <td><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size: 15px\">\r\n" + 
	        		"    Departure      "+ticket.getDepFrom()+"      --->      "+ticket.getDepTo()+" <br>    "+ticket.getDepDate()+"    "+ticket.getDepFromTime()+"            "+ticket.getDepToTime()+"\r\n" + 
	        		"   </td></pre>\r\n" + 
	        		"  </tr>\r\n" + 
	        		" </table>\r\n" + 
	        		"  </td>\r\n" + 
	        		" </tr>\r\n" + 
	        		"  <tr>\r\n" + 
	        		"  <td bgcolor=\"#ffffff\"><pre font-family: Verdana, \"Bitstream Vera Sans\", Geneva, sans-serif;><span style=\"font-size:15px\"> \r\n" + 
	        		"   Total Fare" + "  $" +ticket.getTotalFare()+"\r\n" +
	        		"  </td>\r\n" + 
	        		" </tr>\r\n" + 
	        		"</body>";
	        }

	        	
/*	      sendMail mailer = new sendMail();
	 
	        try {
	            mailer.sendHtmlEmail(mailTo, message);
	            System.out.println("Email sent.");
	        } catch (Exception ex) {
	            System.out.println("Failed to send email.");
	            ex.printStackTrace();
	        }*/
	    
			System.out.println("Create Ticket");
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		
	// -------------------Retrieve All Users---------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single User------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		User user = userService.findById(id);
		if (user == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------Create a User-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("Unable to create. A User with name {} already exist", user.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
			user.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		logger.info("Updating User with id {}", id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User-----------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);

		User user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		logger.info("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}