package com.rest.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.template.model.User;
import com.rest.template.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/users/")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "create a new user" )
	/*   @ApiImplicitParams({
	        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
	      })*/
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = User.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User user){
		return userService.create(user);
	}
	
	@ApiOperation(value = "update an existing user")
	 /*  @ApiImplicitParams({
	        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
	      })*/
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable(value = "userId") String userId, @RequestBody User user){
		userService.update(user);
	}

	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success",  response = User.class),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User get(@RequestParam(value = "userId") String userId){
		return userService.get(userId);
	}

	/*   @ApiImplicitParams({
	        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
	      })*/
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success"),
	            @ApiResponse(code = 401, message = "Unauthorized"),
	            @ApiResponse(code = 403, message = "Forbidden"),
	            @ApiResponse(code = 404, message = "Not Found"),
	            @ApiResponse(code = 500, message = "Failure")}) 
	
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public void update(@PathVariable(value = "userId") String userId){
		userService.delete(userId);
	}
	
}
