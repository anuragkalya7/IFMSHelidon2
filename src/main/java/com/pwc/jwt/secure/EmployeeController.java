package com.pwc.jwt.secure;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.json.JsonString;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pwc.jwt.model.Employee;
import com.pwc.jwt.service.EmployeeService;

/**
 *
 */
@Path("/employee")
@OpenAPIDefinition(info = @Info(title = "Employee endpoint", version = "1.0"))
public class EmployeeController {

	@Claim("ssoid")
	private ClaimValue<JsonString> ssoid;

	@PersistenceContext
	private EntityManager entityManager;

	private final EmployeeService employeeService;

	static Logger log = LoggerFactory.getLogger(EmployeeController.class);

//	@Inject
//	@ConfigProperty(name = "roles_allowed_getEmployees")
//	String getEmpRoles;

	/**
	 * @param employeeService
	 */
	@Inject
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

//	@GET
//	@RolesAllowed({ "EMPLOYEE", "DDO" })
//  @RolesAllowed(@ConfigProperty(name = "roles_allowed_getEmployees"))
	//public void checkPermissionDetails() {
		// return "Role Details for user - " + ssoid.getValue() + " and Role details - "
		// + roleDetails.getValue();
	//}

	@GET
	@Path("/getData")
	@Operation(summary = "Rest Client Endpoint", description = "Rest Client Test API Endpoint")
	@APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
	@PermitAll
	public Response getDetails() {
		System.out.println("In API /employee/getData");
		log.info("In API /employee/getData");
		return Response.status(Response.Status.OK).entity("This is a test API response for REST Client").build();
	}

	@GET
	@Path("/get")
	@RolesAllowed({ "EMPLOYEE", "DDO" })
	@Operation(summary = "API to get Employee Details", description = "Rest API to fetch all the details of the employees")
	@APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)))
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmpDetails() {
		System.out.println("In API /employee/get");
		log.info("In API /employee/get");
		List<Employee> empList = employeeService.getAllEmployeeDetails();
		System.out.println("Employee List - " + empList.toString());
		log.info("Employee List - " + empList.toString());
		return Response.status(Response.Status.OK).entity(empList).build();
	}

	@POST
	@Path("/save")
	@RolesAllowed({"DDO"})
	@Operation(summary = "API to Create Employee", description = "Rest API to create an employee")
	@APIResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)))
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveEmployee(Employee employee) {
		System.out.println("In API /employee/save");
		log.info("In API /employee/save");
		Employee emp = employeeService.saveEmployee(employee);
		return Response.status(Response.Status.OK).entity(emp).build();
	}
}
