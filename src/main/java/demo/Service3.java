package demo;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@RestController
public class Service3 {
	
	@HystrixCommand(fallbackMethod = "defaultFallback3")
    @RequestMapping(value="/", method=RequestMethod.GET)
	public String response() throws IOException{
    	// to break service 3, stop the app
		return "Connected to service 3. <hr>"
				+ "Connection S1 -> S2 -> S3 is working.";					 						 
	}
    
    public String defaultFallback3() {

        return "defaultfallback3 method";
        
	}
    
   
}
