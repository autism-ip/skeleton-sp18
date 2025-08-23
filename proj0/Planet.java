import java.util.Iterator;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p) {
        double x_distance_pow = (xxPos - p.xxPos) * (xxPos - p.xxPos);
        double y_distance_pow = (yyPos - p.yyPos) * (yyPos - p.yyPos);
        return Math.sqrt(x_distance_pow + y_distance_pow);
    }
    public double calcForceExertedBy(Planet p) {
        double G = 6.67 * Math.pow(10, -11);
        return (G * mass * p.mass) / (calcDistance(p) * calcDistance(p));
    }
    public double calcForceExertedByX(Planet p) {
        return  calcForceExertedBy(p) * (xxPos - p.xxPos) / calcDistance(p);
    }
    public double calcForceExertedByY(Planet p) {
        return  calcForceExertedBy(p) * (yyPos - p.yyPos) / calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] planets) {
        double totalForce = 0.0;
        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            totalForce += this.calcForceExertedByX(planet);
        }
        return totalForce;
    }
    public double calcNetForceExertedByY(Planet[] planets) {
        double totalForce = 0.0;
        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            totalForce += this.calcForceExertedByY(planet);
        }
        return totalForce;
    }
    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + dt * aX;
        yyVel = yyVel + dt * aY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
