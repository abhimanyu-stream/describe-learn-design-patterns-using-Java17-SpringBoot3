package com.solid.principles.solid_principles.dependency_inversion_principle;

import com.solid.principles.solid_principles.interface_segregation_principle.solution_code.GPay;
import com.solid.principles.solid_principles.interface_segregation_principle.solution_code.Paytm;
import com.solid.principles.solid_principles.interface_segregation_principle.solution_code.PhonePay;

public class ShoppingMall {

    // For taking payment Mall person is not considering about DebitCard or CreditCard , They are just swiping and taking money as bill payment.
    // Similarly during Scan and pay , the Mall are not bother about either you are using GPay, PhonePay, Paytm, WhatsAppPay,AmazonPay, ApplePay, FacebookPay



    private BankCard bankCard;


    /*private GPay gPay;  we should use FactoryMethodPattern now
    private Paytm paytm;
    private PhonePay phonePay;*/



    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void purchaseSomething(long amount){
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        // DebitCard debitCard=new DebitCard();
        // CreditCard creditCard=new CreditCard();

        BankCard bankCard=new CreditCard();
        ShoppingMall shoppingMall=new ShoppingMall(bankCard);
        shoppingMall.purchaseSomething(5000);



    }
}
