package ch.zli.m223.punchclock.controller.User;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.ViewModel.LoginViewModel;
import ch.zli.m223.punchclock.domain.User.User;
import ch.zli.m223.punchclock.service.User.UserService;

@Path("/users")
@Tag(name = "Users", description = "Handling of users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User add(User user) {
       return userService.createUser(user);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User edit(User user) {
       return userService.updateUser(user);
    }

    @POST
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User User(LoginViewModel loginViewModel){

        var user = userService.getUser(loginViewModel.getUsername(), loginViewModel.getPassword());
        return user;
        
    }

}
