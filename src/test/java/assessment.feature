Feature: Testing Pet Clinic
    
##############################################	
Scenario: Admin Adding New User
    Given Base URI is valid "api/users/"
    And request content-type is "application/json"
    When valid user JSON is created and passed to request body
  And post the request
  Then response code should read 201

	Scenario: Admin Adding New Owner
    Given Base URI is valid "api/owners/"
    And request content-type is "application/json"
    When valid owner JSON is created and passed to request body
  And post the request
  Then response code should read 201

    Scenario: Admin Adding New Vet
    Given Base URI is valid "api/vets/"
    And request content-type is "application/json"
    When valid vet JSON is created and passed to request body
  And post the request
  Then response code should read 201
    
    Scenario: Admin Adding New Visits (with id 2)
    Given Base URI is valid "api/visits/"
    And request content-type is "application/json"
    When valid visit JSON is created and passed to request body
  And post the request
  Then response code should read 201
    
    Scenario: Admin Adding New Pet
    Given Base URI is valid "api/pets/"
    And request content-type is "application/json"
    When valid pet JSON is created and passed to request body
  And post the request
  Then response code should read 201
    
    Scenario: Admin Adding New Pet Types
    Given Base URI is valid "api/pettypes/"
    And request content-type is "application/json"
    When valid pet types JSON is created and passed to request body
  And post the request
  Then response code should read 201
    
    Scenario: Admin Adding New Speciality Types
    Given Base URI is valid "api/specialties/"
    And request content-type is "application/json
    When valid speciality JSON is created and passed to request body
  And post the request
  Then response code should read 201
    
###############################################

	Scenario: Vet Viewing All Pets
    Given Base URI is valid "api/pets/"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Vet Viewing A Pet
    Given Base URI is valid "api/pets/"
    And ID is "1"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Vet or Admin Viewing All Pet Types
    Given Base URI is valid "api/pettypes/"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Vet or Admin Viewing A Pet Type
    Given Base URI is valid "api/pettypes/"
    And ID is "3"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Vet or Admin Viewing All Speciality Types
    Given Base URI is valid "api/specialties/"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Vet or Admin Viewing A Speciality Type
    Given Base URI is valid "api/specialties/"
    And ID is "1"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Admin Viewing All Vets
    Given Base URI is valid "api/vets/"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Admin Viewing A Vet
    Given Base URI is valid "api/vets/"
    And ID is "5"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
    Scenario: Admin Viewing All Owners
    Given Base URI is valid "api/owners/"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
  	And response body is not null
    
    Scenario: Admin Viewing A Owner By ID
    Given Base URI is valid "api/owners/"
    And ID is "1"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
  	And response body is not null
    
    Scenario: Admin Viewing A Owner By Last Name
    Given Base URI is valid "api/owners/"
    And Last Name is "Black"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
  	And response body is not null
  	
  	Scenario: Admin Viewing All Visits
    Given Base URI is valid "api/visits/"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
 	
 	Scenario: Admin Viewing A Visit
    Given Base URI is valid "api/visits/"
    And ID is "1"
    And request content-type is "application/json;charset=UTF-8"
    When get request method is called
    Then response code should read 200
 	And response body is not null
    
###############################################
    Scenario: Admin Updating Owner Records
    Given Base URI is valid "api/owners/"
    And ID is "4"
    And request content-type is "application/json"
    When valid owner JSON with id "4" is created and passed to request body
    And put request method is called
    Then response code should read 204
    
    Scenario: Admin Updating Vet Records
    Given Base URI is valid "api/vets/"
    And ID is "4"
    And request content-type is "application/json"
    When valid vet JSON with id "4" is created and passed to request body
    And put request method is called
    Then response code should read 204
    
    Scenario: Admin Updating Visit Records
    Given Base URI is valid "api/visits/"
    And ID is "1"
    And request content-type is "application/json;charset=UTF-8"
    When valid visit JSON with id "1" is created and passed to request body
    And put request method is called
    Then response code should read 204
    
    Scenario: Owner Updating Pet Record
    Given Base URI is valid "api/pets/"
    And ID is "1"
    And request content-type is "application/json;charset=UTF-8"
    When valid pet JSON with id "1" is created and passed to request body
    And put request method is called
    Then response code should read 204
    
    Scenario: Admin Updating New Pet Types
    Given Base URI is valid "api/pets/pettypes/"
    And ID is "1"
    And request content-type is "application/json;charset=UTF-8"
    When valid pettypes JSON with id "1" is created and passed to request body
    And put request method is called
    Then response code should read 204
    
    Scenario: Admin Updating New Speciality Types
    Given Base URI is valid "api/specialties/"
    And ID is "7"
    And request content-type is "application/json;charset=UTF-8"
    When valid speciality types JSON with id "7" is created and passed to request body
    And put request method is called
    Then response code should read 204
###############################################
	Scenario: Admin Deleting Owner Record
    Given Base URI is valid "api/owners/"
    And ID is "3"
    And request content-type is "application/json;charset=UTF-8"
    When I delete a record
    Then response code should read 204
    
    Scenario: Admin Deleting Vet Records
    Given Base URI is valid "api/vets/"
    And ID is "6"
    And request content-type is "application/json;charset=UTF-8"
    When I delete a record
    Then response code should read 204
    
    Scenario: Admin Deleting Visit Records
    Given Base URI is valid "api/visits/"
    And ID is "4"
    And request content-type is "application/json;charset=UTF-8"
    When I delete a record
    Then response code should read 204
    
    Scenario: Owner Deleting Pet Records
    Given Base URI is valid "api/pets/"
    And ID is "3"
    And request content-type is "application/json;charset=UTF-8"
    When I delete a record
    Then response code should read 204
    
    Scenario: Admin Deleting A Pet Type
    Given Base URI is valid "api/pets/pettypes/"
    And ID is "2"
    And request content-type is "application/json;charset=UTF-8"
    When I delete a record
    Then response code should read 204
    
    Scenario: Admin Deleting A Speciality Type
    Given Base URI is valid "api/specialties/"
    And ID is "7"
    And request content-type is "application/json;charset=UTF-8"
    When I delete a record
    Then response code should read 204
 