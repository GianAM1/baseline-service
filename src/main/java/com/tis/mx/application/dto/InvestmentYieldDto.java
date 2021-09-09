package com.tis.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gaceves
 *
 */
@Getter
@Setter
@AllArgsConstructor

public class InvestmentYieldDto {
  private int investmentYear;
  private double initialInvestment;
  private double yearlyInput;
  private double finalBalance;
}
