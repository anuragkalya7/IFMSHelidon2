package com.pwc.jwt.secure;

import java.util.Collections;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonString;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;

import com.pwc.jwt.model.Greeting;

/**
 *
 */
@Path("/employee")
@RequestScoped
public class EmployeeController {

	private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

	@Inject
	@Claim("ssoid")
	private ClaimValue<JsonString> ssoid;

	@PersistenceContext
	private EntityManager entityManager;

//	@Inject
//	@ConfigProperty(name = "roles_allowed_getEmployees")
//	String getEmpRoles;
	
	@GET
	@RolesAllowed({ "EMPLOYEE"})
	//@RolesAllowed(@ConfigProperty(name = "roles_allowed_getEmployees"))
	public Response checkPermissionDetails() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Greeting> cq = cb.createQuery(Greeting.class);
		Root<Greeting> rootEntry = cq.from(Greeting.class);
		CriteriaQuery<Greeting> all = cq.select(rootEntry);
		TypedQuery<Greeting> allQuery = entityManager.createQuery(all);
		return Response.status(Response.Status.OK).entity(allQuery.getResultList()).build();

//		return "Role Details for user - " + ssoid.getValue() + " and Role details - " + roleDetails.getValue();
	}
}
