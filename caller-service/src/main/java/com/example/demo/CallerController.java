package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// @slf4j
@RestController
@RequestMapping("/api")
public class CallerController {
	
	private static final String URL = "http://localhost:8081/user";
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/getuser")
	public void getUserFromOtherService() {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(URL, List.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());
	} //done
	
	@PostMapping("/createuser")
	public void sendPostRequestToUserService(@RequestBody User user) {
		restTemplate.postForEntity(URL, user, String.class);
	} //done
	
	@PutMapping("/updateuser")
	public void sendPatchRequestToUserService(@RequestBody User user) {
		String updateURL = URL + "/" + user.getId();
		
		restTemplate.put(URL, user, String.class);
	} // ask about this tomorrow
	
	//due to how i wrote this, send just the id number in the request body (no JSON)
	@DeleteMapping("/deleteuser")
	public void sendDeleteRequestToUserService(@RequestBody Long id) {
		String deleteURL = URL + "/" + id.toString();
		restTemplate.delete(deleteURL, String.class);
	} //done
}
