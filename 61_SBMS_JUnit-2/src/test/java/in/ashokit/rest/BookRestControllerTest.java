package in.ashokit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.binding.Book;
import in.ashokit.services.BookServices;

@WebMvcTest(value = BookRestController.class)
public class BookRestControllerTest {

	@MockitoBean
	private BookServices bookServices;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void addBook01() throws Exception {
		when(bookServices.saveBook(ArgumentMatchers.any())).thenReturn(true);
		
		Book book = new Book(101,"Spring");
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(mapper);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addBook").contentType(MediaType.APPLICATION_JSON).content(bookJson);
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(201, status);
		
	}
	
	@Test
	public void addBook02() throws Exception {
		when(bookServices.saveBook(ArgumentMatchers.any())).thenReturn(false);
		
		Book book = new Book(101,"Spring");
		ObjectMapper mapper = new ObjectMapper();
		String bookJson = mapper.writeValueAsString(mapper);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addBook").contentType(MediaType.APPLICATION_JSON).content(bookJson);
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(400, status);
		
	}
	
	
}
