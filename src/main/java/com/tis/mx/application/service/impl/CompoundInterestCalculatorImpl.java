/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: CompoundInterestCalculatorImpl.java
* Autor: gaceves
* Fecha de creación: 17 sep 2021
*/
package com.tis.mx.application.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author gaceves
 *
 */
@Service
public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator {

  @Override
  @HystrixCommand(commandKey = "createRevenueGrid", fallbackMethod = "fallbackRevenueGrid")
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestmentDto) {
    Integer investmentYear = 0;
    Double initialInvestment = 0.00;
    Double yearlyInput = 0.00;
    Double investmentYield = 0.00;
    Double finalBalance = 0.00;

    ArrayList<InvestmentYieldDto> investmentYieldList = new ArrayList<>();
    float aux = 0;
    for (int i = 0; i < initialInvestmentDto.getInvestmentYears(); i++) {
      investmentYear = i + 1;
      yearlyInput = initialInvestmentDto.getYearlyInput() + aux;
      aux += yearlyInput * initialInvestmentDto.getYearlyInputIncrement() / 100;
      aux = (float) Math.ceil(aux);

      if (i == 0) {
        initialInvestment = initialInvestmentDto.getInitialInvestment();
      } else if (i > 0) {
        initialInvestment = finalBalance;
      }

      investmentYield =
          (initialInvestment + yearlyInput) * initialInvestmentDto.getInvestmentYield();
      finalBalance = initialInvestment + yearlyInput + investmentYield;
      investmentYieldList.add(new InvestmentYieldDto(investmentYear, initialInvestment, yearlyInput,
          investmentYield, finalBalance));
    }
    return investmentYieldList;
  }

  /**
   * Fallback revenue grid.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return the list
   */
  public List<InvestmentYieldDto> fallbackRevenueGrid(InitialInvestmentDto initialInvestmentDto) {
    return null;
  }

  @Override
  public boolean validateInput(InitialInvestmentDto initialInvestment) {

    this.setDefaults(initialInvestment);
    boolean cumple = true;

    cumple = cumple && (initialInvestment.getInitialInvestment() >= 1000);
    cumple = cumple && (initialInvestment.getYearlyInput() >= 0.0);
    cumple = cumple && (initialInvestment.getYearlyInputIncrement() >= 0.0);
    cumple = cumple && (initialInvestment.getInvestmentYield() > 0.0);
    cumple = cumple && (initialInvestment.getInvestmentYield() > 0.0);

    return cumple;

  }

  private void setDefaults(InitialInvestmentDto initialInvestment) {
    Double yearlyInput = initialInvestment.getYearlyInput();
    yearlyInput = yearlyInput == null ? 0.0 : yearlyInput;
    initialInvestment.setYearlyInput(yearlyInput);

    Integer yearlyInputIncrement = initialInvestment.getYearlyInputIncrement();
    yearlyInputIncrement = yearlyInputIncrement == null ? 0 : yearlyInputIncrement;
    initialInvestment.setYearlyInputIncrement(yearlyInputIncrement);

  }



}
