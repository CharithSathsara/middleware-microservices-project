package lk.sritel.sricare.ringtonepersonalizationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ringtone")
public class Ringtone {

    @Id
    private String id;
    private String userId;
    private String songName;
    private String artist;
    private Date activatedDate;

}
