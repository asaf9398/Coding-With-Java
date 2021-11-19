/**
 * Represents a triagnle that built from 3 points in a Cartesian coordinate system
 * @author Asaf Yosef
 * @version 10/04/2021
 */
import java.lang.Math;//importing "Math" for further calculations
class Triangle//entering to the Triangle Class
    {
        private Point _point1, _point2, _point3;//creating 3 dots for the triangle
        static final double EPSILON = 0.001;//creating EPSILON variable for further calculations 
        /**
         * Initializing a triangle object using default values
         */
        Triangle()//first constractor - entering default values
        {
            _point1=new Point(1,0);//inserting default value
            _point2=new Point(-1,0);//inserting default value
            _point3=new Point(0,1);//inserting default value
        }
        /**
         * Initializing a triangle object, if the points are not valid - the points will turn to the default values
         * @param p1 represents value of the first point of the triangle in the Cartesian coordinate system
         * @param p2 represents value of the second point of the triangle in the Cartesian coordinate system
         * @param p3 represents value of the third point of the triangle in the Cartesian coordinate system
         */
        Triangle(Point p1, Point p2, Point p3)//second constractor - using 3 points
        {
            
            if(isValid(p1,p2,p3))//if IsValid == true - inserting the values
            {
                _point1=p1;//inserting first value
                _point2=p2;//inserting second value
                _point3=p3;//inserting third value
            }
            else//if IsValid == false - inserting default values
            {
                _point1=new Point(1,0);//inserting default value
                _point2=new Point(-1,0);//inserting default value
                _point3=new Point(0,1);//inserting default value
            }
            

        }
        /**
         * Initializing a triangle object, if the points are not valid - the points will turn to the default values
         * @param p1 represents value of the first point's X of the triangle in the Cartesian coordinate system
         * @param p2 represents value of the first point's Y of the triangle in the Cartesian coordinate system
         * @param p3 represents value of the second point's X of the triangle in the Cartesian coordinate system
         * @param p4 represents value of the second point's Y of the triangle in the Cartesian coordinate system
         * @param p5 represents value of the third point's X of the triangle in the Cartesian coordinate system
         * @param p6 represents value of the third point's Y of the triangle in the Cartesian coordinate system
         */
        Triangle(Double p1, Double p2, Double p3, Double p4, Double p5, Double p6)//second constractor - using 6 variables for new points
        {
            _point1=new Point(p1,p2);//creating new point
            _point2=new Point(p3,p4);//creating new point
            _point3=new Point(p5,p6);//creating new point
            if(isValid(_point1,_point2,_point3)==false)//if isValid == false - change to default
            {
                _point1=new Point(1,0);//change to default
                _point2=new Point(-1,0);//change to default
                _point3=new Point(0,1);//change to default
            }

            //if isValid == true - keep the values for the triangle
            
            
        }
        /**
         * Initializing a triangle object - using a triangle
         * @param other represents another exists triangle
         */
        Triangle(Triangle other)//third constractor - using another triangle
        {
            _point1 = other.getPoint1();//copying the point
            _point2 = other.getPoint2();//copying the point
            _point3 = other.getPoint3();//copying the point
        }
        /**
         * Returns triangle's first point
         * @return triangle's first point value
         */
        public Point getPoint1()//returns Point1 in the triangle
        {
            return _point1;//returns Point1
        }
        /**
         * Returns triangle's second point
         * @return triangle's second point value
         */
        public Point getPoint2()//returns Point2 in the triangle
        {
            return _point2;//returns Point2
        }
        /**
         * Returns triangle's third point
         * @return triangle's third point value
         */
        public Point getPoint3()//returns Point3 in the triangle
        {
            return _point3;//returns Point3
        }
        /**
         * Sets triangle's first point - the point will set only if it is passes validation test
         * @param p is a new point value
         */
        public void setPoint1(Point p)//setting new point instead of point1
        {
            if(isValid(p,_point2,_point3))//checking point's validity
            {
            _point1.setX(p.getX());//setting new point's X value
            _point1.setY(p.getY());//setting new point's Y value
            }
        }
        /**
         * Sets triangle's second point - the point will set only if it is passes validation test
         * @param p is a new point value
         */
        public void setPoint2(Point p)//setting new point instead of point2
        {
            if(isValid(_point1,p,_point3))//checking point's validity
            {
            _point2.setX(p.getX());//setting new point's X value
            _point2.setY(p.getY());//setting new point's Y value
            }
        }
        /**
         * Sets triangle's third point - the point will set only if it is passes validation test
         * @param p is a new point value
         */
        public void setPoint3(Point p)//setting new point instead of point3
        {
            if(isValid(_point1,_point2,p))//checking point's validity
            {
            _point3.setX(p.getX());//setting new point's X value
            _point3.setY(p.getY());//setting new point's Y value
            }
        }
        /**
         * Checks triangle's validation according to sides length calculation
         * @param p1 is first point's value
         * @param p2 is second point's value
         * @param p3 is third point's value 
         * @return True/False according to the triangles validation
           */
        public boolean isValid(Point p1, Point p2, Point p3)//checking triagnle's validity
        { 
            double distance1 = p1.distance(p2);//side calaulation
            double distance2 = p2.distance(p3);//side calaulation
            double distance3 = p3.distance(p1);//side calaulation
            if (Math.abs((distance1 + distance2)-distance3) < EPSILON || Math.abs((distance2 + distance3)-distance1) < EPSILON || Math.abs((distance1 + distance3)-distance2) < EPSILON )//checking if the sides calculation is valid
                {
                    return false;
                }
            if(distance1 + distance2>distance3&&distance2 + distance3>distance1&&distance1 + distance3>distance2)//checking if the sides calculation is valid
                {
                return true;
                }
            return false;
        }
        /**
         * Returns the triangles X&Y values
         * @return string of the value of the specific points,for example :"{(1,0),(-1,0),(0,1)}"
         */
        public String toString()//returns a String value of the printing of the triangle"{(x1,y1),(x2,y2),(x3,y3)}"
        {
            return ("{" + _point1.toString() + "," + _point2.toString() + "," + _point3.toString() + "}");//returning the string value
        }
        /**
         * Returns the triangles perimeter
         * @return value of the triangles perimeter
         */
        public double getPerimeter()//calaulating the perimeter of the triagnle 
        {
            double distance1 = _point1.distance(_point2);//side calaulation
            double distance2 = _point2.distance(_point3);//side calaulation
            double distance3 = _point3.distance(_point1);//side calaulation
            double perimeter = distance1 + distance2 + distance3;//perimeter calaulation
            return perimeter;//returning perimeter
        }
        /**
         * Returns the triangles area
         * @return value of the triangles area
         */
        public double getArea()//calaulating the area of the triagnle 
        {
            double distance1 = _point1.distance(_point2);//side calaulation
            double distance2 = _point2.distance(_point3);//side calaulation
            double distance3 = _point3.distance(_point1);//side calaulation
            double perimeter = getPerimeter() / 2;//perimeter calaulation/2
            double area = Math.pow((perimeter * (perimeter - distance1) * (perimeter - distance2) * (perimeter - distance3)), 0.5);//area calaulation
            return area;//returning area
        }
        /**
         * Returns if the triangle is isosceles
         * @return True/False according to isosceles testing
         */
        public boolean isIsosceles()//checking if the traignle is isosceles
        {
            double distance1 = _point1.distance(_point2);//side calaulation
            double distance2 = _point2.distance(_point3);//side calaulation
            double distance3 = _point3.distance(_point1);//side calaulation
            if (distance1 == distance2 && distance2 == distance3)//שווה צלעות
                return true;
            if (distance1 == distance2 && distance2 != distance3)//first isosceles option
                return true;
            if (distance2 == distance3 && distance2 != distance1)//second isosceles option
                return true;
            if (distance1 == distance3 && distance3 != distance2)//third isosceles option
                return true;
            return false;//in any other case - return false
        }
        /**
         * Returns if the triangle is pythagorean
         * @return True/False according to pythagorean testing
         */
        public boolean isPythagorean()//checking if the traignle is pythagorean
        {
            double distance1 = _point1.distance(_point2);//side calaulation
            double distance2 = _point2.distance(_point3);//side calaulation
            double distance3 = _point3.distance(_point1);//side calaulation
            if (Math.abs((Math.pow(distance1, 2) + Math.pow(distance2, 2)) -Math.pow(distance3, 2)) < EPSILON )//first pythagorean option
                return true;
            if (Math.abs((Math.pow(distance2, 2) + Math.pow(distance3, 2))-Math.pow(distance1, 2)) < EPSILON )//second pythagorean option
                return true;
            if (Math.abs((Math.pow(distance1, 2) + Math.pow(distance3, 2))-Math.pow(distance2, 2)) < EPSILON )//third pythagorean option
                return true;
            return false;//in any other case - return false
        }
        /**
         * Returns if the triangle is located inside a specific circle with specific radius and center 
         * @param x Represents the X value of the center of the circle
         * @param y Represents the Y value of the center of the circle
         * @param r Represents the radius lenth of the circle
         * @return True if the whole triangle is located in the circle and False if not
         */
        public boolean isContainedInCircle(double x, double y, double r)//checking if the triangle is in the circle with a specific radius and center
        {
            double distance1 = Math.pow((Math.pow((_point1.getY() - y), 2) + Math.pow((_point1.getX() - x), 2)), 0.5);//distance calculation from point1 to the center
            double distance2 = Math.pow((Math.pow((_point2.getY() - y), 2) + Math.pow((_point2.getX() - x), 2)), 0.5);//distance calculation from point2 to the center
            double distance3 = Math.pow((Math.pow((_point3.getY() - y), 2) + Math.pow((_point3.getX() - x), 2)), 0.5);//distance calculation from point3 to the center
            if (distance1 < r || Math.abs(distance1 - r) < EPSILON)
                {
                    if (distance2 < r || Math.abs(distance2 - r) < EPSILON)
                    {
                        if (distance3 < r || Math.abs(distance3 - r) < EPSILON)
                            {
                                return true;//if all distances are smaller/equal to the radius - return true 
                            } 
                    }
                }
            return false;//in any other case - return false
        }
        /**
         * Returns the lowest point of the triangle, if two lowest points have the same Y value - the method will return the left point 
         * @return lowest point of the triangle
         */
        public Point lowestPoint()//returns the lowest point of the triangle - using X&Y 
        {
            if (_point1.isUnder(_point2))
            {
                if (_point1.isUnder(_point3))
                {
                    return _point1;
                }
                else
                {
                    if (_point3.isUnder(_point1))
                    {
                        return _point3;

                    }
                    else
                    {
                        if (_point1.isLeft(_point3))
                        {
                            return _point1;
                        }
                        else
                        {
                            return _point3;
                        }

                    }
                }
            }
            else
            {
                if (_point1.getY() == _point2.getY())
                {
                    if (_point1.isUnder(_point3))
                    {
                        if (_point1.isLeft(_point2))
                        {
                            return _point1;
                        }
                        else
                        {
                            return _point2;
                        }

                    }
                    else
                    {
                        return _point3;
                    }
                }
                else
                {
                    if (_point2.isUnder(_point3))
                    {
                        return _point2;
                    }
                    else
                    {
                        return _point3;
                    }
                }

            }

        }

        /**
         * Returns the highest point of the triangle, if two highest points have the same Y value - the method will return the left point 
         * @return highest point of the triangle
         */
        public Point highestPoint()//returns the highest point of the triangle - using X&Y
        {
            if (_point1.isAbove(_point2))
            {
                if (_point1.isAbove(_point3))
                {
                    return _point1;
                }
                else
                {
                    if (_point1.getY() == _point3.getY())
                    {
                        if (_point1.isLeft(_point3))
                        {
                            return _point1;
                        }
                        else
                        {
                            return _point3;
                        }
                    }
                    else
                    {
                        return _point3;
                    }

                }
            }
            else
            {
                if (_point2.isAbove(_point1))
                {
                    if (_point2.isAbove(_point3))
                    {
                        return _point2;
                    }
                    else
                    {
                        if (_point2.getY() == _point3.getY())
                        {
                            if (_point2.isLeft(_point3))
                            {
                                return _point2;
                            }
                            else
                            {
                                return _point3;
                            }
                        }
                        else
                        {
                            return _point3;
                        }

                    }

                }
                else
                { 
                if(_point2.isAbove(_point3))
                    {
                        if (_point1.isLeft(_point2))
                        {
                            return _point1;
                        }
                        else
                        {
                            return _point2;
                        }
                    }
                    else 
                    {
                        if (_point3.isAbove(_point2))
                        {
                            return _point3;
                        }
                        else
                        {
                            if (_point3.isLeft(_point2))
                            {
                                if (_point3.isLeft(_point1))
                                {
                                    return _point3;
                                }
                                else
                                {
                                    return _point1;
                                }
                            }
                            else
                            {
                                if (_point2.isLeft(_point3))
                                {
                                    if (_point2.isLeft(_point1))
                                    {
                                        return _point2;
                                    }
                                    else
                                    {
                                        return _point1;
                                    }
                                }
                                else
                                {
                                    if (_point2.isLeft(_point1))
                                    {
                                        return _point2;
                                    }
                                    else
                                    {
                                        return _point1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /**
         * Returns True if all the triangle is located on the same quadrant - in any other case return false
         * @return if all the triangle is located on the same quadrant
         */
        public boolean isLocated()//checking if all the triangle's points are on the same quadrant
        {
            return (_point1.quadrant()==_point2.quadrant()&& _point1.quadrant() == _point3.quadrant());//if do - return true, in all other case - return false

        }
        /**
         * Checking if a whole triangle is above other traignle 
         * @param other is another triangle to initiate the method on
         * @return True/False according to checking if the lowest point of the higher triangle is above the highest point of the higher triangle
         */
        public boolean isAbove(Triangle other)//checking if a whole triangle is above other traignle  
        {
            return (lowestPoint().getY() > other.highestPoint().getY());//checking if the lowest point of the higher triangle is above the highest point of the higher triangle
        }
        /**
         * Checking if a whole triangle is under other traignle 
         * @param other is another triangle to initiate the method on
         * @return True/False according to checking if the second triangle is above the first triangle using isAbove method
         */
        public boolean isUnder(Triangle other)//checking if a whole triangle is under other traignle
        {
            return other.isAbove(this);//checking if the second triangle is above the first triangle using isAbove method
        }
        /**
         * Checking if the triangles are identical 
         * @param other is another triangle
         * @return Returns true if the triangles are identical, in any other case - return false
         */
        public boolean equals(Triangle other)//checking if the triangles are identical
        {
            /*
             * the method returns true if the triangles are identical, in any other case - return false
             * */
            return (_point1.getX() == other.getPoint1().getX()&&_point1.getY() == other.getPoint1().getY()&&_point2.getX() == other.getPoint2().getX()&&_point2.getY() == other.getPoint2().getY()&&_point3.getX() == other.getPoint3().getX()&&_point3.getY() == other.getPoint3().getY());
        }
        /**
         * Checking if the triangles are congruent 
         * @param other is another triangle
         * @return Returns true if the triangles are congruent, in any other case - return false
         */
        public boolean isCongruent(Triangle other)
        {
            double firstEdge = _point1.distance(_point2);//side calculation
            double secondEdge = _point2.distance(_point3);//side calculation
            double thirdEdge = _point3.distance(_point1);//side calculation
            double fourthEdge = other.getPoint1().distance(other.getPoint2());//side calculation
            double fifthEdge = other.getPoint2().distance(other.getPoint3());//side calculation
            double sixEdge = other.getPoint3().distance(other.getPoint1());//side calculation
            if (firstEdge == fourthEdge)
                if (secondEdge == fifthEdge)
                    if (thirdEdge == sixEdge)
                        return true;//if the sides are the same - return true
            if (firstEdge == fourthEdge)
                if (secondEdge == sixEdge)
                    if (thirdEdge == fifthEdge)
                        return true;//if the sides are the same - return true
            if (firstEdge == fifthEdge)
                if (secondEdge == sixEdge)
                    if (thirdEdge == fourthEdge)
                        return true;//if the sides are the same - return true
            if (firstEdge == fifthEdge)
                if (secondEdge == fourthEdge)
                    if (thirdEdge == sixEdge)
                        return true;//if the sides are the same - return true
            if (firstEdge == sixEdge)
                if (secondEdge == fourthEdge)
                    if (thirdEdge == fifthEdge)
                        return true;//if the sides are the same - return true
            if (firstEdge == sixEdge)
                if (secondEdge == fifthEdge)
                    if (thirdEdge == fourthEdge)
                        return true;//if the sides are the same - return true
            return false;//in any other case - return false
        }
    }


