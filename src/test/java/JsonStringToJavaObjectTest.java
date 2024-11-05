import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import player.Player;
import player.PlayerWithEndorsements;


@RunWith(MockitoJUnitRunner.class)
public class JsonStringToJavaObjectTest {

  private static String PLAYER_STRINGIFY = "";

  @Before
  public void setUp()
      throws IOException {
    PLAYER_STRINGIFY = FileUtils.readFileToString(new File("src/test/resources/exampleJson.json")
        , StandardCharsets.UTF_8);

  }
  @Test
  public void testScenario1()
      throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    Player player = mapper.readValue(PLAYER_STRINGIFY,
        Player.class);
    System.out.println("this is PLayer:" + player);
    Assert.assertTrue("Player is grand slam winner",
        player.isGrandSlamWinner());
    BigInteger bigInt = new BigInteger("23111111");
    Assert.assertEquals("Player has played this many minutes",
        bigInt, player.getNumberOfSecondsPlayed());

  }

  @Test
  public void testScenario2()
      throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    PlayerWithEndorsements playerWithEndorsements
        = mapper.readValue(PLAYER_STRINGIFY,
        PlayerWithEndorsements.class);
    System.out.println("this is PlayerWithEndorsements: " + playerWithEndorsements);
    Assert.assertEquals("Player has this many endorsements",
        2, playerWithEndorsements.getEndorsements().size());
  }
}
