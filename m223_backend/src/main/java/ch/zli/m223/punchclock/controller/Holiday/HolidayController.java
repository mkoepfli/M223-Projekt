package ch.zli.m223.punchclock.controller.Holiday;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ch.zli.m223.punchclock.domain.Holiday.Holiday;
import ch.zli.m223.punchclock.service.Holiday.HolidayService;

@Path("/holidays")
@Tag(name = "Holiday", description = "Handling of holidays")
@RolesAllowed({"User"})
public class HolidayController {

    @Inject
    HolidayService holidayService;

     //Get all holidays
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Holiday> list() {
        return holidayService.findAll();
    }

     //Create holidays
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Holiday add(Holiday holiday) {
       return holidayService.createHoliday(holiday);
    }

}
