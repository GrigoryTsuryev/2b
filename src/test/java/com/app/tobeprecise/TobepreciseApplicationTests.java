package com.app.tobeprecise;

import com.app.tobeprecise.controllers.EmployeeController;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.repos.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TobepreciseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ManagerRepository mockRepository;

	@Test
	public void shouldReturn2overloadedEmployees() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
				.get("/employees/overloaded")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));
		verify(mockRepository, times(0)).save(any(Manager.class));
	}

	@Test
	public void shouldReturn14tasks() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
				.get("/employees/4/tasks")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(14)));
	}

}
