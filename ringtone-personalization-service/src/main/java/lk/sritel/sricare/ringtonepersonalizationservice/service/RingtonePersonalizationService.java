package lk.sritel.sricare.ringtonepersonalizationservice.service;

import lk.sritel.sricare.ringtonepersonalizationservice.model.Ringtone;
import lk.sritel.sricare.ringtonepersonalizationservice.repository.RingtoneRepository;
import lk.sritel.sricare.ringtonepersonalizationservice.request.RingtonePersonalizationRequest;
import lk.sritel.sricare.ringtonepersonalizationservice.response.RingtonePersonalizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RingtonePersonalizationService {

    @Autowired
    private RingtoneRepository ringtoneRepository;

    public RingtonePersonalizationResponse setRingtone(String userId, RingtonePersonalizationRequest request) {

        try {

            Ringtone existingRingtone = ringtoneRepository.findByUserId(userId);

            if (existingRingtone != null) {
                // Update the existing custom ringtone with the new information
                existingRingtone.setSongName(request.getSongName());
                existingRingtone.setArtist(request.getArtist());

                ringtoneRepository.save(existingRingtone);

                return new RingtonePersonalizationResponse("Ringtone updated successfully", HttpStatus.OK, existingRingtone);
            } else {
                // Create a new custom ringtone
                Ringtone newRingtone = new Ringtone();
                newRingtone.setUserId(userId);
                newRingtone.setSongName(request.getSongName());
                newRingtone.setArtist(request.getArtist());
                newRingtone.setActivatedDate(new Date());

                ringtoneRepository.save(newRingtone);

                return new RingtonePersonalizationResponse("Ringtone set successfully", HttpStatus.OK, newRingtone);
            }
        } catch (Exception e) {
            return new RingtonePersonalizationResponse("Failed to set/update ringtone: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    public RingtonePersonalizationResponse getRingtone(String userId) {

        try {

            Ringtone ringtone = ringtoneRepository.findByUserId(userId);

            if (ringtone != null) {
                return new RingtonePersonalizationResponse("Ringtone retrieved successfully", HttpStatus.OK, ringtone);
            } else {
                return new RingtonePersonalizationResponse("Ringtone not found for the user", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return new RingtonePersonalizationResponse("Failed to retrieve ringtone", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
