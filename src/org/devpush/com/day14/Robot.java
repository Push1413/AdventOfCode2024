package org.devpush.com.day14;

import java.math.BigInteger;

public class Robot {
    private static final int roomX = 101;
    private static final int roomY = 103;
    private int x;
    private int y;
    private int vx;
    private int vy;

    public Robot(int x, int y, int vx, int vy, long start){
        BigInteger xcal = BigInteger.valueOf(x);
        xcal = xcal.add(BigInteger.valueOf(vx).multiply(BigInteger.valueOf(start)));
        this.x = xcal.mod(BigInteger.valueOf(roomX)).intValue();

        BigInteger ycal = BigInteger.valueOf(y);
        ycal = ycal.add(BigInteger.valueOf(vy).multiply(BigInteger.valueOf(start)));
        this.y = ycal.mod(BigInteger.valueOf(roomY)).intValue();

        this.vx = vx;
        this.vy = vy;
    }

    public void move() {
        this.x += vx;
        this.y += vy;
        this.x = (roomX + x) % roomX;
        this.y = (roomY + y) % roomY;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



}