package player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import deserializer.PlayerWithEndorsementsDeserializer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@JsonDeserialize(using = PlayerWithEndorsementsDeserializer.class)
public class PlayerWithEndorsements {

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

  @JsonProperty("endorsements")
  List<String> endorsements;

  @Override
  public String toString() {
    return "player.PlayerWithEndorsements{" + "name='" + name + '\'' + ", weight=" + weight + ", titles=" + titles + ", isGrandSlamWinner="
        + isGrandSlamWinner + ", highestRanking=" + highestRanking + ", numberOfSecondsPlayed=" + numberOfSecondsPlayed
        + ", endorsements=" + endorsements+'}';
  }

  public PlayerWithEndorsements() {
    //For Jackson Deserializer
  }

  public PlayerWithEndorsements(String name, BigDecimal weight, List<String> titles, boolean isGrandSlamWinner,
      int highestRanking, BigInteger numberOfSecondsPlayed, List<String> endorsements) {
    this.name = name;
    this.weight = weight;
    this.titles = titles;
    this.isGrandSlamWinner = isGrandSlamWinner;
    this.highestRanking = highestRanking;
    this.numberOfSecondsPlayed = numberOfSecondsPlayed;
    this.endorsements = endorsements;
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

  public List<String> getEndorsements() {
    return endorsements;
  }

  public void setEndorsements(List<String> endorsements) {
    this.endorsements = endorsements;
  }
}

