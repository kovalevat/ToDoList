package ru.Tanya.spingMVCapp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.Tanya.spingMVCapp.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class TaskDAO {

   private final JdbcTemplate jdbcTemplate;

   @Autowired
    public TaskDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> displayList() throws SQLException {

       return jdbcTemplate.query("SELECT * FROM Task", new BeanPropertyRowMapper<>(Task.class));
    }


    public Task detailTask(int Id)
    {
      return jdbcTemplate.query("SELECT * FROM Task WHERE id=?", new Object[]{Id}, new BeanPropertyRowMapper<>(Task.class))
      .stream().findAny().orElse(null);
    }

    public void save(Task task)
    {

        jdbcTemplate.update("INSERT INTO Task (priority,  name, description, done) VALUES(?,?,?,?)", task.getPriority(),task.getName(),task.getDescription(),task.isDone());

    }

    public void edit(int id,Task taskupdated)  {

       jdbcTemplate.update("UPDATE Task SET priority=?, name=?, description=?, done=? WHERE id=?", taskupdated.getPriority(), taskupdated.getName(),taskupdated.getDescription(), taskupdated.isDone(), id);
    }

    public void delete(int id)
    {
        jdbcTemplate.update("DELETE FROM Task WHERE id=?",id);
    }
}
