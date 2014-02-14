/*
 * Hill Climber Lab01 HCI312A Spring 2014
 */
package hillclimber2;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alberto Beltran
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
        boolean local = false; // to stop loop
        double xOfRandomVector = 0;
        double yOfRandomVector = 0;
        double zOfRandomVector = 0;
        double xOfNeighboringRandomVector = 0;
        double yOfNeighboringRandomVector = 0;
        double zOfNeighboringRandomVector = 0;

        double fvcNew = 0; // neighboring function value of v_c
        double fvc = 0; //function of vc
        double DESIRED_FUNCTION_VALUE = 0;
        double[] v_cN = new double[N];


        Scanner keyboard = new Scanner(System.in);
        // Input from user as to amount of time to run
        System.out.println("Input the times to run.");
        MAX = keyboard.nextInt();

        //Taking input from user for the desired function value, ideal would be 0
        //However a number closest to 0 is better, such as 0.001
        System.out.println("Select a desired Function Value ");
        DESIRED_FUNCTION_VALUE = keyboard.nextDouble();

        //test to check DESIRED_FUNCTION_VALUE
        System.out.println("Desired Function value is: " + DESIRED_FUNCTION_VALUE);

        System.out.println("How many vectors to create? ");
        N = keyboard.nextInt();

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
            System.out.println();

            // vc of the vector put into an array called v_c
            double[] v_c = new double[3];
            for ( int a = 0; a <= v_c.length; a++ )
            {
                v_c[0] = xOfRandomVector;
                v_c[1] = yOfRandomVector;
                v_c[2] = zOfRandomVector;
            }
            //check that the array is being filled
            System.out.println(Arrays.toString(v_c));

            //the function (x^2)+(y^2)+(z^2)
            fvc = ( ( xOfRandomVector ) * ( xOfRandomVector ) ) +
              ( ( yOfRandomVector ) * ( yOfRandomVector ) ) + ( ( zOfRandomVector ) *
              ( zOfRandomVector ) );
            //make into method later
            //loop over N
            for ( int b = 0; b < N; b++ )
            {
                double dx = Math.random() * ( 1 - ( -2 ) );
                if ( Math.random() < 0.5 )
                {
                    dx = -dx;
                }
                xOfNeighboringRandomVector = v_c[0] + dx;

                double dy = Math.random() * ( 1 - ( -2 ) );
                if ( Math.random() < 0.5 )
                {
                    dy = -dy;
                }
                yOfNeighboringRandomVector = v_c[1] + dy;

                double dz = Math.random() * ( 1 - ( -2 ) );
                if ( Math.random() < 0.5 )
                {
                    dz = -dz;
                }
                zOfNeighboringRandomVector = v_c[2] + dz;

                fvcNew = ( xOfNeighboringRandomVector ) * ( xOfNeighboringRandomVector ) +
                  ( yOfNeighboringRandomVector ) * ( yOfNeighboringRandomVector ) +
                  ( zOfNeighboringRandomVector ) * ( zOfNeighboringRandomVector );

                if ( fvcNew <= fvc )
                {
                    v_c[0] = xOfNeighboringRandomVector;
                    v_c[1] = yOfNeighboringRandomVector;
                    v_c[2] = zOfNeighboringRandomVector;
                    fvc = fvcNew;

                }
                System.out.println("The neighboring random x is " + xOfNeighboringRandomVector);
                System.out.println("The neighboring random y is " + yOfNeighboringRandomVector);
                System.out.println("The neighboring random z is " + zOfNeighboringRandomVector);
                System.out.println("The neighboring function value is " + fvcNew);
                System.out.println("The new neighboring min function value is " + fvc);

                System.out.println();

            } // careful to close the loop
            System.out.println("The min neighboring function value is " + fvcNew);

            // at this point, v_c is the best of the pre-existing v_c



            t++;

            System.out.format("#%d Vector Function Value = %.2f%n%n", t, fvc);
            System.out.println("vNew is: " + vNew);
            System.out.println("Desired Function Value is: " + DESIRED_FUNCTION_VALUE);
            System.out.println("The New Min Function Value is: " + fvcNew);

            System.out.println("t is: " + t);
            System.out.println();





            // evaluate f(v_1), f(f_2), . . . , f(v_n);
            // select the vector with the smallest value of f();
            // call it vNew;
            // if f(vNew)< f(v_c)
            // then begin
            // v_c = vNew;

            //local = false;
            //vNew = min;
        }
    }
}
