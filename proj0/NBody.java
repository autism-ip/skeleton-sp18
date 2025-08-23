public class NBody {
    private static int N;
    private static double R;
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        N = in.readInt();
        R = in.readDouble();
        return R;
    }
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[N];
        for(int i = 0; i < N; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }
    private static String imageToDraw = "images/starfield.jpg";
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String fileName = args[2];
        Planet[] planets = readPlanets(fileName);
        R = readRadius(fileName);
        StdDraw.setScale(-R,R);
        StdDraw.clear();
        double time = 0;
        while(time <= T) {
            StdDraw.clear();
            double[] xForeces = new double[N];
            double[] yForeces = new double[N];
            for(int i = 0; i < N; i++) {
                xForeces[i] = planets[i].calcNetForceExertedByX(planets);
                yForeces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < N; i++) {
                planets[i].update(dt, xForeces[i], yForeces[i]);
            }
            StdDraw.picture(0, 0, imageToDraw);
            for (int i = 0;i < N; i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}
