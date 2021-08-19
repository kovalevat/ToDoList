package ru.Tanya.spingMVCapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Tanya.spingMVCapp.DAO.TaskDAO;
import ru.Tanya.spingMVCapp.models.Task;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/todolist")
public class ToDoController {


    private TaskDAO taskDAO;

    private ToDoController(TaskDAO taskDAO)
    {
        this.taskDAO=taskDAO;
    }

    @GetMapping
    public String list(Model model) throws SQLException {
        model.addAttribute("list", taskDAO.displayList());
        return "todo/list";
    }
    @GetMapping("/{id}")
    public String detailInfo(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("task",taskDAO.detailTask(id));
        return "todo/id";
    }
    @GetMapping("/new")
    public String newTask(Model model)
    {
        model.addAttribute("task", new Task());
        return "todo/new";
    }

    @PostMapping
    public String create(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "todo/new";
        }
        taskDAO.save(task);
        return "redirect:/todolist";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id)
    {
        model.addAttribute(taskDAO.detailTask(id));
        return "todo/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult, @PathVariable("id") int id)
    {
        if(bindingResult.hasErrors())
            return "todo/edit";
        taskDAO.edit(id,task);
        return "redirect:/todolist";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id)
    {
        taskDAO.delete(id);
        return "redirect:/todolist";
    }
}
