package lk.sritel.sricare.billingservice.controller;

import lk.sritel.sricare.billingservice.BillRequest;
import lk.sritel.sricare.billingservice.response.BillingResponse;
import lk.sritel.sricare.billingservice.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/current-bill/{userId}")
    public BillingResponse getCurrentBill(@PathVariable String userId) {
        return billingService.getCurrentBill(userId);
    }

    @PostMapping("/create-bill")
    public BillingResponse createBill(@RequestBody BillRequest billRequest) {
        return billingService.createBill(billRequest);
    }

    @PostMapping("/pay-bill/{billId}")
    public BillingResponse payBill(@PathVariable String billId) {
        return billingService.payBill(billId);
    }

}
