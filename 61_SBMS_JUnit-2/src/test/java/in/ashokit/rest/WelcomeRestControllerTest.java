package in.ashokit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.services.WelcomeServices;

@WebMvcTest(value = WelcomeRest.class)
public class WelcomeRestControllerTest {

	@MockitoBean
	private WelcomeServices welcomeServices;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testWelcomeMsg() throws Exception {
		when(welcomeServices.getWelcomeMsg()).thenReturn("good morning");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcReturn = perform.andReturn();
		MockHttpServletResponse response = mvcReturn.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
		
	}
	
	
	
}
