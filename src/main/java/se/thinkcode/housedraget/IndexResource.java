package se.thinkcode.housedraget;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class IndexResource {
    @GET
    @Produces("text/html;charset=UTF-8")
    public IndexView getRoot() {
        return new IndexView();
    }
}