package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Style;
import com.example.demo.repository.StyleRepository;

@RestController
@RequestMapping("/api/v1/")
public class StyleController {
	
	
	@Autowired
	private StyleRepository styleRepository;
	
	//getting all styles
	@GetMapping("/styles")
	public List<Style> getAllStyles(){
		return styleRepository.findAll();
	}
	
	//create style rest api
	@PostMapping("/styles")
	public Style createStyle(@RequestBody Style style) {
		return styleRepository.save(style);
	}
	
	//get style by id using rest api
	@GetMapping("/styles/{id}")
	public ResponseEntity<Style> getStyleByID(@PathVariable int id){
		Style style = styleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Style not exists with id: "+id));
		return ResponseEntity.ok(style);
	}
	
	//update style by id using rest api
	@PutMapping("/styles/{id}")
	public ResponseEntity<Style> updateStyle(@PathVariable int id , @RequestBody Style styleDetails){
		Style style = styleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Style not exists with id: "+id));

		style.setStyleCode(styleDetails.getStyleCode());
		style.setStyleName(styleDetails.getStyleName());
		style.setStyleQuantity(styleDetails.getStyleQuantity());
		style.setStyleStatus(styleDetails.getStyleStatus());
		style.setStyleType(styleDetails.getStyleType());
		style.setStyleItemCode(styleDetails.getStyleItemCode());
		style.setStyleCategory(styleDetails.getStyleCategory());
		Style updatedStyle = styleRepository.save(style);
		return ResponseEntity.ok(updatedStyle);
	}
	
	//delete style rest api
	@DeleteMapping("/styles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStyle(@PathVariable int id){
		Style style = styleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Style not exists with id: "+id));
		styleRepository.delete(style);
		Map<String , Boolean > response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
