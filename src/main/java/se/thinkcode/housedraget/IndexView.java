package se.thinkcode.housedraget;

import io.dropwizard.views.View;

import java.nio.charset.Charset;

public class IndexView extends View {
    protected IndexView() {
        super("/index.mustache", Charset.forName("UTF-8"));
    }
}