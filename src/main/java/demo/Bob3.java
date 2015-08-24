package demo;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@RestController
public class Bob3 {
	
	@HystrixCommand(fallbackMethod = "defaultFallback3")
    @RequestMapping(value="/", method=RequestMethod.GET)
	public String response() throws IOException{
    	// to break service 3, kill the app
		return "Service 3 response";					 						 
	}
    
    public String defaultFallback3() {
		//System.out.println("default fallback3 method");
        return "defaultfallback3 method";
	}
    
   
}
