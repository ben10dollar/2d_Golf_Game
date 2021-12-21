package dev.ben10dollar.golfgame.physics;

public class Physics {

    public static final double GRAVITY = 9.8;

    public static double[] kineticFriction(double deltaX, double deltaY, double coefficientKineticFriction, double mass) {
        double kineticFriction =  coefficientKineticFriction * mass * GRAVITY;
        double angle = angle(deltaX, deltaY, deltaX > 0);

        double[] componentForces = new double[2];
        componentForces[0] = kineticFriction * Math.cos(angle);
        componentForces[1] = kineticFriction * Math.sin(angle);

        return componentForces;
    }

    public static double angle(double deltaX, double deltaY, boolean directionRight) {
        double angle = Math.atan(deltaY / deltaX);

        //Q3 and Q2
        if(!directionRight)
            angle += Math.PI;

        //System.out.println("Angle: " + angle * 360 / (2*Math.PI));
        return angle;
    }

}
