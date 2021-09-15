package org.acme.migration;

import org.flywaydb.core.Flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MigrationService {

    @Inject
    Flyway flyway;

    public void checkMigrations() {

        flyway.clean();
        flyway.migrate();

        System.out.println(flyway.info());
    }
}
