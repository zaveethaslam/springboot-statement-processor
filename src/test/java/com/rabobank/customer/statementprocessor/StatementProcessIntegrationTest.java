package com.rabobank.customer.statementprocessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.file.Files;
import java.nio.file.Paths;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StatementProcessIntegrationTest {

	 @Autowired
	  private MockMvc mockMvc;
	 
	 @Test
	 public void test_with_requestdata() throws Exception {
		 mockMvc.perform(post("/process")
		            .contentType("application/json")
		            .content(new String(Files.readAllBytes(Paths.get("src/test/resources/request_payload.json")))))
		 .andExpect(status().is(200))
		 .andExpect(content().string("{\"result\":\"SUCCESSFUL\",\"errorRecords\":[]}"));
		            
	 }
	
}
