package com.tis.mx.application.service.impl;

import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.List;

/**
 * @author gaceves
 *
 */
public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator {

  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean validateInput(InitialInvestmentDto initialInvestment) {
    // TODO Auto-generated method stub
    return false;
  }

}
