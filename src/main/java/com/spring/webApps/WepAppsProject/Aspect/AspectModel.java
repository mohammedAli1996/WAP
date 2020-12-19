package com.spring.webApps.WepAppsProject.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.spring.webApps.WepAppsProject.Car.CarsService;
import com.spring.webApps.WepAppsProject.Parameters.ParametersService;
import com.spring.webApps.WepAppsProject.security.User;
import com.spring.webApps.WepAppsProject.security.UserRepository;

import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AspectModel {
	
	//logging 
	Logger carsLogger =LoggerFactory.getLogger(CarsService.class);
	Logger paramsLogger = LoggerFactory.getLogger(ParametersService.class);
	
	@Autowired
	private UserRepository userRepo ; 
	
	
	/*
	@Before("execution(* com.spring.webApps.WepAppsProject.Car.CarsController..*(..)))")
	public void secureCarsService(JoinPoint  proceedingJoinPoint)  {
			System.out.println("intercepting Cars Controller methods ");
			printFunctionCallInfo(proceedingJoinPoint);
			//User user = get_current_User();    
			//user.flatUserDetailes();   
	}
	*/
	
	/*
	@Before("execution(* com.spring.webApps.WepAppsProject.Parameters..*(..)))")
	public void secureParamsService(JoinPoint  proceedingJoinPoint)  {
			System.out.println("intercepting Parameters Controller ");
			printFunctionCallInfo(proceedingJoinPoint);
			//User user = get_current_User();    
			//user.flatUserDetailes();   
	}
*/
	
	private User get_current_User() {
		String username ; 
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    Object principal =  auth.getPrincipal();
	    if(principal instanceof UserDetails) {
	    	username = ((UserDetails) principal).getUsername() ; 
		    for(User user : this.userRepo.findAll()) {
		    	if(user.getUsername().equalsIgnoreCase(username)) {
		    		return user ; 
		 		}
		 	}
	    }
	    return null  ; 
    }

	
	private String printFunctionCallInfo(JoinPoint  proceedingJoinPoint) {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        String[] param = methodSignature.getParameterNames();
       String out = "excution request for : " + className + "." + methodName ; 
        System.out.println("excution request for : " + className + "." + methodName );
        for(String parameter : param ) {
        	out+="with parameter : "+parameter ; 
        	System.out.println("with parameter : "+parameter);
        }
        return out ; 
	}
		
}