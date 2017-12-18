'use strict';

angular.module('crudApp').controller('BookTicketController',
    ['BookTicketService', '$scope',  function( BookTicketService, $scope) {

        var self = this;
        self.ticket={};
        $scope.val = "retTrip";
        self.passengers=new Array(getSearchDetails().noOfPassengers);
        
        $scope.number = getSearchDetails().noOfPassengers;
        $scope.getPassengerCount = function(num) {
            return new Array(num);   
        }
        
        $scope.getRetVal = function() {
            return "retTrip";   
        }       
        
        self.submit = submit;
        self.getSearchDetails = getSearchDetails;
        self.createTicket = createTicket;
        self.calculateFare = calculateFare;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
        		alert("Submitting");
            console.log('Submitting');
            
            console.log('Book new ticket', self.ticket);
            createTicket(self.ticket,self.passengers);   
        }

        function createTicket(ticket,passengers) {
    		alert("Submitting1");
            console.log('About to create ticket');
            alert("Submitting7");
            BookTicketService.createTicket(ticket,passengers)
                .then(
                    function (response) {
                		alert("Submitting2");
                        console.log('Ticket booked successfully');
                        self.successMessage = 'Ticket booked successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                    	alert("Submitting4");
                        console.error('Error while creating Ticket');
                        self.errorMessage = 'Error while creating Ticker: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }

        function getSearchDetails(){
            return BookTicketService.getSearchDetails();
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            $scope.myForm.$setPristine(); //reset Form
        }
        
        function calculateFare(){
        	return BookTicketService.calculateFare();
        }

    }


    ]);