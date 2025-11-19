package org.example.lab2.service;

import org.example.lab2.model.Positions;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays, int year) {
        int daysInYear = Year.isLeap(year) ? 366 : 365;
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    public double calculateQuarterlyBonus(Positions position, double salary, double q1, double q2, double q3, double q4) {
        if (!position.isManager()) {
            throw new IllegalArgumentException("Квартальная премия доступна только для менеджеров.");
        }

        double averageRating = (q1 + q2 + q3 + q4) / 4.0;
        return averageRating * salary * position.getPositionCoefficient();
    }
}