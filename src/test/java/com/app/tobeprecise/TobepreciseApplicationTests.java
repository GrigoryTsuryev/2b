package com.app.tobeprecise;

import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.logging.Filter;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TobepreciseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeServiceImpl employeeService;



	@Test
	@Sql("/data.sql")
	public void shouldReturn2overloadedEmployees() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/employees/overloaded")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk())
				.andExpect(handler().methodName("getOverloadedEmployees"))
				.andExpect(jsonPath("$", hasSize(2)));



	}

	@Test
	@Sql("/data.sql")
	public void shouldReturn9Reports() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/managers/3/reports")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk())
				.andExpect(handler().methodName("findReportsByManager"))
				.andExpect(jsonPath("$", hasSize(9)));

	}
}
