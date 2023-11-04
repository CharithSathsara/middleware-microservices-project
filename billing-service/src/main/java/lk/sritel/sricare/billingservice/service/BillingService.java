package lk.sritel.sricare.billingservice.service;

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

//    public BillingResponse getCurrentBill(String userId) {
//
//        try {
////            Bill currentBill = billingRepository.findByUserId(userId);
//            //In order to generate the current bill, this should interact with data-top-up service and ring-tone-service
//
////            if (currentBill != null) {
////                return new BillingResponse("Current bill retrieved successfully", HttpStatus.OK, currentBill);
////            } else {
////                return new BillingResponse("Current bill not found for the user", HttpStatus.NOT_FOUND, null);
////            }
//        } catch (Exception e) {
//            return new BillingResponse("Failed to retrieve current bill", HttpStatus.INTERNAL_SERVER_ERROR, null);
//        }
//    }

    public PastBillsResponse getPastBills(String userId) {

        try {

            List<Bill> pastBills = billingRepository.findByUserId(userId);

            if (pastBills != null && !pastBills.isEmpty()) {
                return new PastBillsResponse("Past bill retrieved successfully", HttpStatus.OK, pastBills);
            } else {
                return new PastBillsResponse("No past bills found for the user", HttpStatus.NOT_FOUND, null);
            }

        } catch (Exception e) {
            return new PastBillsResponse("Failed to retrieve past bills", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

}
