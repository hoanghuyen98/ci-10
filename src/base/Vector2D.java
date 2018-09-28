package base;

public class Vector2D {
    public float x;
    public float y;
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    // return an other vector with same x & y
    public Vector2D clone(){
        this.x = x;
        this.y = y;
        return this;
    }
    // return new vector = old vector + pass argument
    public Vector2D add(float x, float y){
        Vector2D result = new Vector2D(this.x, this.y);
        result.x += x;
        result.y += y;
        return result;
    }
    public Vector2D addThis(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D substract(float x, float y){
        Vector2D result = new Vector2D(this.x, this.y);
        result.x += x;
        result.y += y;
        return result;
    }

    public Vector2D substractThis(float x , float y){
        this.x += x;
        this.y += y;
        return  this;
    }
    public Vector2D scale(float n){
        return new Vector2D(this.x * n, this.y * n);
    }

    public Vector2D scaleThis(float n) {
        this.x *= n;
        this.y *= n;
        return this;
    }
    public float length(){
        return (float)Math.sqrt(this.x * this.x + this.y*this.y);
    }
    public void print(){
        System.out.println(x + "; " +y);
    }
}

