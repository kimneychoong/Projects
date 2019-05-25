import math
import random
class SVG:
    def __init__(self,fileName,minX,minY,width,height):
        self.output = open(fileName, 'w')
        self.output.write("<svg xmlns ='http://www.w3.org/2000/svg' viewBox ='" + str(minX) + " " + str(minY) + " " +str(width) + " " +str(height) + "'>")
        self.r = 0
        self.g = 0
        self.b = 0
        self.stroke_width = 1
      
    def drawLine(self,x1,y1,x2,y2):
        self.output.write("<line x1=" "'" + str(x1) + "'" +" y1="+ "'" +str(y1) + "'" +" x2=" +"'" +str(x2) +"'" +" y2="+ "'"+ str(y2) +"'"+ " "
                          "style='stroke:rgb("+ str(self.r) + "," +str(self.g)+ "," +str(self.b)+");'"+ " "
                          +"/>\n")
        
    
    def setColor(self,r,g,b):
        self.r = r
        self.g = g
        self.b = b

    def comment(self, contents):
        self.output.write("<!--" + contents + "-->")

    def closeFile(self):
        self.output.write("</svg>")
        self.output.close()
        
class Epicycle:
    
    def __init__(self, speed, radius):
        self.speed = speed
        self.circles = len(speed)
        self.radius = radius
        self.kim = []

    def simulate(self, maxTime, dt):
        t = 0.00
        print(len(self.radius));
        print(len(self.speed));
       
        while(t <= maxTime):
            x = 0
            y = 0
            for index in range(self.circles): #0 1 
                x += (self.radius[index] * math.cos(t*self.speed[index]))
                y += (self.radius[index] * math.sin(t*self.speed[index]))
            self.kim += [(x,y)]
            t += dt
            
    def getPoints(self):
        if(self.kim == []):
            return None
        else:
            return self.kim
        
    def maximum(self,A,I):
        maxn = A[0][I]
        for i in range(len(A)):
            if A[i][I] > maxn:
                maxn = A[i][I]
        return maxn
            
    def minimum(self,A,I):
        minn = A[0][I]
        for i in range(len(A)):
            if A[i][I] < minn:
                minn = A[i][I]
        return minn


    def getMinX(self):
        if(self.kim == []):
            return None
        else:
            return self.minimum(self.kim, 0)

    def getMinY(self):
        if(self.kim == []):
            return None
        else:
            return self.minimum(self.kim, 1)

    def getMaxX(self):
        if(self.kim == []):
            return None
        return self.maximum(self.kim, 0)

    def getMaxY(self):
        if(self.kim == []):
            return None
        else:
            return self.maximum(self.kim, 1)

    def getWidth(self):
        if(self.kim == []):
            return None
        else:
            return self.getMaxX() - self.getMinX()

    def getHeight(self):
        if(self.kim == []):
            return None
        else:
            return self.getMaxY() - self.getMinY()

    def toString(self):
        print("Width: {0} \nheight : {1}\nPairs : {2}\nMinX: {3}\nMinY: {4}\nMaxX: {5}\nMaxY: {6}".format(self.getWidth(), self.getHeight(), str(self.kim), self.getMinX(), self.getMinY(), self.getMaxX(), self.getMaxY() ))

def render(epicycle, filename):
        a = SVG(filename, epicycle.getMinX(), epicycle.getMinY(), epicycle.getWidth(), epicycle.getHeight())
        b = 0
        c = epicycle.getPoints()
        while(b < len(c) - 1):
            a.setColor(255,255,0) 
            a.drawLine(c[b][0], c[b][1], c[b+1][0], c[b+1][1])
            b+=1
        a.closeFile()

   
circles = 4
speed = [random.randint(0,20)-10 for i in range(circles)]
radius = [i+random.randint(0,200)-100 for i in range(circles)]

# note - appropraite values for speed parameters depend on the valid range of speed
# Therefore this should be called outside of the simulate method.
maxT = 10
ds = 0.01

e = Epicycle(speed, radius)  

# 14 is probably way to large, but I don't want to have to re-render. ever.


e.simulate(maxT, ds)
e.toString()
render(e, "example.svg")
print("doneee")
      
                
        

                          


