package com.maisen.issue_tracker.controller;

import com.maisen.issue_tracker.common.Result;
import com.maisen.issue_tracker.entity.Issue;
import com.maisen.issue_tracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/add")
    public Result<String> addIssue(@RequestBody Issue issue) {
        int result = issueService.createIssue(issue);
        return Result.success("工单创建成功！ID为：" + issue.getId());
    }

    // 替换原来的 getList 方法
    @GetMapping("/list")
    public Result<com.github.pagehelper.PageInfo<Issue>> getList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        // 默认查第1页，每页10条
        return Result.success(issueService.getIssueList(pageNum, pageSize));
    }

    @PostMapping("/process/{id}")
    public Result<String> process(@PathVariable Integer id) {
        return Result.success(issueService.processIssue(id));
    }
}