package com.app.tobeprecise;

import com.app.tobeprecise.entities.Employee;
import com.app.tobeprecise.entities.Manager;
import com.app.tobeprecise.entities.Report;
import com.app.tobeprecise.entities.Task;
import com.app.tobeprecise.repos.EmployeeRepository;
import com.app.tobeprecise.services.EmployeeServiceImpl;
import com.app.tobeprecise.services.ManagerServiceImpl;
import com.app.tobeprecise.services.OverloadedEmployeesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.stream.StreamSupport;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TobepreciseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldReturn2overloadedEmployees() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/employees/overloaded")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(handler().methodName("getOverloadedEmployees"))
				.andExpect(jsonPath("$", hasSize(2)));

	}

	@Test
	public void shouldReturn9Reports() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/managers/3/reports")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(handler().methodName("findReportsByManager"))
				.andExpect(jsonPath("$", hasSize(9)));
	}

	@Test
	public void shouldReturn14Tasks() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/employees/4/tasks")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(handler().methodName("getTasksByEmployeeId"))
				.andExpect(jsonPath("$", hasSize(14)));
	}

	@Test
	public void createManager() throws Exception {
		Manager manager = new Manager();
		manager.setFirstName("ManagerTest");
		manager.setLastName("ManagerTest");
		String body = objectMapper.writeValueAsString(manager);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/managers/save")
				.content(body)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isCreated())
				.andExpect(handler().methodName("save"));
	}

	@Test
	public void createEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Employee");
		employee.setLastName("Employee");
		String body = objectMapper.writeValueAsString(employee);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/employees/save")
				.content(body)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isCreated())
				.andExpect(handler().methodName("save"));
	}

	@Test
	public void assignManagerToEmployee() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/employees/relationship/assign")
				.param("managerId", String.valueOf(1))
				.param("employeeId", String.valueOf(4))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(handler().methodName("assign"));
	}

	@Test
	public void createReport() throws Exception {
		Report report = new Report();
		report.setDate(LocalDate.now());
		report.setText("text");
		String body = objectMapper.writeValueAsString(report);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/employees/4/report")
				.content(body)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isCreated())
				.andExpect(handler().methodName("createReport"));
	}

	@Test
	public void createTask() throws Exception {
		Task task = new Task();
		task.setAssignDate(LocalDate.now());
		task.setDueDate(LocalDate.now().plusDays(1));
		task.setText("text");
		String body = objectMapper.writeValueAsString(task);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/managers/1/employees/4/tasks")
				.content(body)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(status().isCreated())
				.andExpect(handler().methodName("save"));
	}


}
