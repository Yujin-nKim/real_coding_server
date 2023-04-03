package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.request.ProjectRequest;
import com.cnu.real_coding_server.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    //프로젝트 글을 저장
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }
    //모든 프로젝트 글 조회
    @GetMapping
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(projectService.getProjects());
    }
    //id로 저장한 프로젝트 글 조회
    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable("projectId") Integer projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId).orElse(null));
    }
    //프로젝트 글 수정
    public ResponseEntity<Project> updateProject(@PathVariable("projectId")Integer projectId, @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest).orElse(null));
    }
    //프로젝트 글 삭제
    public ResponseEntity<Void> deleteProject(@PathVariable("projectId") Integer projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
