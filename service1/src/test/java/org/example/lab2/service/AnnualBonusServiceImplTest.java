package org.example.lab2.service;

import org.example.lab2.model.Positions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnnualBonusServiceImplTest {

    @Test
    void calculate() {
        Positions positions = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        int year = 2024;

        double result = new AnnualBonusServiceImpl().calculate(positions, salary, bonus, workDays, year);

        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}