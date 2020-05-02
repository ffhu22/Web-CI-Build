package com.sample.test;
 
import static org.junit.Assert.*;
import java.io.IOException;
import static org.easymock.EasyMock.*;
import org.junit.Test;
import com.sample.Login;
import com.sample.Register;

import org.junit.After;
import org.junit.Before;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

public class RegisterTest {
	private Register regServlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;
	private HttpSession mockSession;
	private RequestDispatcher dispatcher;

	@Before
	public void setUp() {
		regServlet = new Register();
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
        regServlet.init(sConfig);
        verify(sConfig);
	}
	
	@Test
	public void testRegisterSuccessful() throws ServletException, IOException{
				expect(mockRequest.getParameter("first_name")).andReturn("Andy");
				expect(mockRequest.getParameter("last_name")).andReturn("Smith");		
				expect(mockRequest.getParameter("username")).andReturn("amber");
				expect(mockRequest.getParameter("password")).andReturn("123");
				expect(mockRequest.getParameter("address")).andReturn("street");
				expect(mockRequest.getParameter("contact")).andReturn("987");				

		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("username", "amber");
				mockSession.setAttribute("password", "123");
				
				expect(mockRequest.getRequestDispatcher("logon.jsp")).andReturn(dispatcher);
				dispatcher.forward(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				regServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}

	@Test
	public void testRegisterFailedEmptyFirstName() throws ServletException, IOException{
				expect(mockRequest.getParameter("first_name")).andReturn("");
				expect(mockRequest.getParameter("last_name")).andReturn("Smith");		
				expect(mockRequest.getParameter("username")).andReturn("amber");
				expect(mockRequest.getParameter("password")).andReturn("123");
				expect(mockRequest.getParameter("address")).andReturn("street");
				expect(mockRequest.getParameter("contact")).andReturn("987");				

		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("first_name", "");
				mockSession.setAttribute("last_name", "Smith");
				mockSession.setAttribute("address", "street");
				mockSession.setAttribute("contact", "987");
				//mockSession.setAttribute("password", "123");
				mockSession.setAttribute("username", "amber");
				
				expect(mockRequest.getRequestDispatcher("register.jsp")).andReturn(dispatcher);
				dispatcher.include(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				regServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}

	@Test
	public void testRegisterFailedEmptyLastName() throws ServletException, IOException{
				expect(mockRequest.getParameter("first_name")).andReturn("Amy");
				expect(mockRequest.getParameter("last_name")).andReturn("");		
				expect(mockRequest.getParameter("username")).andReturn("amber");
				expect(mockRequest.getParameter("password")).andReturn("123");
				expect(mockRequest.getParameter("address")).andReturn("street");
				expect(mockRequest.getParameter("contact")).andReturn("987");				

		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("first_name", "Amy");
				mockSession.setAttribute("last_name", "");
				mockSession.setAttribute("address", "street");
				mockSession.setAttribute("contact", "987");
				//mockSession.setAttribute("password", "123");
				mockSession.setAttribute("username", "amber");
				
				expect(mockRequest.getRequestDispatcher("register.jsp")).andReturn(dispatcher);
				dispatcher.include(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				regServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}
	
	@Test
	public void testRegisterFailedEmptyUserName() throws ServletException, IOException{
				expect(mockRequest.getParameter("first_name")).andReturn("Amy");
				expect(mockRequest.getParameter("last_name")).andReturn("Smith");		
				expect(mockRequest.getParameter("username")).andReturn("");
				expect(mockRequest.getParameter("password")).andReturn("123");
				expect(mockRequest.getParameter("address")).andReturn("street");
				expect(mockRequest.getParameter("contact")).andReturn("987");				

		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("first_name", "Amy");
				mockSession.setAttribute("last_name", "Smith");
				mockSession.setAttribute("address", "street");
				mockSession.setAttribute("contact", "987");
				//mockSession.setAttribute("password", "123");
				mockSession.setAttribute("username", "");
				
				expect(mockRequest.getRequestDispatcher("register.jsp")).andReturn(dispatcher);
				dispatcher.include(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				regServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}

	@Test
	public void testRegisterFailedEmptyPassword() throws ServletException, IOException{
				expect(mockRequest.getParameter("first_name")).andReturn("Amy");
				expect(mockRequest.getParameter("last_name")).andReturn("Smith");		
				expect(mockRequest.getParameter("username")).andReturn("Amber");
				expect(mockRequest.getParameter("password")).andReturn("");
				expect(mockRequest.getParameter("address")).andReturn("street");
				expect(mockRequest.getParameter("contact")).andReturn("987");				

		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("first_name", "Amy");
				mockSession.setAttribute("last_name", "Smith");
				mockSession.setAttribute("address", "street");
				mockSession.setAttribute("contact", "987");
				//mockSession.setAttribute("password", "123");
				mockSession.setAttribute("username", "Amber");
				
				expect(mockRequest.getRequestDispatcher("register.jsp")).andReturn(dispatcher);
				dispatcher.include(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				regServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}

	@Test
	public void testRegisterFailedUsernameDenver() throws ServletException, IOException{
				expect(mockRequest.getParameter("first_name")).andReturn("Amy");
				expect(mockRequest.getParameter("last_name")).andReturn("Smith");		
				expect(mockRequest.getParameter("username")).andReturn("Denver");
				expect(mockRequest.getParameter("password")).andReturn("123");
				expect(mockRequest.getParameter("address")).andReturn("street");
				expect(mockRequest.getParameter("contact")).andReturn("987");				

		        expect(mockRequest.getSession()).andReturn(mockSession);
				mockSession.setAttribute("first_name", "Amy");
				mockSession.setAttribute("last_name", "Smith");
				mockSession.setAttribute("address", "street");
				mockSession.setAttribute("contact", "987");
				//mockSession.setAttribute("password", "123");
				mockSession.setAttribute("username", null);
				
				expect(mockRequest.getRequestDispatcher("register.jsp")).andReturn(dispatcher);
				dispatcher.include(mockRequest, mockResponse);

				//回放
				replay(mockRequest);
				replay(mockResponse);
				replay(mockSession);
				replay(dispatcher);
				
				//开始测试Servlet的doPost方法
				regServlet.doPost(mockRequest, mockResponse);
				
				//验证
				verify(mockRequest);
				verify(mockResponse);
				verify(mockSession);
				verify(dispatcher);
	}
}