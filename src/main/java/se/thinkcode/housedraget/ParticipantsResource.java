package se.thinkcode.housedraget;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/participants")
public class ParticipantsResource {
    @GET
    @Produces("text/html;charset=UTF-8")
    public ParticipantsView getParticipants() {
        return new ParticipantsView();
    }
}
