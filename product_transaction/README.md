# e-Auction
Auction Transaction project

Sample Urls

//POST Request -Save Transaction
http://localhost:8083/e-auction/api/v1/buyer/place-bid
payload

{
	"firstName" : "Fname",
	"lastName":"Lname",
	"address":"TestAddress",
	"city":"TestCity",
	"state":"TestState",
	"pin":"12345",
	"phone":"1234567890",
	"email":"test@gmail.com",
	"productId":"123",
	"bidAmount":"100.00"
}

//PUT Request - Update Transaction
http://localhost:8083/e-auction/api/v1/buyer/update-bid/{productId}/{email}/{newBidAmount}


//GET Request - For getting all transactions related to the productId
http://localhost:8083/e-auction/api/v1/buyer/getTransactions/{productId}
