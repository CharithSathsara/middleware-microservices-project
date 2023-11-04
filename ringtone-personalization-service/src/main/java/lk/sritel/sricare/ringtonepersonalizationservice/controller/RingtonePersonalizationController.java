package lk.sritel.sricare.ringtonepersonalizationservice.controller;

import lk.sritel.sricare.ringtonepersonalizationservice.request.RingtonePersonalizationRequest;
import lk.sritel.sricare.ringtonepersonalizationservice.response.RingtonePersonalizationResponse;
import lk.sritel.sricare.ringtonepersonalizationservice.service.RingtonePersonalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ringtone-personalization")
public class RingtonePersonalizationController {

    @Autowired
    private RingtonePersonalizationService personalizationService;

    @PostMapping("/set-ringtone/{userId}")
    public RingtonePersonalizationResponse setRingtone(@PathVariable String userId, @RequestBody RingtonePersonalizationRequest request) {
        return personalizationService.setRingtone(userId, request);
    }

    @GetMapping("/get-ringtone/{userId}")
    public RingtonePersonalizationResponse getRingtone(@PathVariable String userId) {
        return personalizationService.getRingtone(userId);
    }

}
