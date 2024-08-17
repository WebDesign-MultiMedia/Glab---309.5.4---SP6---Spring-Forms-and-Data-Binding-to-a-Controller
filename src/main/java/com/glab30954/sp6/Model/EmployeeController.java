package com.glab30954.sp6.Model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class EmployeeController {
    private Map<Long, Employee> employeeMap = new HashMap<>();

    @GetMapping("/employeeform")
    public String empForm (ModelMap model)
    {
        return "employeeform";
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee,
                         ModelMap model){


        if(employee.getId() == 0){
            model.addAttribute("error", "ID cannot be empty");
            return "employeeform";
        }

        model.addAttribute("name", employee.getName());
        model.addAttribute("id", employee.getId());
        model.addAttribute("contactNumber", employee.getContactNumber());
        employeeMap.put(employee.getId(), employee);
        return "employeeView";
    }
}

