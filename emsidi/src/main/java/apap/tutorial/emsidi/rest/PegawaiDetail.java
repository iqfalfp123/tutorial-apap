package apap.tutorial.emsidi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PegawaiDetail {
    private String status;

    @JsonProperty("pegawai-license")
    private Integer pegawaiLicense;

    @JsonProperty("valid-until")
    private Date validUntil;

}
