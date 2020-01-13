package pl.slawomirsobkowiak.bodycalc.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.slawomirsobkowiak.bodycalc.model.Person;
import pl.slawomirsobkowiak.bodycalc.service.CalculateBmi;
import pl.slawomirsobkowiak.bodycalc.service.CalculatorService;


@Controller

    public class MainController {
    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "index";
    }

    @RequestMapping(value = "/add-person-body-calc", method = RequestMethod.POST)
    public String calculateBmi(@RequestParam() Long weight, @RequestParam() Long height,
                               @RequestParam() String sex, Model model) {

                Person newPerson = new Person(999, height, weight, sex);
                newPerson = CalculateBmi.yourBmi(newPerson);
                this.calculatorService.savePerson(newPerson);
                model.addAttribute("BodyCalcResult", newPerson);

        return "result";
    }

    @RequestMapping(value = "/search-for-id", method = RequestMethod.GET)
    public String searchById(@RequestParam int personId, Model model) {
        model.addAttribute("BodyCalcResult", this.calculatorService.getPersonById(personId));
        return "result";
    }
}
