package com.job.portal.web.application.controller;

import com.job.portal.web.application.entity.JobPostActivity;
import com.job.portal.web.application.entity.RecruiterProfile;
import com.job.portal.web.application.entity.User;
import com.job.portal.web.application.payload.RecruiterJobsDto;
import com.job.portal.web.application.service.JobPostActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.job.portal.web.application.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

/**
 * @Created 19/6/2024 - 7:01 PM on (Wednesday)
 * @Package com.job.portal.web.application.controller
 * @Project job-portal-web-application
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Controller
public class JobPostActivityController {

    private final UserService userService;
    private final JobPostActivityService jobPostActivityService;

    @Autowired
    public JobPostActivityController(UserService userService, JobPostActivityService jobPostActivityService) {
        this.userService = userService;
        this.jobPostActivityService = jobPostActivityService;
    }

    @GetMapping("/dashboard")
    public String searchJobs(Model model) {

        Object currentUserProfile = userService.getCurrentUserProfile();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            model.addAttribute("username", currentUsername);
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))) {
                List<RecruiterJobsDto> recruiterJobs = jobPostActivityService.getRecruiterJobs(((RecruiterProfile) currentUserProfile).getId());
                model.addAttribute("jobPost", recruiterJobs);
            }
        }

        model.addAttribute("currentUser", currentUserProfile);

        return "dashboard";
    }


    @GetMapping("/dashboard/add")
    public String addJobs(Model model) {
        model.addAttribute("jobPostActivity", new JobPostActivity());
        model.addAttribute("user", userService.getCurrentUserProfile());
        return "add_jobs";
    }

    @PostMapping("/dashboard/addNew")
    public String addNew(JobPostActivity jobPostActivity, Model model) {

        User user = userService.getCurrentUser();
        if (user != null) {
            jobPostActivity.setPostedBy(user);
        }
        jobPostActivity.setPostedDate(new Date());
        model.addAttribute("jobPostActivity", jobPostActivity);
        jobPostActivityService.addNew(jobPostActivity);
        return "redirect:/dashboard";
    }

    @PostMapping("dashboard/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {

        JobPostActivity jobPostActivity = jobPostActivityService.getJobPostActivityById(id);
        model.addAttribute("jobPostActivity", jobPostActivity);
        model.addAttribute("user", userService.getCurrentUserProfile());
        return "add_jobs";
    }
}
