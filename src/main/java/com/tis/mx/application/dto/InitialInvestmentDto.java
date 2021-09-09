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
public class InitialInvestmentDto {
  private double initialinvestment;
  private double yearlyInput;
  private int yearlyInputIncrement;
  private float investmentYield;
  private int investmentYears;

}
