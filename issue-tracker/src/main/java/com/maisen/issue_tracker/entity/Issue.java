package com.maisen.issue_tracker.entity;

import java.time.LocalDateTime;

public class Issue {
    private Integer id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    // 下面是 Getter 和 Setter 方法（如果你加了 Lombok，可以用 @Data 注解代替）
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}