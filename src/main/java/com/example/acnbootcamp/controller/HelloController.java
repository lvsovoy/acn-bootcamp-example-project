package com.example.acnbootcamp.controller;

import com.example.acnbootcamp.model.DeploymentInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Value("${app.deployment.branch:unknown}")
    private String deploymentBranch;

    @Value("${app.deployment.commit:unknown}")
    private String deploymentCommit;

    @Value("${app.deployment.timestamp:unknown}")
    private String deploymentTimestamp;

    @GetMapping("/")
    public String index(Model model) {
        DeploymentInfo deploymentInfo = new DeploymentInfo(
            deploymentBranch,
            deploymentCommit,
            deploymentTimestamp
        );
        model.addAttribute("deploymentInfo", deploymentInfo);
        return "index";
    }

}
