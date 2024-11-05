package deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import player.PlayerWithEndorsements;


public class PlayerWithEndorsementsDeserializer extends StdDeserializer<PlayerWithEndorsements> {

  public PlayerWithEndorsementsDeserializer() {
    this(null);
  }

  public PlayerWithEndorsementsDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public PlayerWithEndorsements deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    String name = (node.get("name")).textValue();
    BigDecimal weight = node.get("weight").decimalValue();
    List<String> titles = new ArrayList<>();
    JsonNode titlesNode = node.get("titles");
    for(JsonNode temp : titlesNode) {
      titles.add(temp.textValue());
    }
    boolean isGrandSlamWinner = (node.get("grand_slam_winner")).booleanValue();
    int highestRanking = (node.get("highest_ranking")).intValue();
    BigInteger numberOfSecondsPlayed = (node.get("number_of_seconds_played")).bigIntegerValue();
    List<String> endorsements = new ArrayList<>();
    JsonNode endorsementsJsonNode = node.get("endorsements");
    for(JsonNode temp : endorsementsJsonNode) {
      endorsements.add("Endorsed " + (temp.get("category")).textValue() + " for "
          + (temp.get("number_of_years")).intValue() + "years");
    }
    return new PlayerWithEndorsements(name, weight, titles, isGrandSlamWinner, highestRanking,
        numberOfSecondsPlayed, endorsements);
  }
}