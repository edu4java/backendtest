package com.edu4java.backendtest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edu4java.backendtest.model.PvpResponse;
import com.edu4java.backendtest.service.PvpService;

@Controller
public class PvpController {

    @Autowired
    private PvpService pvpService;  
    
	@GetMapping(value="pvp/{brandId}/{productId}/{date}" )
	public ResponseEntity<PvpResponse> getPvp(
				@PathVariable(value="brandId") Long brandId, 
				@PathVariable(value="productId") Long productId,			
				@PathVariable(value="date") String date) {

		PvpResponse pvpResponse = pvpService.getPvp(brandId, productId, date);
		if (pvpResponse == null) {
			return new ResponseEntity<PvpResponse>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(pvpResponse);
		}
	}

}
