package lk.sritel.sricare.billingservice.service;

import lk.sritel.sricare.billingservice.BillRequest;
import lk.sritel.sricare.billingservice.model.Bill;
import lk.sritel.sricare.billingservice.repository.BillingRepository;
import lk.sritel.sricare.billingservice.response.BillingResponse;
import lk.sritel.sricare.billingservice.response.PastBillsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public BillingResponse getCurrentBill(String userId) {

        try {

            Bill currentBill = billingRepository.findByUserId(userId);

            if (currentBill != null) {
                return new BillingResponse("Current bill retrieved successfully", HttpStatus.OK, currentBill);
            } else {
                return new BillingResponse("Current bill not found for the user", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return new BillingResponse("Failed to retrieve current bill", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    public BillingResponse createBill(BillRequest billRequest) {

        try {
            Bill newBill = new Bill();
            newBill.setUserId(billRequest.getUserId());
            newBill.setAmount(billRequest.getAmount());
            newBill.setPaid(false);

            Bill createdBill = billingRepository.save(newBill);

            return new BillingResponse("Bill created successfully", HttpStatus.CREATED, createdBill);
        } catch (Exception e) {
            return new BillingResponse("Failed to create the bill", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    public BillingResponse payBill(String billId) {

        try {
            Bill billToPay = billingRepository.findById(billId).orElse(null);

            if (billToPay == null) {
                return new BillingResponse("Bill not found", HttpStatus.NOT_FOUND, null);
            }

            billToPay.setPaid(true);
            billingRepository.save(billToPay);

            return new BillingResponse("Bill paid successfully", HttpStatus.OK, billToPay);
        } catch (Exception e) {
            return new BillingResponse("Failed to pay the bill", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }


}
