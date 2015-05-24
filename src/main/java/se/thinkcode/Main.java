package se.thinkcode;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import se.thinkcode.housedraget.IndexResource;
import se.thinkcode.housedraget.KeepAlive;
import se.thinkcode.housedraget.ParticipantsResource;
import se.thinkcode.infrastructure.Configuration;
import se.thinkcode.infrastructure.HealthCheck;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "housedraget";
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.healthChecks().register("HealthCheck", new HealthCheck());
        environment.jersey().register(new IndexResource());
        environment.jersey().register(new ParticipantsResource());

        // scheduleKeepAlive(environment);
    }

    private void scheduleKeepAlive(Environment environment) {
        String name = "keepalive";
        ScheduledExecutorService ses = environment.lifecycle().scheduledExecutorService(name).build();
        Runnable keepAlive = new KeepAlive();
        ses.scheduleAtFixedRate(keepAlive, 0, 50, TimeUnit.MINUTES);
    }
}