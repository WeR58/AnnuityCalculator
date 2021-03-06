package com.calculator.annunity.app;

import com.calculator.annunity.app.data.Credit;
import com.calculator.annunity.app.implementation.LoanRepaymentSchedule;
import org.junit.Test;

import static com.calculator.annunity.helper.AnnuityCalculatorTestHelper.assertEquals;

/**
 * Created by WeDin on 28.04.2017.
 */
public class AnnuityCalculatorScheduleOnlyOneMonthTest {
    //region class fields
    //region instants fields
    AnnuityCalculator loanRepaymentSchedule;
    //endregion
    //endregion

    public AnnuityCalculatorScheduleOnlyOneMonthTest() {
        loanRepaymentSchedule = new LoanRepaymentSchedule(new Credit(1_000L, 1, 12));
    }


    @Test
    public void getMonthsMap() throws Exception {
        assertEquals("Size map is: %s, but expected %s", loanRepaymentSchedule.getMonthsMap().size(), 1L);
    }

    @Test
    public void repaymentOfPrincipalDebtForAllTime() throws Exception {
        assertEquals("Repayment of principal debt for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentOfPrincipalDebtForAllTime(), 1_000L);
    }

    @Test
    public void repaymentInterestOnTheLoanForAllTime() throws Exception {
        assertEquals("Interest on the loan for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentInterestOnTheLoanForAllTime(), 10L);
    }

    @Test
    public void repaymentTotalMonthlyPaymentForAllTime() throws Exception {
        assertEquals("Total monthly payment for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentTotalMonthlyPaymentForAllTime(), 1010L);
    }

    @Test
    public void repaymentAboveMonthlyPaymentForAllTime() throws Exception {
        assertEquals("Above monthly payment for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentAboveMonthlyPaymentForAllTime(), 0L);
    }

}