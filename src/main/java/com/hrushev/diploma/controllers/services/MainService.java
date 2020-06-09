package com.hrushev.diploma.controllers.services;

import com.hrushev.diploma.controllers.processors.Calculator;
import com.hrushev.diploma.controllers.processors.Parser;
import com.hrushev.diploma.model.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainService {

    @RequestMapping("/process")
    public String process(@RequestBody String dataList, Model model) {
        List<Data> list = Parser.parseDataList(dataList);
        Data optimalData = Calculator.process(list);

        model.addAttribute("optimalDataName", optimalData.getName());
        model.addAttribute("optimalDataProfit", optimalData.getBruttoProfit());

        return "result";
    }
}
