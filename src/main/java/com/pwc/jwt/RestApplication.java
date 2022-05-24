package com.pwc.jwt;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

import com.pwc.jwt.secure.EmployeeController;

/**
 *
 */
@ApplicationPath("/jwt")
@LoginConfig(authMethod = "MP-JWT")
//@DeclareRoles({ "EMPLOYEE", "DDO", "VENDOR" })

@ApplicationScoped
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<>();

		// resources
		classes.add(EmployeeController.class);

		return classes;
	}
}
