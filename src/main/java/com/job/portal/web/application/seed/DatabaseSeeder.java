package com.job.portal.web.application.seed;

import com.job.portal.web.application.seed.database.RolesTableSeeder;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Created 27/6/2024 - 12:09 PM on (Thursday)
 * @Package com.job.portal.web.application.seed
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Component
public class DatabaseSeeder {
    private final RolesTableSeeder rolesTableSeeder;

    public DatabaseSeeder(RolesTableSeeder rolesTableSeeder) {
        this.rolesTableSeeder = rolesTableSeeder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        rolesTableSeeder.seedRolesTable();
    }
}
