package dev.ben10dollar.golfgame.physics;

import dev.ben10dollar.golfgame.tiles.Tile;

import java.awt.event.MouseEvent;

public class Physics {

    //one tile = 1 meter

    public static final double GRAVITY = 9.8;
    public static final double COEFFICIENT_OF_KINETIC_FRICTION_BASELINE = 5;
    public static final double ACCELERATION_X_PER_TILE_FROM_BALL = 1 * Tile.TILE_WIDTH;
    public static final double ACCELERATION_Y_PER_TILE_FROM_BALL = 1 * Tile.TILE_HEIGHT;

    public static double[] kineticFriction(double deltaX, double deltaY, double coefficientOfKineticFriction, double mass) {
        double kineticFriction =  coefficientOfKineticFriction * mass * GRAVITY;
        double angle = angle(deltaX, deltaY, deltaX < 0);

        return componentForces(-1.0, kineticFriction, angle);
    }

    public static double angle(double deltaX, double deltaY, boolean directionLeft) {
        double angle = Math.atan(deltaY / deltaX);

        //Q3 and Q2
        if(directionLeft) angle += Math.PI;

        return angle;
    }

    public static double[] componentForces(double constant, double force, double angle) {
        double[] componentForces = new double[2];
        componentForces[0] = constant * force * Math.cos(angle); //x direction
        componentForces[1] = constant * force * Math.sin(angle); //y direction

        return componentForces;
    }

    public static double[] appliedForce(double ballX, double ballY, double mouseX, double mouseY) {
        double dx = mouseX - ballX;
        double dy = mouseY - ballY;
        double dDistance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        double appliedForce = 20 * dDistance;
        double angle = angle(dx, dy, dx < 0);

        return componentForces(1.0, appliedForce, angle);
    }

}
