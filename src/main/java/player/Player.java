package player;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonDeserialize
public class Player {

  @JsonProperty("name")
  String name;
  @JsonProperty("weight")
  BigDecimal weight;

  @JsonProperty("titles")
  List<String> titles = new ArrayList<>();
  @JsonProperty("grand_slam_winner")
  boolean isGrandSlamWinner = false;
  @JsonProperty("highest_ranking")
  int highestRanking;

  @JsonProperty("number_of_seconds_played")
  BigInteger numberOfSecondsPlayed;

  @JsonProperty("other")
  Map<String,Object> others = new HashMap<>();

  @Override
  public String toString() {
    return "player.Player{" + "name='" + name + '\'' + ", weight=" + weight + ", titles=" + titles + ", isGrandSlamWinner="
        + isGrandSlamWinner + ", highestRanking=" + highestRanking + ", numberOfSecondsPlayed=" + numberOfSecondsPlayed
        + ", others=" + others + '}';
  }

  public Player() {
    //For Jackson Deserializer
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public BigDecimal getWeight() {
    return weight;
  }

  public BigInteger getNumberOfSecondsPlayed() {
    return numberOfSecondsPlayed;
  }

  public void setNumberOfSecondsPlayed(BigInteger numberOfSecondsPlayed) {
    this.numberOfSecondsPlayed = numberOfSecondsPlayed;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getTitles() {
    return titles;
  }

  public void setTitles(List<String> titles) {
    this.titles = titles;
  }

  public boolean isGrandSlamWinner() {
    return isGrandSlamWinner;
  }

  public void setGrandSlamWinner(boolean grandSlamWinner) {
    isGrandSlamWinner = grandSlamWinner;
  }

  public int getHighestRanking() {
    return highestRanking;
  }

  public void setHighestRanking(int highestRanking) {
    this.highestRanking = highestRanking;
  }

  @JsonAnySetter
  void setDetail(String key, Object value) {
    others.put(key, value);
  }

  @JsonAnyGetter
  Object getDetail(String key) {
    return others.get(key);
  }

}
