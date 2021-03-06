package ch.zli.m223.punchclock.controller.Department;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.Department.Department;
import ch.zli.m223.punchclock.service.Department.DepartmentService;


@Path("/departmetns")
@Tag(name = "Department", description = "Handling of departmetns")
public class DepartmentController {

    @Inject
    DepartmentService departmentService;

     //Get all Departments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> list() {
        return departmentService.findAll();
    }

     //Create Department
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Department add(Department department) {
       return departmentService.createDepartment(department);
    }

}
