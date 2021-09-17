package com.tis.mx.application.controller;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import com.tis.mx.application.service.impl.CompoundInterestCalculatorImpl;

public class ApplicationControllerTest {

  private ApplicationController controller;
  private InitialInvestmentDto initialInvestment;
  private CompoundInterestCalculator calculator;
  
  @Before
  public void createValuesBeforeToTest() {
    this.calculator = new CompoundInterestCalculatorImpl();
    this.controller = new ApplicationController(this.calculator);
    
    this.initialInvestment = new InitialInvestmentDto();
    this.initialInvestment.setInitialInvestment(5000.00);
    this.initialInvestment.setYearlyInput(3000.00);
    this.initialInvestment.setYearlyInputIncrement(1);
    this.initialInvestment.setInvestmentYears(5);
    this.initialInvestment.setInvestmentYield(0.21f);
    
    this.controller = new ApplicationController(this.calculator);
  }
  
  @Test
  public void shouldGenerateTableYield() {
    List<InvestmentYieldDto> tableYield = controller.createTableYield(null, initialInvestment);
    
    assertEquals(5, tableYield.size());
    
    InvestmentYieldDto firstYear = tableYield.get(0);
    assertEquals(Double.valueOf(5000.00), firstYear.getInitialInvestment());
    assertEquals(Double.valueOf(3000.00), firstYear.getYearlyInput());
    assertEquals(Double.valueOf(1680.00), firstYear.getInvestmentYield());
    assertEquals(Double.valueOf(9680.00), firstYear.getFinalBalance());
  }
  
}
