Feature: Booking Flight Ticket
	Scenario: Search one way flight
		Given the user is on flight serch page (siteurl="https://www.flipkart.com/travel/flights")
		When the user enters source and destination (sourcePlace="Chennai", destPlace="Bangalore")
		And selects the date of journey (dateOfJourney="3 Sep, Wed")
	#	And selects the traveller and cabinet class
		And the user clicks search button 
		Then the user redirects to search result page