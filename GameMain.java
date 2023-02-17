package ru.gb.lesson1.game;

public class GameMain {

  public static void main(String[] args) {
    // Карта с роботами.
    // Карта имеет nxm, где n и m - положительные целые числа.
    // Должна быть возможность создания робота на какой-то точке на карте.
    // Точка на карте описывается двумя целочисленными координатами.
    // Роботы могут перемещаться по карте вперед.
    // В одной точке не может находиться несколько роботов.

    // HOMEWORK
    // 0. Разобраться с проектом. Подготовить вопросы к следующему семинару, если
    // возникнут.
    // 1. Добавить валидацию параметров при создании карты
    // 2. Реализовать возможность задать ограничение по количеству создаваемых
    // на карте роботов (в конструкторе карты)
    // При этом если параметр не указан, то используем значение по-умолчанию: 5
    // 3*. Реализовать возможность вызова метода move с параметром - количество
    // шагов вперед
    // Подсказка: можно несколько раз вызвать метод #move

    /*
     * * * * *
     * * * * *
     * * * * *
     * * * * *
     * * * * *
     */

    RobotMap map = new RobotMap(5, 5);

    RobotMap.Robot robot = map.createRobot(new Point(5, 5));
    RobotMap.Robot robot1 = map.createRobot(new Point(1, 2));
    RobotMap.Robot robot2 = map.createRobot(new Point(3, 3));
    RobotMap.Robot robot3 = map.createRobot(new Point(4, 5));
    RobotMap.Robot robot4 = map.createRobot(new Point(2, 1));
    RobotMap.Robot robot5 = map.createRobot(new Point(3, 1));
    RobotMap.Robot robot6 = map.createRobot(new Point(3, 4));
    RobotMap.Robot robot7 = map.createRobot(new Point(1, 5));
    System.out.println(robot); // [2, 3], [TOP]
    robot.move();
    robot.move();
    robot.move();
    robot.move();
    robot.move();
    System.out.println(robot); // [1, 3], [TOP]
    robot.changeDirection(Direction.BOTTOM);
    robot.move();
    // robot.move(5);
    robot.move(); // [3, 3], [BOTTOM]
    robot.changeDirection(Direction.LEFT);
    robot.move();
    System.out.println(robot); // [3, 2], [LEFT]

    System.out.println(map.robots.size());
  }
}
