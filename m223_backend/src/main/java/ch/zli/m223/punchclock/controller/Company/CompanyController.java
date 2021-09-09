package ch.zli.m223.punchclock.controller.Company;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.Company.Company;
import ch.zli.m223.punchclock.domain.Department.Department;
import ch.zli.m223.punchclock.service.Company.CompanyService;
import ch.zli.m223.punchclock.service.Department.DepartmentService;


@Path("/companys")
@Tag(name = "Companys", description = "Handling of companys")
public class CompanyController {

    @Inject
    CompanyService companyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> list() {
        return companyService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Company add(Company company) {
       return companyService.createCompany(company);
    }

}
