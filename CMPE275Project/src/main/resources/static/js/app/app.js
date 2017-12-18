var app = angular.module('crudApp',['ui.router','ngStorage','720kb.datepicker']);

app.constant('urls', {
    BASE: 'http://localhost:8080/cusr',
    USER_SERVICE_API : 'http://localhost:8080/cusr/api/user/',
    TRAIN_SEARCH_API : 'http://localhost:8080/cusr/api/search',
    TICKET_SEARCH_API : 'http://localhost:8080/cusr/api/ticket/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
	  $stateProvider
	   .state('home', {
	          url: '/',
	          templateUrl: 'partials/search',
	          controller:'SearchController',
	          controllerAs:'ctrl'
	      })
	       .state('bookTicket', {
	          url: '/bookTicket',
	          templateUrl: 'partials/bookTicket',
	          controller:'BookTicketController',
	          controllerAs:'bookticketctrl',
              resolve: {
                  users: function ($q, BookTicketService) {
                      console.log('Load Booking Details');
                      var deferred = $q.defer();
                      BookTicketService.loadSearchDetails().then(deferred.resolve, deferred.resolve);
                      return deferred.promise;
                  }
              }
	      });
        $urlRouterProvider.otherwise('/');
    }]);

