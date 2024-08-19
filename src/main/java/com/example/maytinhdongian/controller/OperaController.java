package com.example.maytinhdongian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperaController {
    @GetMapping("")
    public String index() {
        return "index";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam("num1") int num1,
                            @RequestParam("num2") int num2,
                            @RequestParam("operation") String operation,
                            Model model) {
        int result = 0;

        switch (operation) {
            case "Addition":
                result = num1 + num2;
                break;
            case "Subtraction":
                result = num1 - num2;
                break;
            case "Multiplication":
                result = num1 * num2;
                break;
            case "Division":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    model.addAttribute("error", "Cannot divide by zero");
                    return "calculator";
                }
                break;
        }

        model.addAttribute("result", result);
        return "index";
    }
}