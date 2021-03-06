/**
 * Created by Connor on 2014-11-07.
 */
public class Vector{
    public double x,y;
    public Vector(double x,double y){
        this.x = x;
        this.y = y;
    }
    public void add(Vector v){
        x += v.x;
        y += v.y;
    }
    public void sub(Vector v){
        x -= v.x;
        y -= v.y;
    }
    public void mult(Vector v){
        x *= v.x;
        y *= v.y;
    }
    public void mult(double factor){
        x *= factor;
        y *= factor;
    }
    public void div(Vector v){
        x /= v.x;
        y /= v.y;
    }
    public double Magnitiude(){
        return Math.sqrt(x * x + y * y);
    }
    public double LengthSquared(){
    	return x * x + y * y;
    }
    public double Average(){ return (x + y)/2;}
    public static Vector multVectors(Vector v1,Vector v2){
        return new Vector(v1.x * v2.x,v1.y * v2.y);
    }
    public static Vector multVector(Vector v,double factor){
        return new Vector(v.x * factor,v.y * factor);
    }
    public static Vector addVectors(Vector v1,Vector v2){
        return new Vector(v1.x + v2.x,v1.y + v2.y);
    }
    public static Vector subVectors(Vector v1,Vector v2){
        return new Vector(v1.x - v2.x,v1.y - v2.y);
    }
    public static Vector divVector(Vector v1, double f){
    	return new Vector(v1.x / f,v1.y / f);
    }
    public static double dotProduct(Vector v1,Vector v2){
    	return v1.x * v2.x + v1.y * v2.y; 
    }
    public static Vector absVector(Vector v){return new Vector(Math.abs(v.x),Math.abs(v.y));}
    @Override
    public String toString(){
        return super.toString() + "[" + x + "," + y + "]";
    }
}