package logic.language.editor.font.builder;

import java.util.ArrayList;
import java.util.List;

public class Arc
{
    public double cx;
    public double cy;
    public double rx;
    public double ry;
    public double theta;
    public double delta;
    
    public Arc(final double x1, final double y1, final double x2, final double y2, final double rx, final double ry, final double sweepflag, final double largeflag) {
        this.rx = rx;
        this.ry = ry;
        final double x1p = (x1 - x2) / 2.0;
        final double y1p = (y1 - y2) / 2.0;
        double sqrt = Math.sqrt(Math.abs((rx * rx * ry * ry - rx * rx * y1p * y1p - ry * ry * x1p * x1p) / (rx * rx * y1p * y1p + ry * ry * x1p * x1p)));
        if (largeflag == sweepflag) {
            sqrt = -sqrt;
        }
        final double cxp = sqrt * rx * y1p / ry;
        this.cx = cxp + (x1 + x2) / 2.0;
        final double cyp = -sqrt * ry * x1p / rx;
        this.cy = cyp + (y1 + y2) / 2.0;
        this.theta = angle(1.0, 0.0, (x1p - cxp) / rx, (y1p - cyp) / ry);
        this.delta = angle((x1p - cxp) / rx, (y1p - cyp) / ry, (-x1p - cxp) / rx, (-y1p - cyp) / ry);
        if (sweepflag == 0.0 && this.delta > 0.0) {
            this.delta -= 6.283185307179586;
        }
        else if (sweepflag == 1.0 && this.delta < 0.0) {
            this.delta += 6.283185307179586;
        }
    }
    
    public boolean isOK() {
        return !Double.isNaN(this.delta) && !Double.isNaN(this.theta) && this.delta != 0.0;
    }
    
    public List<double[]> asBezier() {
        final double quarter = 0.7853981633974483;
        final List<double[]> result = new ArrayList<>();
        double lastAngle = 0.0;
        double newAngle = 0.0;
        do {
            if (this.delta > 0.0) {
                newAngle += 0.7853981633974483;
                if (newAngle > this.delta) {
                    newAngle = this.delta;
                }
            }
            else {
                newAngle -= 0.7853981633974483;
                if (newAngle < this.delta) {
                    newAngle = this.delta;
                }
            }
            final double midAngle = (newAngle + lastAngle) / 2.0;
            final double radius = Math.sqrt(this.rx * this.rx + Math.tan(midAngle - lastAngle) * this.rx * Math.tan(midAngle - lastAngle) * this.rx);
            result.add(new double[] { toX(this.cx, this.cy, this.theta + midAngle, radius), toY(this.cx, this.cy, this.theta + midAngle, radius), 0.0 });
            result.add(new double[] { toX(this.cx, this.cy, this.theta + newAngle, this.rx), toY(this.cx, this.cy, this.theta + newAngle, this.ry), 1.0 });
            lastAngle = newAngle;
        } while (newAngle != this.delta);
        return result;
    }
    
    @Override
    public String toString() {
        return "Arc center=" + this.cx + ", " + this.cy + "; radius: " + this.rx + ", " + this.ry + " start: " + this.theta / 3.141592653589793 * 180.0 + " angle: " + this.delta / 3.141592653589793 * 180.0;
    }
    
    public static double toY(final double cx, final double cy, final double angle, final double r) {
        return cy + r * Math.sin(angle);
    }
    
    public static double toX(final double cx, final double cy, final double angle, final double r) {
        return cx + r * Math.cos(angle);
    }
    
    public static double angle(final double ux, final double uy, final double vx, final double vy) {
        final double val = Math.acos(scalprod(ux, uy, vx, vy) / norm(ux, uy) / norm(vx, vy));
        return (ux * vy - uy * vx < 0.0) ? (-val) : val;
    }
    
    public static double norm(final double ux, final double uy) {
        return Math.sqrt(scalprod(ux, uy, ux, uy));
    }
    
    public static double scalprod(final double ux, final double uy, final double vx, final double vy) {
        return ux * vx + uy * vy;
    }
}
