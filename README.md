# e-Auction
Auction project

Steps:

  Start Eureka server : (Check localhost:8761)
  
  Start Product Master Micro service(Prot 8084) and trigger following end points
  
 [POST] http://localhost:8084/e-auction/api/v1/seller/add-product
  
  {
	"productName":"PRD001",
	"shortDescription":"PRD 001",
	"description":"PRODUCT 001",
	"category":"PAINTING",
	"startingPrice":"20.0",
	"bidEndDate":"2022-06-01"
}
  
  [GET] http://localhost:8084/e-auction/api/v1/seller/get-product/{productID}
  
  [DEL] http://localhost:8084/e-auction/api/v1/seller/delete/{productID}
  
 
 Start Product Transaction Service (Port 8083)
 
 [POST] Request -Save Transaction
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

[PUT] Request - Update Transaction
http://localhost:8083/e-auction/api/v1/buyer/update-bid/{productId}/{email}/{newBidAmount}


[GET] Request - For getting all transactions related to the productId
http://localhost:8083/e-auction/api/v1/buyer/getTransactions/{productId}