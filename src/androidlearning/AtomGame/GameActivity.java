package androidlearning.AtomGame;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Olga on 25.07.2014.
 */
public class GameActivity extends Activity {

    public void onCreateGame(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        int xRay = 0;
        int yRay = 0;

        ArrayList<Point> gamePointMap = setPointOnField();

        rayReflection(gamePointMap, xRay, yRay);
    }

    private int x;
    private int y;

    public ArrayList<Point> setPointOnField() {
        Random r = new Random();
        ArrayList<Point> mapPoint = new ArrayList<Point>();
        while (!(mapPoint.size() == 10)) {
            x = (r.nextInt()*9 + 1);
            y = (r.nextInt()*9 + 1);
            if (!(mapPoint.contains(new Point(x, y)))) {
                mapPoint.add(new Point(x, y));
            }
        }

        return mapPoint;
    }

    protected void onDraw(Canvas canvas) {
        int interval = canvas.getWidth()/12;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        int xStart = 0;
        int yStart = 0;
        int xFinish = 0;
        int yFinish = canvas.getHeight();
        paint.setColor(Color.BLACK);

        for (int i = 0; i < 10; i++) {
            canvas.drawLine(xStart, yStart, xFinish, yFinish, paint);
            xStart += interval;
            xFinish += interval;
        }

        for (int i = 0; i < 10; i++) {
            canvas.drawLine(xStart, yStart, xFinish, yFinish, paint);
            yStart += interval;
            yFinish += interval;
        }
    }

    public void rayReflection(ArrayList<Point> mapPoint, int startXRay, int startYRay) {

        int finishXRay;
        int finishYRay;

        while (true) {
            if (mapPoint.get(Point.x).equals(0)) {
                startYRay = Point.y;
                if (mapPoint.contains(Point.startYRay)) {
                    finishYRay = y - 1;
                    finishXRay = ;
                    rayReflection(mapPoint, finishXRay, finishYRay);
                } else {
                    finishYRay = startYRay;
                    break;
                }
            } else (mapPoint.get(Point.y).equals(0)) {
                startXRay = Point.x;
                if (mapPoint.contains(Point.startXRay)) {
                    finishXRay = x - 1;
                    rayReflection(field, mapPoint, finishXRay, finishYRay);
                } else {
                    finishXRay = startXRay;
                    break;
                }
            }
        }
    }
}