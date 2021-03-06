package com.calculator.annunity.app;

import com.calculator.annunity.app.data.Credit;
import com.calculator.annunity.app.implementation.LoanRepaymentSchedule;
import org.junit.Test;

import static com.calculator.annunity.helper.AnnuityCalculatorTestHelper.assertEquals;

/**
 * Created by WeDin on 28.04.2017.
 */
public class AnnuityCalculatorUpdateBigReverseDataTest {

    //region class fields
    //region instants fields
    AnnuityCalculator loanRepaymentSchedule;
    //endregion
    //region constant fields
    private static final long AMOUNT_OF_CREDIT = 1_000_000L;
    private static final long ABOVE_MONTHLY_PAYMENT_17_800L = 17_800L;
    private static final long ABOVE_MONTHLY_PAYMENT_40_000L = 40_000L;
    private static final long ABOVE_MONTHLY_PAYMENT_14_500L = 14_500L;
    private static final long ABOVE_MONTHLY_PAYMENT_10_000L = 10_000L;
    private static final long ABOVE_MONTHLY_PAYMENT_25_000L = 25_000L;
    private static final long ABOVE_MONTHLY_PAYMENT_15_300L = 15_300L;
    //endregion
    //region calculable fields
    private static final long REPAYMENT_ABOVE_MONTHLY_PAYMENT_FOR_ALL_TIME
            = ABOVE_MONTHLY_PAYMENT_17_800L
            + ABOVE_MONTHLY_PAYMENT_14_500L
            + ABOVE_MONTHLY_PAYMENT_40_000L
            + ABOVE_MONTHLY_PAYMENT_10_000L
            + ABOVE_MONTHLY_PAYMENT_25_000L
            + ABOVE_MONTHLY_PAYMENT_15_300L;

    private static final long REPAYMENT_OF_PRINCIPAL_DEBT_FOR_ALL_TIME
            = AMOUNT_OF_CREDIT
            - ABOVE_MONTHLY_PAYMENT_17_800L
            - ABOVE_MONTHLY_PAYMENT_14_500L
            - ABOVE_MONTHLY_PAYMENT_40_000L
            - ABOVE_MONTHLY_PAYMENT_10_000L
            - ABOVE_MONTHLY_PAYMENT_25_000L
            - ABOVE_MONTHLY_PAYMENT_15_300L;
    //endregion
    //endregion

    public AnnuityCalculatorUpdateBigReverseDataTest() {
        loanRepaymentSchedule = new LoanRepaymentSchedule(new Credit(AMOUNT_OF_CREDIT, 120, 10));
        loanRepaymentSchedule.addAboveMonthlyPayment(28, ABOVE_MONTHLY_PAYMENT_40_000L);
        loanRepaymentSchedule.addAboveMonthlyPayment(46, ABOVE_MONTHLY_PAYMENT_14_500L);
        loanRepaymentSchedule.addAboveMonthlyPayment(85, ABOVE_MONTHLY_PAYMENT_10_000L);
        loanRepaymentSchedule.addAboveMonthlyPayment(112, ABOVE_MONTHLY_PAYMENT_15_300L);
        loanRepaymentSchedule.addAboveMonthlyPayment(6, ABOVE_MONTHLY_PAYMENT_17_800L);
        loanRepaymentSchedule.addAboveMonthlyPayment(101, ABOVE_MONTHLY_PAYMENT_25_000L);
    }

    @Test
    public void getMonthsMap() throws Exception {
        assertEquals("Size map is: %s, but expected %s", loanRepaymentSchedule.getMonthsMap().size(), 120L);
    }

    @Test
    public void repaymentOfPrincipalDebtForAllTime() throws Exception {
        assertEquals("Repayment of principal debt for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentOfPrincipalDebtForAllTime(), REPAYMENT_OF_PRINCIPAL_DEBT_FOR_ALL_TIME);
    }

    @Test
    public void repaymentInterestOnTheLoanForAllTime() throws Exception {
        assertEquals("Interest on the loan for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentInterestOnTheLoanForAllTime(), 549_263L);
    }

    @Test
    public void repaymentTotalMonthlyPaymentForAllTime() throws Exception {
        assertEquals("Total monthly payment for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentTotalMonthlyPaymentForAllTime(), 1_426_663L);
    }

    @Test
    public void repaymentAboveMonthlyPaymentForAllTime() throws Exception {
        assertEquals("Above monthly payment for all time is: %s, but expected %s",
                loanRepaymentSchedule.repaymentAboveMonthlyPaymentForAllTime(), REPAYMENT_ABOVE_MONTHLY_PAYMENT_FOR_ALL_TIME);
    }

}