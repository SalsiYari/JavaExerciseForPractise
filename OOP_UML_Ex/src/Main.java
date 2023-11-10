import java.awt.*;
import java.awt.image.BandCombineOp;

public class Main {
    public static void main(String[] args) {
        System.out.println("in this project you can find exercise on \nUML,\nclass,\nintefraces,\nobjects\n");

        /*
        * Write a class named ClickCounter representing a simple device to keep track of how many times a button (in this case a method) is clicked. Internally, the class represents the number of clicks with an int value. The class provides the following methods:

        public int getValue() returning the current number of clicks.
        public void click() increasing the number of clicks of 1 unit.
        public void undo() decreasing the number of clicks of 1 unit (but preventing negative click values).
        public void reset() setting the number of clicks to 0.
        Refer to the UML diagram, JavaDoc documentation, and unit tests for further inspiration.*/

        ClickCounter cl=new ClickCounter();
        cl.click();
        cl.click();
        System.out.println("ClickCounter:\n -> "+cl.getValue());
        cl.undo();
        System.out.println(" -> "+ cl.getValue());
        cl.reset();
        System.out.println(" -> "+ cl.getValue());
        System.out.println("\n- - - - \n");

        /*
        Write a class named RationalNumber representing a rational number. RationalNumbers are immutable objects, indeed they cannot be changed after creation. Internally, the class represents numerator and denominator as int values. RationalNumbers must support equality with other RationalNumbers (see Object.equals(), Object.hashCode()) The class provides the following methods:

        public RationalNumber(int numerator, int denominator) creating the rational number. Before creating the object, numerator and denominator have to be simplified (i.e., divided by their greatest common divisor).
        public getNumerator() returning the numerator.
        public getDenominator() returning the denominator.
        public RationalNumber add(RationalNumber o) returning a RationalNumber object representing the sum of the current number and another number.
        public RationalNumber multiply(RationalNumber o) returning a RationalNumber object representing the multiplication of the current number and another number.
        public String toString().
        You can use the following two methods for computing the least common multiple and the greatest common divisor of two integer numbers. These methods are not part of the public interface of the class.
                 */

        RationalNumber rt=new RationalNumber(4,5);
        RationalNumber rt1=new RationalNumber(5,5);
        System.out.println("Rational number : \n numeratore->"+ rt.getNumerator()+"\ndenominatore->"+rt.getDenominator()+"\ntoString num1="+rt.toString()+"\ntoString num2="+rt1.toString()+"\nsum->"+rt.add(rt1).toString()+"\nmoltiplicazione ->"+ rt.multiply(rt1).toString());
        System.out.println("\n- - - - \n");

        /*
        * [basic.Circle] Write a class named Circle representing a Circle on a 2D plane. Internally, the class uses a Point object and an int value for representing the center and the radius of the Circle, respectively. The class provides the following methods:

        public Circle(Point center, int radius) creating the circle.
        getters and setters.
        public double getPerimeter() returning the perimeter of the circle.
        public double getArea() returning the area of the circle.
        public boolean contains(Point point) returning true if point is contained within the circle.
        public void translate(int dx, int dy) moving the circle on the 2D plane. dx and dy are the x and y components of the translation vector.
        public String toString().
        Refer to the UML diagram, JavaDoc documentation, and unit tests for further inspiration.*/

        Point p= new Point(1,0);
        Point p2 = new Point(5,0);
        Circle c= new Circle(p,10);
        Circle c2=new Circle(p2,40);
        System.out.println("\nCircle: \n to string->"+c.toString()+"\nperimeter->"+ c.getPerimeter()+"\narea->"+ c.getArea()+ "\ncontains?->"+c.contains(p2));
        System.out.println("\nCircle: \n to string->"+c2.toString()+"\nperimeter->"+ c2.getPerimeter()+"\narea->"+ c2.getArea()+ "\ncontains?->"+c2.contains(p));

        /*
        * [basic.Polygon] Write a class named Polygon representing an irregular polygon. Internally, the class uses a Point[] for representing the vertices of the polygon. The class provides the following methods:

        public Polygon(Point[] vertices) creating the polygon.
        public int getVerticesCount() returning the number of vertices.
        public double getPerimeter() returning the perimeter of the polygon.
        public double getArea() returning the area of the polygon.
        public String toString().*/

        Point p3=new Point(5,5);
        Point p4=new Point(1,5);
        Point[] points={p,p2,p3,p4};
        Polygon pol=new Polygon(points);
        System.out.println("\nPolygon:\n num of vertices->"+pol.getVerticesCount()+"\nperimeter"+ pol.getPerimeter()+"\narea->"+ c.getArea());

        /**
         * Write a class named BankAccount representing a bank account. Internally, the class uses a double value for representing the balance of the account. The class provides the following methods:
         *
         * public BankAccount() creating an empty account.
         * public BankAccount(double balance) creating an account with the specified balance.
         * public double getBalance() getting the current balance.
         * public void deposit(double amount) depositing the specific amount into the account.
         * public void withdraw(double amount) withdrawing the specified amount from the account.
         * Refer to the UML di
         */

        BankAccount bk= new BankAccount();
        BankAccount bk1 = new BankAccount(25.65);
        System.out.println("\nBankAccount: \nsaldo iniziale->"+bk1.getBalance());
        bk1.deposit(10.43);
        System.out.println("\nsaldo aggiungiendo 10.43->"+bk1.getBalance());
        bk1.withdraw(10.50);
        System.out.println("Saldo prelevando 10.50->" + bk1.getBalance());

        /*
        * Write a class named EnhancedResizableArray representing a resizable array. It internally keeps an int array, enlarges it when needed, and provides its key functionalities via a set of methods:

            public EnhancedResizableArray() creating an empty resizable array (the underlying int[] has a default capacity of 4 items).
            public int get(int index) returning the element at the specified index.
            public void set(int index, int value) setting the element at the specified index with value. If the underlying int[] capacity is smaller than index, a new int[] (with a capacity of index * 2 items) have to be allocated. All the newly allocated elements have to be set to 0.
            public boolean contains(int value) returning true if the specified value is contained within the internal array.
            public void fill(int) setting all the elements of the internal array to the specified value.
            public int length() returning the capacity of the internal array.
            public int[] toArray() returning a copy of the internal array.
            Refer to the UML diagram, JavaDoc documentation, and unit tests for further inspiration.*/

        EnhancedReisizableArray rs= new EnhancedReisizableArray();
        System.out.println("\nResizableHArray: \n contains val 13?-> " +rs.contains(13)  );
        rs.fill(13);
        System.out.println(" \n contains val 13?-> " +rs.contains(13)  );
        rs.set(12,4);
        System.out.println("now the lenght is ->"+ rs.length());

    }

}