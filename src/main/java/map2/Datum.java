package map2;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datum {

	public int id;
    public String flightName;
    @JsonProperty("Country") 
    public String country;
    @JsonProperty("Destinations") 
    public String destinations;
    @JsonProperty("URL") 
    public String uRL;
	
}
