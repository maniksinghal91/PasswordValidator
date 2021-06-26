# PasswordValidator

## Steps to Run

```
mvn clean install spring-boot:run
```

## Steps to Validate Password
Use Postman or any other tool to send a post request to the service

##### Resource: 
```
http://localhost:8080/validate
```

##### Headers:
```
Content-Type: application/json
```

##### Body
```
{
	  "password": "Your Password Here"
}

```
