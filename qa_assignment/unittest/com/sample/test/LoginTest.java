package com.sample.test;
 
import java.io.IOException;
import static org.easymock.EasyMock.*;

import org.junit.Test;
import com.sample.Login;

import org.junit.After;
import org.junit.Before;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

public class LoginTest {
	private Login loginServlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;
	private HttpSession mockSession;
	private RequestDispatcher dispatcher;

	@Before
	public void setUp() {
		loginServlet = new Login();
		mockRequest = createMock(HttpServletRequest.class);
		mockResponse = createMock(HttpServletResponse.class);
		mockSession = createMock(HttpSession.class);
		dispatcher = createMock(RequestDispatcher.class);
	}
	
	@After
	public void tearDown() {

	}	
	
	@Test
	public void testInit() throws ServletException{
		ServletConfig sConfig = (ServletConfig) createMock(ServletConfig.class);
        replay(sConfig);
        loginServlet.init(sConfig);
        verify(sConfig);
	}

	@Test
	public void testLoginSuccessful() throws ServletException, IOException{
				expect(mockRequest.getParameter("username")).andReturn("hu");
				expect(mockRequest.getParameter("password")).andReturn("123");
				
		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("username", "hu");
				
				expect(mockRequest.getRequestDispatcher("homepage.jsp")).andReturn(dispatcher);
				dispatcher.forward(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				loginServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}

	@Test
	public void testLoginFailedEmptyUsername() throws ServletException, IOException{
				expect(mockRequest.getParameter("username")).andReturn("");
				expect(mockRequest.getParameter("password")).andReturn("123");
				
		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("username", "");
				
				expect(mockRequest.getRequestDispatcher("register.jsp")).andReturn(dispatcher);
				dispatcher.include(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				loginServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}	

	@Test
	public void testLoginFailedEmptyPassword() throws ServletException, IOException{
				expect(mockRequest.getParameter("username")).andReturn("hu");
				expect(mockRequest.getParameter("password")).andReturn("");
				
		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("username", "hu");
				
				expect(mockRequest.getRequestDispatcher("register.jsp")).andReturn(dispatcher);
				dispatcher.include(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				loginServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}		
	
}