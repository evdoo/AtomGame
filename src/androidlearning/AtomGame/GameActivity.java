package androidlearning.AtomGame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Olga on 25.07.2014.
 */
public class GameActivity extends Activity {

    public void onCreateGame(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }

    public void setGameField() {
        GridView gameField = (GridView) findViewById(R.id.gameField);
        int x;
        int y;


    }

    public void rayReflection(GridView field) {

    }
}
