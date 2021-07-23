package b4_class_and_object_in_java.bai_tap.quadraticEquation;

public class QuadraticEquation {
    private double a,b,c;
    public  QuadraticEquation(){
    }
    public QuadraticEquation (double a, double b, double c ){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public double  getDiscriminant(){
        double delta = Math.pow(b, 2) - 4*a*c;
        return delta;
    }
    public double getRoot1(){
        double root1 = ((-b + Math.pow((this.getDiscriminant()),0.5))/2*a);
        return root1;
    }
    public double getRoot2(){
        double root2 = ((-b - Math.pow((this.getDiscriminant()),0.5))/2*a);
        return root2;
    }
}
