package pl.awsome.workshops.service.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacebookData {

    @JsonProperty("full_picture")
    private String fullPicture;
    private String message;
    private String id;
}
