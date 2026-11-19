package com.maisen.issue_tracker.mapper;

import com.maisen.issue_tracker.entity.Issue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IssueMapper {
    @Insert("INSERT INTO issue (title, description, status) VALUES (#{title}, #{description}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertIssue(Issue issue);

    // 把原来的 findAll 替换成下面这个：
    @Select("SELECT * FROM issue ORDER BY created_at DESC")
    @Results({
            // 告诉 MyBatis：数据库的 created_at 字段，对应实体类的 createdAt 属性
            @Result(column = "created_at", property = "createdAt")
    })
    List<Issue> findAll();

    @Update("UPDATE issue SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Integer id, @Param("status") String status);
    // 在 IssueMapper 接口里追加：
    @Select("SELECT COUNT(*) FROM issue")
    long countIssues();
}