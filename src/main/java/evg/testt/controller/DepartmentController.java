package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController2 {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        Department d = new Department();
        d.setId(0);
        d.setName("");
        return new ModelAndView(JspPath.DEPARTMENT_ADD, "departments", d);
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) String name, @RequestParam(required = true) int id) {
        Department addedDepartment = new Department();
        addedDepartment.setName(name);
        try {
            if(id <= 0)
            departmentService.insert(addedDepartment);
            else
            {
                addedDepartment.setId(id);
                departmentService.update(addedDepartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


    @RequestMapping(value = "/depdell", method = RequestMethod.GET)
    public String depDel(@RequestParam(required = true) int id)
    {
        try {
            Department d = departmentService.getById(id);
            departmentService.delete(d);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


    @RequestMapping(value = "/depToEdit", method = RequestMethod.GET)
    public ModelAndView depEdit(@RequestParam(required = true) int id)
    {
        Department d = new Department();
        try {
             d = departmentService.getById(id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ADD, "departments", d);
    }
}
