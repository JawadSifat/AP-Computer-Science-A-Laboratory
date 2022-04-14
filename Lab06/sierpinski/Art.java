/** ****************************************************************************************************************|                                                                                                                
 *  Name:        Jamie                                                                                                                                                        
 *  DOE Name:    Jawad Sifat                                                                                                                                 
 *                                                                                                                                                                                                
 *  Title:  Custom Art using Transform2D and recursion
 *
 *  Description: Individual custom art file that uses recursive graphics
 * 
 *  Written:       4/13/2022
 *  Last updated:  4/14/2022
 *
 *  Compilation:   javac -classpath .:stdlib.jar Art.java
 *  Execution:     java  -classpath .:stdlib.jar Art {int n}
 * 
 *  Dependencies/Packages Imported: Princeton Standard Libraries (stdlib.jar)
 |******************************************************************************************************************/

public class Art {
    private static double low = -10.0;
    private static double high = 15.0;
    private static double scale = 1; 

    private static int genRandom(){
        return (int) ((Math.random() * (low - 5)) + (high - 5));
    }

    private static int genColorRandom(){
        return (int) ((Math.random() * 253) + 1);
    }

    private static void drawJava(double[] x, double[] y){
        Transform2D.rotate(x, y, ( Math.random() * 90.0 + 5));
        if (genRandom() % 2 == 0) StdDraw.setPenColor(genColorRandom(), genColorRandom(), genColorRandom());
        Transform2D.scale(x, y, scale);
        StdDraw.polygon(x, y);
        Transform2D.translate(x, y, genRandom(), genRandom());
    }

    private static void drawMain(int iterations, double[] x, double[] y){
        double[] hash = {Math.random(), Math.random(), Math.random(), Math.random()};

        if (iterations < 1) {
            StdDraw.text(genRandom(), genRandom(), "Vení, Ví, Vencí");
            drawJava(y, x);
            return;
        }
        if (iterations % 2 == 0) {
            drawJava(x, y);
        }

        if (iterations % 2 == 1){
            drawJava(y, x);
        }

        if (hash[3] >= 0.6 || hash[0] < 0.8) { Transform2D.translate(x, y, -5, -1); }

        //scale = hash[(int) ((Math.random() * 3) + 0)];
        drawMain(iterations - 1, x, y);
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);


        double[] xcoord = {1, 2, 4, 6, 1};
        double[] ycoord = {2, 3, 5, 7, 3};

        StdDraw.setScale(low, high);
        StdOut.printf("A window opened to display the computer generated drawing, the panel has scale (%.1f && %.1f)%n%n%n", low, high);

        StdDraw.polygon(xcoord, ycoord);

        drawMain(n, xcoord, ycoord);

    }
 }