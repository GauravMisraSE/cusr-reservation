'use strict';

angular.module('crudApp').controller('SearchController',
    ['SearchService', '$scope', '$localStorage','$location','$window', function( SearchService, $scope, $localStorage, $location, $window) {

        var self = this;
       self.count = 0;
        self.user = {};
        self.users=[];
    
        self.submit = submit;
        self.storeLocal = storeLocal;
        self.returnSearch = returnSearch;
        self.chkAvailable = chkAvailable;
        self.bookTkt = bookTkt;
        self.reset = reset;
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.params = '';
        self.availParams='';
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        
       //populate drop downs 
        self.stationNames = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');
        self.passengers = '12345'.split('');
        self.trainTime = '06:00,06:15,06:30,06:45,07:00,07:15,07:30,07:45,08:00,08:15,08:30,08:35,08:40,08:45,09:00,09:15,09:30,09:45,10:00,10:15,10:30,10:45,11:00,11:15,11:30,11:45,12:00,12:15,12:30,12:45,13:00,13:15,13:30,13:45,14:00,14:15,14:30,14:45,15:00,15:15,15:30,15:45,16:00,16:15,16:30,16:45,17:00,17:15,17:30,17:45,18:00,18:15,18:30,18:45,19:00,19:15,19:30,19:45,20:00,20:15,20:30,20:45,21:00'.split(',');
        self.ticketType = 'Any,Regular,Express'.split(',');
        self.connectionType = 'Any,None,One'.split(',');
       
        self.results = [];
        //Set default screen values
        $scope.selectedFromStation = "A";
        $scope.selectedToStation = "A";
        $scope.selectedPassengers = "1";
        $scope.selectedFromTime = "06:00";
        $scope.selectedToTime = "06:00";
        $scope.selectedTicketType = 'Any';
        $scope.selectedConnection = 'Any';
        $scope.date = new Date();
        $scope.date1 = new Date();
        $scope.chkSelected = 'NO';
        $scope.depTrainType = '';
        var arr = [];
        
        //adding to local storage 
        function storeLocal(val,$location) {
        	alert(val);
        	$scope.trainNumber = val;
        //	self.passdata={userId:10, depTrainType:$scope.depTrainType, depTrainNo:$scope.trainNumber,depFrom:$scope.selectedFromStation,depTo:$scope.selectedToStation,depDate:"10-Dec-2017",depFromTime:$scope.selectedFromTime,depToTime:$scope.selectedToTime,retTrainNo:"1",retFrom:"M",retTo:"B",retDate:"10-Dec-2017",retFromTime:"0815",retToTime:"1000", retTrip:"1", noOfPassengers:$scope.selectedPassengers, baseFare:3,totalFare:15};
      
        	self.passdata={userId:10, depTrainType:"E", depTrainNo:$scope.trainNumber,depFrom:$scope.selectedFromStation,depTo:$scope.selectedToStation,depDate:"10-Dec-2017",depFromTime:$scope.selectedFromTime,depToTime:$scope.selectedToTime,retTrainNo:"1",retFrom:"M",retTo:"B",retDate:"10-Dec-2017",retFromTime:"0815",retToTime:"1000", retTrip:"1", noOfPassengers:1, baseFare:3,totalFare:15};
        	
        	// self.passdata = {trainNo:val,from:$scope.selectedFromStation,to:$scope.selectedToStation,departureTime:$scope.selectedFromTime,arrivalTime:$scope.selectedToTime};
        //if($scope.chkSelected == 'YES'){ 
        //	arr.add(val);
        //	$localStorage.ticket = self.passdata;
       // }
       // else
        //	{
        	 //if(arr.indexOf(val) != -1)
        		// {
        		// alert(arr.indexOf(val));
        		// }
       // 	}
       // alert (JSON.stringify($localStorage.ticket));
        //}
        	$localStorage.ticket = self.passdata;
        alert (JSON.stringify($localStorage.ticket));
        	//$location.path("/bookTicket");
        var host = $window.location.host;
        alert(host);
        var landingUrl = "http://" + host + "/cusr/#/bookTicket";
        alert(landingUrl);
        $window.location.href = landingUrl;
        }

        
        function bookTkt(val) {
        	$localStorage.ticket = self.passdata;
        }
        
        //return search results 
        function returnSearch()
        {
        //	return $localStorage.results;
        	if($scope.selectedDirection == "roundtrip")
        		return $localStorage.resultsnew;
        	else
        		return $localStorage.results;
        }
        
        //check availability
        function chkAvailable(trainNm) {
        	var startTime = '';
        	var trainType = '';
        	if($scope.selectedTicketType == "Any"){
         		trainType = 'A';
         	}
         	else if ($scope.selectedTicketType == "Express") {
         		trainType ='E';
			}       
         	else{
         		trainType ='S';
         	}
        	 $scope.depTrainType=trainType;
        	startTime = $scope.selectedFromTime +':00';
        	self.availParams = '?trainNumber='+trainNm+'&startStation='+$scope.selectedFromStation+'&startTime='+startTime+'&endStation='+$scope.selectedToStation+'&trainType='+trainType+'&date='
        //	SearchService.chkAvailable(self.availParams);
        	var res = $localStorage.available;
        	if(res == 'undefined'){
        		alert('No availability')
        	}
        	else
        		{
        		alert('Seats available')
        		}
        }
        
        //on submit of search
        function submit() {
        //	$localStorage.resultsnew = '';
        //$localStorage.results = '';
        	var trainType = '';
     		var startTime = '';
     		//self.params = '?startStation=A&startTime=06:00:00&endStation=C&trainType=S&date=';
     		if($scope.selectedTicketType == "Any"){
     		trainType = 'A';
     		}
     		else if ($scope.selectedTicketType == "Express") {
     		trainType ='E';
     		}       
     		else{
     		trainType ='S';
     		}
     		startTime = $scope.selectedFromTime +':00';
         	if($scope.selectedDirection == "roundtrip")
      		 {
         		
         		var returnTime = '';
         		returnTime = $scope.selectedToTime +':00';
         		
         		self.params = '?startStation='+$scope.selectedFromStation+'&startTime='+startTime+'&endStation='+$scope.selectedToStation+'&trainType='+trainType+'&date='
         		//alert(self.params);
         		SearchService.searchTrains1(self.params);
         		
         		self.params = '?startStation='+$scope.selectedToStation+'&startTime='+returnTime+'&endStation='+$scope.selectedFromStation+'&trainType='+trainType+'&date='
         		SearchService.searchTrainsRet(self.params);
         		var a = [];
         		var b = [];
         		var c = [];
         		a = $localStorage.results;
         		b = $localStorage.resultsRet;
         		c = a.concat(b);
         		alert(a.length);
         		alert(b.length);
         		$localStorage.resultsnew = c;
         		//alert (JSON.stringify($localStorage.resultsnew));
         		//$localStorage.results
         		//$localStorage.resultsRet
      		 }
         	else
         		{
         		self.params = '?startStation='+$scope.selectedFromStation+'&startTime='+startTime+'&endStation='+$scope.selectedToStation+'&trainType='+trainType+'&date='
         		//alert(self.params);
         		SearchService.searchTrains1(self.params);
         		}
//         	  var monobjet_json = JSON.parse(localStorage.results);
//              var List = monobjet_json.List;// TODO: get some of data from json object
//              	alert(List);
          	//alert (JSON.stringify($localStorage.results));
         	//$scope.dt = SearchService.searchTrains1(self.params);
         	//alert(self.results[0].name);
         	//$scope.results = SearchService.searchTrains1(self.params);
//            alert($scope.selectedFromStation);
//            alert($scope.selectedToStation);
//            alert($scope.selectedDirection);
//            alert($scope.date);
//            alert($scope.date1);
//            alert($scope.selectedPassengers);
//            alert($scope.selectedFromTime);
//            alert($scope.selectedToTime);
//            alert($scope.selectedTicketType);
//            alert($scope.selectedConnection);
//            alert($scope.chkExactTime);
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);