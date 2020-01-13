package pl.slawomirsobkowiak.bodycalc.service;

import pl.slawomirsobkowiak.bodycalc.model.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateBmi {

    public static Person yourBmi(Person person) {

        BigDecimal heightx2 = new BigDecimal(person.getHeight()).multiply(new BigDecimal(2.0));
        BigDecimal bmi = new BigDecimal(person.getWeight()).divide(heightx2, 4, RoundingMode.HALF_UP).movePointRight(2);
        Person personWithBMI = new Person(person.getId(), person.getHeight(), person.getWeight(),
                person.getSex(), bmi);

        return personWithBMI;
    }

}
