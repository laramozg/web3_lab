package model;

import beans.Point;
import exceptions.InvalidParameterException;
import java.time.LocalDateTime;

import static java.lang.Math.pow;

public class PointHandler {

    public Hit getHitInfo(Point point) {
        long startExecution = System.nanoTime();
        validatePoint(point);
        return Hit.builder()
                .xval(point.getXVal())
                .yval(point.getYVal())
                .rval(point.getRVal())
                .currenttime(LocalDateTime.now())
                .ishit(isHit(point))
                .executiontime(System.nanoTime() - startExecution)
                .build();
    }

    private void validatePoint(Point point) {
        byte MAX_Y = 5;
        byte MIN_Y = -3;

        if (!(point.getYVal() > MIN_Y && point.getYVal() < MAX_Y)) {
            throw new InvalidParameterException("Значение Y не попадает в нужный интервал!");
        }

        if (point.getRVal() <= 0) {
            throw new InvalidParameterException("Значение R не может быть неположительным!");
        }
    }

    private boolean isHit(Point point) {
        return isRectangleHit(point) || isCircleHit(point) || isTriangleHit(point);
    }

    private boolean isRectangleHit(Point point) {
        return point.getXVal() >= 0 && point.getXVal() <= point.getRVal()
                && point.getYVal() <= 0 && point.getYVal() >= -point.getRVal();
    }

    private boolean isCircleHit(Point point) {
        return point.getXVal() >= 0 && point.getYVal() >= 0
                && (pow(point.getXVal() /2, 2) + pow(point.getYVal() /2 , 2)) <= pow(point.getRVal() / 4, 2);
    }

    private boolean isTriangleHit(Point point) {
        return point.getXVal() <= 0 && point.getYVal() <= 0
                && point.getXVal() <= point.getRVal() && point.getYVal()>= -point.getRVal() /2 ;
    }

}
