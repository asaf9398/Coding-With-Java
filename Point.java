/**
 * Represents a point in a Cartesian coordinate system
 * @author Asaf Yosef
 * @version 10/04/2021
 */

import java.lang.Math;//importing "Math" for using in the class 
class Point//entering the class
    {
        private double _x, _y;//creating variables 
        
        /**
         * Initializing a point object
         * @param x represents the X value in the Cartesian coordinate system
         * @param y represents the Y value in the Cartesian coordinate system
         */
        public Point(double x, double y)//first constractor
        {
            this._x = x;//inserting the valuse to the variable
            this._y = y;//inserting the valuse to the variable

        }
        /**
         * Initializing a point object using another point 
         * @param point represents another point that it's X&Y values being copied from
         */
        public Point(Point point)//second constractor
        {
            this._x = point.getX();//inserting the value to the variable
            this._y = point.getY();//inserting the value to the variable
        }

        /**
         * Returns the point's X value
         * @return X value of the specific point
         */
        public double getX()//the method returns the X value of the point 
        {
            return _x;//returning the X value
        }
        /**
         * Returns the point's Y value
         * @return Y value of the specific point
         */
        public double getY()//the method returns the Y value of the point
        {
            return _y;//returning the Y value
        }
        /**
         * Inserting a new value to the X variable
         * @param num New value of the specific point's X
         */
        public void setX(double num)//the method setting a new value to the X value of the point
        {
            _x = num;//inserting the value to the variable
        }
        /**
         * Inserting a new value to the Y variable
         * @param num New value of the specific point's Y
         */
        public void setY(double num)//the method setting a new value to the Y value of the point
        {
            _y = num;//inserting the value to the variable
        }
        /**
         * Returns the point's X&Y value
         * @return string of the value of the specific point,for example :"(2.0,3.0)"
         */
        public String toString()//returns a String value of the printing of the dot"(x,y)"
        {
            return ("(" + _x + "," + _y + ")");//returning the string value
        }
        /**
         * Returns True/False if the points are identical
         * @param other Is another point for comparison 
         * @return True/False if the points are identical
         */
        public boolean equals(Point other)//checks if the points are equal(same X&Y values)
        {
            if (_x == other.getX() && _y == other.getY())//if the dots are the same - Return true
                return true;//returning true if the points are identical 
            return false;//in any other case - return False
        }
        /**
         * Returns True/False if the specific point is above the other point
         * @param point Is another point for comparison 
         * @return True/False if the point is above the other point
         */
        public boolean isAbove(Point point)//checking if the first point is above the second 
        {
            return point._y<_y;//if the Y value of the first dot is bigger - return true , else - returns false
        }
        /**
         * Returns True/False if the specific point is under the other point
         * @param point Is another point for comparison 
         * @return True/False if the point is under the other point
         */
        public boolean isUnder(Point point)//checking if the first point is below the second 
        {
            return point.isAbove(this);//checking if the Y value of the second point is bigger than the Y of the first point . if the second point is above the first - return true, else - return false. 
        }
        /**
         * Returns True/False if the specific point is left from the other point
         * @param point Is another point for comparison 
         * @return True/False if the point is left from the other point
         */
        public boolean isLeft(Point point)//checking if the first point is left to the second point
        {
            return point._x>_x;//if the first point's X is smaller(he is more left than the secont point) - return true , else - return false 
        }
        /**
         * Returns True/False if the specific point is right from the other point
         * @param point Is another point for comparison 
         * @return True/False if the point is left right the other point
         */
        public boolean isRight(Point point)//checking if the second point is left to the first point
        {
            return point.isLeft(this);//if the second point is left to the first point - return true(first point is right to the second point), else - return false
        }
        /**
         * Returns Distance between two points
         * @param point Is another point for distance calculation 
         * @return Distance between the points
         */
        public double distance(Point p)//calculating the distance between 2 dots
        {
            /*
             * calculating and returning the value with this calculation:
             * ( (Y1-y2)^2 + (X1-X2)^2 )^ 0.5             
             */
            return (Math.pow((Math.pow((p.getY() - _y), 2) + Math.pow((p.getX() - _x), 2)), 0.5));
        }
        /**
         * Returns the quadrant of the specific point
         * @return quadrant of the specific point
         */
        public int quadrant()//checking the quadrant of the point
        {
            if (_x == 0 || _y == 0)//if X/Y is on the lines - return 0
                return 0;
            else
            {
                if (_x > 0)//checking the first quadrand(X>0&Y>0)
                    if (_y > 0)
                        return 1;
                    else
                        return 4;//checking the fourth quadrand(X>0&Y<0)
                else if (_y > 0)//checking the second quadrand(X<0&Y>0)
                    return 2;
                else
                    return 3;//checking the third quadrand - if it's not quadrant 1/2/4 - return 3
            }
        }
    }
