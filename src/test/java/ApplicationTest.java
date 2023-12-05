import com.carbon.it.converter.DataToFileConverter;
import com.carbon.it.converter.FileToDataConverter;
import com.carbon.it.enums.Direction;
import com.carbon.it.model.Adventurer;
import com.carbon.it.model.Cell;
import com.carbon.it.model.Mountain;
import com.carbon.it.model.Treasure;
import com.carbon.it.service.AdventurerService;
import com.carbon.it.service.MapService;
import com.carbon.it.service.ResultService;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.logging.Logger;

public class ApplicationTest {

    public static Logger logger = Logger.getLogger(ApplicationTest.class.getName());

    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        logger.info("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName("Single test successful")
    @Test
    public void testSizeMap() {

        Cell[][] cell = FileToDataConverter.toMap(TestData.list);
        logger.info("" + cell.length);
        logger.info("" + cell[0].length);
        Assertions.assertTrue(cell.length == 3 && cell[0].length == 5);
    }

    @Test
    public void testTreasure() {
        List<Treasure> treasures = FileToDataConverter.getTreasures(TestData.list);
        Assertions.assertTrue(treasures.size() == 0);
    }

    @Test
    public void testTreasure2() {
        List<Treasure> treasures= FileToDataConverter.getTreasures(TestData.list2);
        Assertions.assertTrue(treasures.size() > 0);
    }

    @Test
    public void testTreasure3() {
        List<Treasure> treasures= FileToDataConverter.getTreasures(TestData.list2);
        Assertions.assertTrue(treasures.size() == 1);
    }

    @Test
    public void testMountain() {
        List<Mountain> mountains= FileToDataConverter.getMountains(TestData.list);
        Assertions.assertTrue(mountains.size() > 0);
    }

    @Test
    public void testMountain1() {
        List<Mountain> mountains = FileToDataConverter.getMountains(TestData.list3);
        Assertions.assertTrue(mountains.isEmpty());
    }

    @Test
    public void testAdventurer() {
        List<Adventurer> adventurers = FileToDataConverter.getAdventurers(TestData.list3);
        logger.info(adventurers.toString());
        Assertions.assertTrue(adventurers.size() > 0);
    }

    @Test
    public void testAdventure1() {
        List<Adventurer> adventurers = FileToDataConverter.getAdventurers(TestData.list3);
        logger.info(adventurers.toString());
        Assertions.assertTrue(adventurers.get(0).getDirection() == Direction.SOUTH);
    }

    @Test
    public void testSetupMountains() {

        Cell[][] cells = MapService
                .placeMountainsOnMap(MapService.placePlainsOnMap(
                        FileToDataConverter.toMap(TestData.list4)),
                        FileToDataConverter.getMountains(TestData.list4));

        MapService.displayMap(cells);
        Assertions.assertTrue(cells[3][4].isMountain == true);
    }

    @Test
    public void testSetupTreasure() {

        Cell[][] cells = MapService
                .placeTreasuresOnMap(MapService.placePlainsOnMap(
                                FileToDataConverter.toMap(TestData.list4)),
                        FileToDataConverter.getTreasures(TestData.list4));

        MapService.displayMap(cells);
        Assertions.assertTrue(cells[4][4].isTreasure() == true);
    }

    @Test
    public void testSetupAdventurer() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService.placePlainsOnMap(FileToDataConverter.toMap(TestData.list4)),
                        FileToDataConverter.getAdventurers(TestData.list4));

