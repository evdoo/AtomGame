package androidlearning.AtomGame;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

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

    public boolean onTouch(View v, MotionEvent event) {
        double x = event.getX();
        double y = event.getY();
        return true;
    }

    public ArrayList<Point> setPointOnField() {
        int x;
        int y;

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
        int interval = canvas.getWidth()/13;
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

        //другие начальные координаты для этих линий?

        for (int i = 0; i < 10; i++) {
            canvas.drawLine(xStart, yStart, xFinish, yFinish, paint);
            yStart += interval;
            yFinish += interval;
        }
    }

    public void rayReflection(ArrayList<Point> mapPoint, int startXRay, int startYRay) {

        int finishXRay;
        int finishYRay;
        int xMax = 10;
        int yMax = 10;
        boolean rayStatus;

        for (Point p : mapPoint) {
            if (p.x == startXRay) {
                rayStatus = false; //поглощен
                break;
            }
            if (p.x == startXRay + 1) {
                finishXRay = p.x - 1;
                finishYRay = startYRay;
                rayReflection(mapPoint, finishXRay, finishYRay);
            } else if (p.x == startXRay - 1) {
                finishXRay = p.x - 1;
                finishYRay = startYRay;
                rayReflection(mapPoint, finishXRay, finishYRay);
            } else {
                finishXRay = startXRay;
                finishYRay = yMax;
                rayStatus = true; //прошел
                break;
            }
        }

        for (Point p : mapPoint) {
            if (p.y == startYRay) {
                rayStatus = false; //поглощен
                break;
            }
            if (p.y == startYRay + 1) {
                finishXRay = startXRay;
                finishYRay = p.y - 1;
                rayReflection(mapPoint, finishXRay, finishYRay);
            } else if (p.y == startYRay - 1) {
                finishXRay = startXRay;
                finishYRay = p.y - 1;
                rayReflection(mapPoint, finishXRay, finishYRay);
            } else {
                finishXRay = xMax;
                finishYRay = startYRay;
                rayStatus = true; //прошел
                break;
            }
            if (rayStatus == true) {
                int xMark = (int) (canvas.getHeight() / 13 * p.y) + 1;

            }
        }
    }
}