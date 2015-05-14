package se.thinkcode.housedraget;

import io.dropwizard.views.View;

import java.nio.charset.Charset;

public class ParticipantsView extends View {
    protected ParticipantsView() {
        super("/participants.mustache", Charset.forName("UTF-8"));
    }
}
