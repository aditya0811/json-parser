package player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigInteger;

@JsonDeserialize
public class Endorsements {

  @JsonProperty("category")
  String category;

  @JsonProperty("number_of_years")
  BigInteger numberOfYears;
}
