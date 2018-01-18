package com.springinaction.pizza.flow;

import com.springinaction.pizza.domain.*;
import com.springinaction.pizza.service.CustomerNotFoundException;
import com.springinaction.pizza.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.springinaction.pizza.domain.PaymentType.CREDIT_CARD;

@Component
public class PizzaFlowActions {
    private static final Logger LOGGER = Logger.getLogger(PizzaFlowActions.class);

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
        Customer customer = customerService.lookupCustomer(phoneNumber);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }

    public boolean checkDeliveryArea(String zipCode) {
        LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
        return "75075".equals(zipCode);
    }

    public void addCustomer(Customer customer) {
        LOGGER.warn("TODO: Flesh out the addCustomer() method.");
    }

    public void saveOrder(Order order) {
        LOGGER.warn("TODO: Flesh out the saveOrder() method.");
    }

    public Payment verifyPayment(PaymentDetails paymentDetails) {
        Payment payment;
        if(paymentDetails.getPaymentType() == CREDIT_CARD) {
            payment = new CreditCardPayment();
        } else {
            payment = new CashOrCheckPayment();
        }

        return payment;
    }
}
