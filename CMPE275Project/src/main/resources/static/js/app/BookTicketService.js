'use strict';

angular.module('crudApp').factory('BookTicketService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

        var factory = {
            createTicket: createTicket,
            loadSearchDetails: loadSearchDetails,
            getSearchDetails: getSearchDetails,
            calculateFare:calculateFare
        };

        return factory;
        var fare;
        
        function createTicket(ticket,passengers) {
        		alert("Method called");
            console.log('Creating Ticket');
            var deferred = $q.defer();
            var passengerList="";
            var i;
            var ticketInfo={userId:10, depTrainNo:"2",depFrom:"B",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0815",depToTime:"1000",retTrainNo:"1",retFrom:"M",retTo:"B",retDate:"10-Dec-2017",retFromTime:"0915",retToTime:"1000", noOfPassengers:1,totalFare:15};
            //var ticketInfo={userId:10, depTrainNo:"3",depFrom:"B",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0915",depToTime:"1000", noOfPassengers:2,totalFare:fare};
            ticket = ticketInfo;
            //alert(ticket.userId);
                        
            //alert(passengers.fname[1]);  
            //alert(passengers.lname[1]);  
            //alert(passengers.fname[2]);  
            //alert(passengers.lname[2]);
            
            for (i = 1; i <= ticket.noOfPassengers; i++) { 
            		passengerList += "<tr><td>Passenger"+ i+":"+ passengers.fname[i] +" "+ passengers.lname[i]+"</td></tr>";
            }
            
            alert(passengerList);
            
            ticket.passengerList=passengerList;
            
            $http.post(urls.TICKET_SEARCH_API, ticket)
                .then(
                    function (response) {
                    	alert("Your ticket has been booked");
                        deferred.resolve(response.data);
                    },
                    function (errResponse) {
                    		alert("Error creating");
                       console.error('Error while creating Ticket : '+errResponse.data.errorMessage);
                       deferred.reject(errResponse);
                    }
                );
            alert("After Method called");
            return deferred.promise;
        }
        

        function loadSearchDetails() {
            console.log('Fetching ticket details');
            var deferred = $q.defer();
            localStorage.removeItem("ticket");
            var ticketInfo={userId:10, depTrainNo:"3",depFrom:"A",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0815",depToTime:"1000",retTrainNo:"1",retFrom:"M",retTo:"B",retDate:"10-Dec-2017",retFromTime:"0815",retToTime:"1000", retTrip:"1", noOfPassengers:1, baseFare:3,totalFare:15};
            //var ticketInfo={userId:10, depTrainNo:"3",depFrom:"B",depTo:"M",depDate:"10-Dec-2017",depFromTime:"0915",depToTime:"1000",depTrainType:"E", noOfPassengers:2, baseFare:3,totalFare:15,retTrip:"0"};
            //$localStorage.ticket = ticketInfo;
            $http.get(urls.USER_SERVICE_API)
                .then(
                    function (response) {
                        console.log('Fetched successfully ticket details');
                        //$localStorage.ticket = ticketInfo;
                        deferred.resolve(response);
                    },
                    function (errResponse) {
                        console.error('Error while loading');
                        deferred.reject(errResponse);
                    }
                );
            return deferred.promise;
        }

        function getSearchDetails(){
            //alert (JSON.stringify($localStorage.ticket));
            return $localStorage.ticket;
        }
        
       function calculateFare(){
    	        var from = $localStorage.ticket.depFrom;
    	        var to = $localStorage.ticket.depTo;
    	        var stops= Math.abs(from.charCodeAt(0) - to.charCodeAt(0));
    	        var rem = (stops%5);
    	        var quo = parseInt(stops/5);
    	        if ($localStorage.ticket.depTrainType === "R"){
	    	        if(stops<5){
	    	        	fare= '1';
	    	        }
	    	        else if(rem!=0){
	    	        	fare= (quo+1);
	    	        }
	    	        else {
	    	        	fare= quo;
	    	        	}
    	        }
    	        if ($localStorage.ticket.depTrainType === "E"){
	    	        if(stops<5){
	    	        	fare= '2';
	    	        }
	    	        else if(rem!=0){
	    	        	fare= (quo*2+2);
	    	        }
	    	        else {
	    	        	fare= quo*2;
	    	        	}
    	        }
    	        if ($localStorage.ticket.retTrip ==="1"){
    	        fare = fare*2;
    	        }
    	        return fare;
        }
        
    }
]);