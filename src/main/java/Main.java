import com.carbon.it.model.Cell;
import com.carbon.it.service.FileInOutStreamService;
import com.carbon.it.service.MapService;
import com.carbon.it.service.ResultService;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<String> list = FileInOutStreamService.readDataFromFile("files/input.txt");
        Cell[][] cells = ResultService.placeAndMoveItemsOnMap(list);
        List<String> results = ResultService.getResults(cells);
        FileInOutStreamService.writeOutputFile(results, "output.txt");
    }
}
