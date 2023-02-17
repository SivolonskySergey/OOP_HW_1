package ru.gb.lesson1.game;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {

    private final int n;
    private final int m;

    public final List<Robot> robots;
    private int max_robots;

    public RobotMap(int n, int m) {
        validateMapSize(n, m);
        this.n = n;
        this.m = m;
        this.max_robots = 5;
        this.robots = new ArrayList<>();
    }

    public Robot createRobot(Point point) {
        robotLimit();
        validatePoint(point);
        Robot robot = new Robot(point);
        robots.add(robot);

        return robot;
    }

    private void robotLimit() {
        if ((this.robots.size() + 1) > this.max_robots) {
            throw new IllegalStateException("Лимит количества роботов " + max_robots + " шт!");
        }
    }

    private void validateMapSize(int size_n, int size_m) {
        if (size_n <= 0 || size_m <= 0) {
            throw new IllegalStateException("Некоректное значение размеров поля, размер должен быть больше 0!");
        }
    }

    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    private void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }

    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.point;
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    public class Robot {

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.direction = DEFAULT_DIRECTION;
            this.point = point;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move(int steps) {
            Point newPoint = switch (direction) {
                case TOP -> new Point(point.x() - steps, point.y());
                case RIGHT -> new Point(point.x(), point.y() + steps);
                case BOTTOM -> new Point(point.x() + steps, point.y());
                case LEFT -> new Point(point.x(), point.y() - steps);
            };
            validatePoint(newPoint);

            System.out.println("Робот переместился с " + point + " на " + newPoint);
            this.point = newPoint;
        }

        @Override
        public String toString() {
            return point.toString() + ", [" + direction.name() + "]";
        }
    }

}
