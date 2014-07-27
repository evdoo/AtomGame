package androidlearning.AtomGame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

/**
 * Created by Olga on 25.07.2014.
 */
public class GameActivity extends Activity {

    public void onCreateGame(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        GridView gameField = (GridView) findViewById(R.id.gameField);
        int xRay = 0;
        int yRay = 0;

        HashMap<Integer, Integer> gamePointMap = setPointOnField();

        rayReflection(gameField, gamePointMap, xRay, yRay);
    }

    private int x;
    private int y;

    public HashMap<Integer, Integer> setPointOnField() {
        Random r = new Random();
        HashMap<Integer, Integer> mapPoint = new HashMap<Integer, Integer>();
        while (!(mapPoint.size() == 10)) {
            x = (r.nextInt()*99 + 1);
            y = (r.nextInt()*99 + 1);
            if (!(mapPoint.containsKey(x) && mapPoint.containsValue(y))) {
                mapPoint.put(x, y);
            }
        }

        return mapPoint;
    }

    public void rayReflection(GridView field, HashMap<Integer, Integer> mapPoint, int xRay, int yRay) {
        for (Map.Entry<Integer, Integer> pair : mapPoint.entrySet()) {
            int x = pair.getKey();
            int y = pair.getValue();
            if ((mapPoint.containsKey(xRay)) || (mapPoint.containsValue(yRay))) {

            }
            else {
                if ((x == xRay - 1) || (x == xRay + 1)) {
                    yRay = y - 1;
                }
                else if ((y == yRay - 1) || (y == yRay + 1)) {
                }
            }
        }
    }
}