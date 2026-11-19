package com.maisen.issue_tracker.service;

import com.maisen.issue_tracker.common.BusinessException;
import com.maisen.issue_tracker.entity.Issue;
import com.maisen.issue_tracker.mapper.IssueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    @Autowired
    private IssueMapper issueMapper;

    public int createIssue(Issue issue) {
        // 如果前端没传状态，我们默认给一个“待处理”
        if (issue.getStatus() == null || issue.getStatus().isEmpty()) {
            issue.setStatus("待处理");
        }
        return issueMapper.insertIssue(issue);
    }
    // 替换原来的 getIssueList 方法
    public com.github.pagehelper.PageInfo<Issue> getIssueList(int pageNum, int pageSize) {
        // 1. 开启分页（第几页，每页多少条）
        com.github.pagehelper.PageHelper.startPage(pageNum, pageSize);

        // 2. 执行查询（PageHelper 会自动帮我们在 SQL 后面拼接 LIMIT）
        java.util.List<Issue> list = issueMapper.findAll();

        // 3. 包装成 PageInfo 对象，里面包含了总条数、总页数等丰富信息
        return new com.github.pagehelper.PageInfo<>(list);
    }

    // 核心业务：处理工单（状态流转）
    public String processIssue(Integer id) {
        int rows = issueMapper.updateStatus(id, "已处理");
        if (rows == 0) {
            // 如果更新了0行，说明没有这个ID的工单
            throw new BusinessException("工单不存在，无法处理！");
        }
        return "工单状态更新成功！";
    }
}