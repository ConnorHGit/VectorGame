import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Connor on 2014-11-07.
 */
public class Circle extends Body{
	private Color color;
    public Circle(double x,double y,double width,double height,Color c){
        super(x,y,width,height);
        max = Vector.subVectors(position,Vector.multVector(size,2));
        min = Vector.addVectors(position,Vector.multVector(size, 2));
        restituion = 1.2;
        this.color = c;
    }
    public void update(double delta){
        super.update(delta);
        if(VectorGame.game != null){
        	if(position.x + size.x / 2  > VectorGame.game.getWidth()){speed.x *= -Constants.absorbtion;position.x = VectorGame.game.getWidth() - size.x / 2;}
        	if(position.x - size.x / 2 < 0){speed.x *= -Constants.absorbtion;position.x = 0 + size.x / 2;}
        	if(position.y + size.y / 2 > VectorGame.game.getHeight()){speed.y *= -Constants.absorbtion;position.y = VectorGame.game.getHeight() - size.y / 2;}
        	if(position.y - size.y / 2 < 0){speed.y *= -Constants.absorbtion;position.y = 0 + size.y / 2;}
        }
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)(position.x - size.x / 2), (int)(position.y - size.y / 2), (int) size.x, (int) size.y);
    }
	public boolean collide(Manifold m) {
		Vector n = Vector.subVectors(m.b.position,m.a.position);
		
		double r = Math.pow((m.a.size.y / 2 + m.b.size.x / 2),2);
		if(n.LengthSquared() > r)
			return false;
		double d = n.Magnitiude();
		if(d != 0){
			m.penetration = r - d;
			m.normal = Vector.divVector(n,d);
			return true;
		}
		else{
			m.penetration = m.a.size.x / 2;
			m.normal = new Vector(1,0);
			return true;
		}
	}
}
