import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Connor on 10/11/14.
 */
public abstract class Body {
    public Vector position,speed,accel,size,max,min;
    public double mass;
    public double inverseMass;
    public double restituion;
    public ArrayList<Vector> forces = new ArrayList<Vector>();
    public void update(double delta){
        accel = new Vector(0,0);
        for(Vector v : forces) {
            accel.add(Vector.multVector(v,inverseMass));
        }
        speed.add(Vector.multVector(accel,delta));
        friction();
        position.add(Vector.multVector(speed,delta));
    }
    public abstract void draw(Graphics g);
    public Body(double x,double y,double width,double height){
        position = new Vector(x,y);
        size = new Vector(width,height);
        speed = new Vector(0,0);
        accel = new Vector(0,0);
        mass = (size.x * size.y) / 100;
        inverseMass = 1 / mass;
        forces.add(Vector.multVector(Constants.gravity,mass));
    }
    public void friction(){
        double friction = Constants.friction + Math.abs(speed.x) / 100;
        if(Math.abs(speed.x) < friction)
            speed.x = 0;
        else {
            speed.x = Math.copySign(Math.abs(speed.x) - friction, speed.x);
        }
    }
    public abstract boolean collide(Manifold m);
}
