package com.ptm.projectintellijexample.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProjectController {

    @GetMapping("/project")
    public String projectDashboard(){
        return "admin/project/dashboard";
    }

    @GetMapping("/project-scrum-board")
    public String scrumBoard(){
        return "admin/project/scrum-board";
    }

    @GetMapping("/project-issue")
    public String issue(){
        return "admin/project/issue";
    }
    @GetMapping("/project-list")
    public String projectList(){
        return "admin/project/list";
    }

}
