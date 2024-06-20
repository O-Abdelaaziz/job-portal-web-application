package com.job.portal.web.application.controller;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.service.JobPostActivityService;
import com.job.portal.web.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Created 20/6/2024 - 10:07 AM on (Thursday)
 * @Package com.job.portal.web.application.controller
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Controller
public class JobSeekerApplyController {

    private final JobPostActivityService jobPostActivityService;
    private final UserService userService;

    @Autowired
    public JobSeekerApplyController(JobPostActivityService jobPostActivityService, UserService userService) {
        this.jobPostActivityService = jobPostActivityService;
        this.userService = userService;
    }


    @GetMapping("/job-details-apply/{id}")
    public String display(@PathVariable(name = "id") Long id, Model model) {
        JobPostActivity jobPostActivity = jobPostActivityService.getJobPostActivityById(id);
        model.addAttribute("jobDetails", jobPostActivity);
        model.addAttribute("currentUser", userService.getCurrentUserProfile());
        return "job_details";
    }
}