        MapService.displayMap(cells);
        Assertions.assertTrue(cells[3][5].isAdventurer() == true);
    }

    @Test
    public void testSetupAdventurer1() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService.placePlainsOnMap(FileToDataConverter.toMap(TestData.list4)),
                        FileToDataConverter.getAdventurers(TestData.list4));

        Assertions.assertTrue(cells[3][5].getAdventurer().getDirection() == Direction.SOUTH);
    }

    @Test
    public void testAdventurerFaceRight() {

        List<Adventurer> adventurers = FileToDataConverter.getAdventurers(TestData.list3);
        Adventurer adventurer = adventurers.get(0);
        AdventurerService.faceRight(adventurer);

        Assertions.assertTrue(adventurer.getDirection() == Direction.WEST);
    }

    @Test
    public void testAdventurerMove() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService.placePlainsOnMap(FileToDataConverter.toMap(TestData.list5)),
                        FileToDataConverter.getAdventurers(TestData.list5));

        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list5));

        Assertions.assertTrue(cells[3][7].getAdventurer() != null);
    }

    @Test
    public void testAdventurerName() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService.placePlainsOnMap(FileToDataConverter.toMap(TestData.list5)),
                        FileToDataConverter.getAdventurers(TestData.list5));

        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list5));

        Assertions.assertTrue(cells[3][7].getAdventurer().getName().equals("Jon Jones"));
    }

    @Test
    public void testAdventurerOutOfMap() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService.placePlainsOnMap(FileToDataConverter.toMap(TestData.list6)),
                        FileToDataConverter.getAdventurers(TestData.list6));

        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list6));

        Assertions.assertTrue(cells[3][19].getAdventurer().getName().equals("Jon Jones"));
    }

    @Test
    public void testAdventurerInMap() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService.placePlainsOnMap(FileToDataConverter.toMap(TestData.list6)),
                        FileToDataConverter.getAdventurers(TestData.list6));

        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list6));

        Assertions.assertTrue(cells[3][7].getAdventurer().getName().equals("Jonah Hill"));
    }

    @Test
    public void testAdventurerInMap1() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService
                        .placeMountainsOnMap(MapService.placePlainsOnMap(
                                        FileToDataConverter.toMap(TestData.list7)),
                                FileToDataConverter.getMountains(TestData.list7)),
                        FileToDataConverter.getAdventurers(TestData.list7));

        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list7));

        Assertions.assertTrue(cells[0][0].getAdventurer().getName().equals("Jon Jones"));
    }

    @Test
    public void testAdventurerGetTreasure() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService
                                .placeTreasuresOnMap(MapService.placePlainsOnMap(
                                                FileToDataConverter.toMap(TestData.list8)),
                                        FileToDataConverter.getTreasures(TestData.list8)),
                        FileToDataConverter.getAdventurers(TestData.list8));

        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list8));

        Assertions.assertTrue(cells[0][2].getAdventurer().getTreasures() == 1);
    }

    @Test
    public void testintegrated() {

        Cell[][] cells = ResultService.placeAndMoveItemsOnMap(TestData.list4);
        List<String> list = ResultService.getResults(cells);
        Assertions.assertTrue(cells[0][1].getTreasures() == 0);
    }

    @Test
    public void testAdventurerGetTreasure1() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService
                                .placeTreasuresOnMap(MapService.placePlainsOnMap(
                                                FileToDataConverter.toMap(TestData.list9)),
                                        FileToDataConverter.getTreasures(TestData.list9)),
                        FileToDataConverter.getAdventurers(TestData.list9));

        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list9));

        Assertions.assertTrue(cells[4][4].getTreasures() == 9);
    }

    @Test
    public void testDataToFile() {

        Cell[][] cells = MapService
                .placeAdventurersOnMap(MapService
                                .placeTreasuresOnMap(MapService.placePlainsOnMap(
                                                FileToDataConverter.toMap(TestData.list9)),
                                        FileToDataConverter.getTreasures(TestData.list9)),
                        FileToDataConverter.getAdventurers(TestData.list9));
        cells = MapService.moveAdventurers(cells, FileToDataConverter.getAdventurers(TestData.list9));

        List<String> list = ResultService.getResults(cells);
        Assertions.assertTrue(list.get(0).startsWith("C"));
        Assertions.assertTrue(list.get(3).startsWith("T"));
        Assertions.assertTrue(list.get(3).contains(String.valueOf(9)));
    }
}
