//package co.edu.udea.runtwebapp.config.cors;
//
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.ResponseBuilder;
//
//import com.sun.jersey.spi.container.ContainerRequest;
//import com.sun.jersey.spi.container.ContainerResponse;
//import com.sun.jersey.spi.container.ContainerResponseFilter;
//
//public class RuntWebAppContainerResponseFilter implements ContainerResponseFilter{
//	
//	public RuntWebAppContainerResponseFilter() {
//		super();
//	}
//
//	@Override()
//	public ContainerResponse filter(ContainerRequest requestContext,
//			ContainerResponse responseContext) {
//		String ambiente= "http://localhost:8080";
//		//String ambiente= "https://appcarsharing-web.herokuapp.com";
//		ResponseBuilder responseBuilder = Response.fromResponse(responseContext
//				.getResponse());
//
//		responseBuilder.header("Access-Control-Allow-Origin", ambiente);
//		responseBuilder.header("Access-Control-Allow-Methods",
//				"GET, POST, OPTIONS, PUT");
//		responseBuilder.header("Access-Control-Allow-Headers",
//				"origin, content-type, accept, authorization");
//		responseBuilder.header("Access-Control-Allow-Credentials", "true");
//
//		String requestHeader = requestContext
//				.getHeaderValue("Access-Control-Request-Headers");
//
//		if ((null != requestHeader) && !(requestHeader.equals(""))) {
//			responseBuilder.header("Access-Control-Allow-Headers",
//					requestHeader);
//		}
//		responseContext.setResponse(responseBuilder.build());
//
//		return (responseContext);
//	}
//}
