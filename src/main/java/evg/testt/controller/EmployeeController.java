package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 23.10.2016.
 */
@Controller
public class EmployeeController {

@Autowired
    DepartmentService depServ;
    @Autowired
    EmployeeService emplServ;

    @RequestMapping(value = "/showEmpls", method = RequestMethod.GET)
    public ModelAndView showEmpls(@RequestParam(required = true) int id)
    {
        Department d = new Department();
        try
        {
            d = depServ.getById(id);
        }
        catch (SQLException e) {e.printStackTrace();}
        return new ModelAndView(JspPath.EMPLOYEE_ALL, "departments", d);
    }

    @RequestMapping(value = "/emplAddPage", method = RequestMethod.GET)
    public ModelAndView addEmpl(@RequestParam(required = true) int depId)
    {
        List<Department> deps = new ArrayList<>();
        Department d = new Department();
        Employee empl = new Employee("");
        empl.setId(0);
        try
        {
            d = depServ.getById(depId);
            deps = depServ.getAll();
        }
        catch (SQLException e) {e.printStackTrace();}
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "departments", d).addObject("empl", empl).addObject("depList", deps);
    }

    @RequestMapping(value = "/emplAdd", method = RequestMethod.POST)
    public String insertEmpl(@RequestParam(required = true) int emId,
                             @RequestParam(required = true) int id,
                             @RequestParam(required = true) String name)
    {
        Department d = new Department();
        Employee em = new Employee();
        try
        {
            d = depServ.getById(id);
            if(emId > 0)
            {
                em = emplServ.getById(emId);
                em.setFirstName(name);
                em.setDepartment(d);
                emplServ.update(em);
            }
            else {

                em.setDepartment(d);
                em.setFirstName(name);

                emplServ.insert(em);

                d.getEmpls().add(em);
                depServ.update(d);
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        return "redirect:/showEmpls?id=" + id;
    }

    @RequestMapping(value = "/deleteEmpl", method = RequestMethod.GET)
    public String deleteEm(@RequestParam(required = true) int emId, @RequestParam(required = true) int depId)
    {
        Employee em = new Employee();
        try {
            em = emplServ.getById(emId);
            emplServ.delete(em);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return "redirect:/showEmpls?id=" + depId;
    }

    @RequestMapping(value = "/emplEdit", method = RequestMethod.GET)
    public ModelAndView editEmpl(@RequestParam(required = true) int depId, @RequestParam(required = true) int emId)
    {
        List<Department> deps = new ArrayList<>();
        Department d = new Department();
        Employee empl = new Employee("");
        empl.setId(0);
        try
        {
                empl = emplServ.getById(emId);
                d = depServ.getById(depId);
                deps = depServ.getAll();
        }
        catch (SQLException e) {e.printStackTrace();}
        return new ModelAndView(JspPath.EMPLOYEE_ADD, "departments", d).addObject("empl", empl).addObject("depList", deps);
    }

}
