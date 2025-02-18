package com.job.portal.web.application.payload;

/**
 * @Created 20/6/2024 - 9:00 AM on (Thursday)
 * @Package com.job.portal.web.application.payload
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public interface IRecruiterJobs {

    Long getTotalCandidates();

    long getId();

    String getJob_title();

    long getLocationId();

    String getCity();

    String getState();

    String getCountry();

    long getCompanyId();

    String getName();
}
