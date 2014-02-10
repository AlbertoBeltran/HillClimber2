/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hillclimber2;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Win7Turbo
 */
public class HillClimber2
{


    /**
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
        int t = 0; // start count
        int N = 0;
        int MAX = 0; // max times given by user
        double vNew = 0; // the new mininum
        double min = 0; // temp min
        //double v_c = 0; // new vector
        boolean local = false; // to stop loop
        double xOfRandomVector = 0;
        double yOfRandomVector = 0;
        double zOfRandomVector = 0;
        double fvc = 0; //function of vc
        double DESIRED_FUNCTION_VALUE = 0;
        double[] v_cN = new double[N*MAX];


        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input the times to run.");
        MAX = keyboard.nextInt();
        System.out.println("Select a desired Function Value between -15 and 10");
        DESIRED_FUNCTION_VALUE = keyboard.nextDouble();
        System.out.println("Desired Function value is: " + DESIRED_FUNCTION_VALUE);

        while ( t != MAX && local == false )
        {

            //random number generator between -10 and 15
            xOfRandomVector = -10 + ( Math.random() * ( ( 15 - ( -10 ) ) ) );
            System.out.println("The random x is " + xOfRandomVector);

            yOfRandomVector = -10 + ( Math.random() * ( ( 15 - ( -10 ) ) ) );
            System.out.println("The random y is " + yOfRandomVector);

            zOfRandomVector = -10 + ( Math.random() * ( ( 15 - ( -10 ) ) ) );
            System.out.println("The random z is " + zOfRandomVector);

            System.out.format("(vc is: %.2f, %.2f, %.2f)%n",
              xOfRandomVector, yOfRandomVector, zOfRandomVector);
            // vc of the vector
            double[] v_c = new double[3];
            for ( int a = 0; a <= v_c.length; a++ )
            {
                v_c[0] = xOfRandomVector;
                v_c[1] = yOfRandomVector;
                v_c[2] = zOfRandomVector;
            }
            System.out.println(Arrays.toString(v_c));



            //the function (x^2)+(y^2)+(z^2)
            fvc = ( ( xOfRandomVector ) * ( xOfRandomVector ) ) +
              ( ( yOfRandomVector ) * ( yOfRandomVector ) ) + ( ( zOfRandomVector ) *
              ( zOfRandomVector ) );

            vNew = fvc;

            t++;
            System.out.format("#%d Vector Value = %.2f%n%n", t, fvc);
            //vNew = fvc;
            System.out.println("vNew is: " + vNew);
            System.out.println("Desired Function Value is: " + DESIRED_FUNCTION_VALUE);
            System.out.println("t is: " + t);
            System.out.println();

            if ( fvc <= DESIRED_FUNCTION_VALUE )
            {
                vNew = fvc;

                local = true;

            }
            else
            {

                min = fvc;
                vNew = min;

                //int N = 0;
                System.out.println ("How many vectors to create? ");
                N = keyboard.nextInt();
                //Algorithm from Professor Uday's sheet
                // select N new vectors (call them v_1 through v_n) in the neighborhood
                // of v_c by small, random perturbations of one or more dimensions

                //while ( < N)//less than N

                for ( int b = 0; b <= v_cN.length; b++ )
                {
                    v_cN[b]=vNew;
                }

                // evaluate f(v_1), f(f_2), . . . , f(v_n);
                // select the vector with the smallest value of f();
                // call it vNew;
                // if f(vNew)< f(v_c)
                // then begin
                // v_c = vNew;

                local = false;

            }

            System.out.println(Arrays.toString(v_cN));


        }
        //vNew = min;
        System.out.println("t is: " + t);
        System.out.format("vc is: (%.2f, %.2f, %.2f)%n",
          xOfRandomVector, yOfRandomVector, zOfRandomVector);

        System.out.println("Minimum is: " + min);
        System.out.println("vNew is: " + vNew);

    }

}
