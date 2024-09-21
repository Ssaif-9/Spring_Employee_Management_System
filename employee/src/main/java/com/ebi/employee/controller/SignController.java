package com.ebi.employee.controller;

import com.ebi.employee.exception.CustomException;
import com.ebi.employee.model.EmployeeDto;
import com.ebi.employee.model.EmployeeSaveDto;
import com.ebi.employee.service.EmployeeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * The SignController class handles user authentication (login, registration) and manages
 * session attributes like employee email. It uses the EmployeeServiceInterface to perform
 * business logic and interacts with the front-end using Thymeleaf templates.
 */
@Controller
@SessionAttributes("employeeEmail")  // Store employee email in session across requests
@RequiredArgsConstructor
public class SignController {

    private final EmployeeServiceInterface employeeServiceInterface;

    /**
     * Displays the login page.
     * @param model - The Model object used to pass data to the view.
     * @return The name of the login template (Login.html).
     */
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("employee", new EmployeeSaveDto());
        return "Login";
    }

    /**
     * Processes the login form submission. It authenticates the employee based on the provided email and phone.
     * Redirects to the appropriate home page based on the employee's role (admin or user).
     * @param employeeSaveDtoArg - The employee data from the login form.
     * @param model - The Model object used to pass data to the view.
     * @return A redirect URL to either admin or user home page depending on the employee's role.
     */
    @PostMapping("/login")
    public String loginEmployee(EmployeeSaveDto employeeSaveDtoArg, Model model) {
        String employeeRole = employeeServiceInterface.loginEmployee(employeeSaveDtoArg.getEmail(), employeeSaveDtoArg.getPhone());
        if (employeeRole.equals("admin")) {
            return "redirect:employee/adminHome";
        }
        else {
            model.addAttribute("employeeEmail", employeeSaveDtoArg.getEmail());
            return "redirect:employee/userHome";
        }
    }
    /**
     * Displays the registration page.
     * @param model - The Model object used to pass data to the view.
     * @return The name of the registration template (Register.html).
     */
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("employee", new EmployeeSaveDto());
        return "Register";
    }

    /**
     * Processes the registration form submission. It saves a new employee in the system.
     * After successful registration, it redirects to the login page.
     * @param employeeSaveDto - The employee data from the registration form.
     * @return A redirect URL to the login page.
     */
    @PostMapping("/register")
    public String registerEmployee(EmployeeSaveDto employeeSaveDto) {
        employeeServiceInterface.saveEmployee(employeeSaveDto);
        return "redirect:login";
    }

    /**
     * Handles exceptions of type CustomException. If a CustomException is thrown,
     * it catches the exception and passes the error details to the error page.
     * @param customException - The exception object containing error details.
     * @param model - The Model object used to pass data to the view.
     * @return The name of the error template (error.html).
     */
    @ExceptionHandler(value = CustomException.class)
    public String notFoundElement(CustomException customException, Model model) {
        model.addAttribute("error", customException);
        return "error";
    }
}
