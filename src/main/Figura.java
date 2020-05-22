package main;

import processing.core.PApplet;

public class Figura implements Runnable {
 private PApplet app;
 private int posX;
 private int posY;
 private int tam;
 private int r;
 private int g;
 private int b;
 private int vel;
 private int dirX;
 private int dirY;
 
	public Figura(int posX, int posY,int tam,PApplet app) {
		this.posX=posX;
		this.posY=posY;
		this.tam=tam;
		this.app=app;
		this.vel=1;
		this.r=(int)app.random(50,255);
		this.g=(int)app.random(50,255);
		this.b=(int)app.random(50,255);
		this.dirX = 1;
        this.dirY = 1;
	}
	
	
	public void run() {
		
	try{
		Thread.sleep(3000);
		mover();
	
	} catch (IndexOutOfBoundsException e) {
		System.out.println(e.getMessage());
		
	}catch (Exception e) {
		
	}
}
	
	
	public void pintar () {
		app.fill(r,g,b);
		app.noStroke();
		app.ellipse(posX, posY, tam, tam);
	}
	
	public void mover () {
		this.posX += 5 * this.dirX;
	      this.posY += 5 * this.dirY;




	      if (this.posX >= 800 || this.posX <= 0) {
	            this.dirX *= -1;
	        }
	        if (this.posY >= 600|| this.posY <= 0) {
	            this.dirY *= -1;
	        }
	
	
	}
	
	
	public int getDirX() {
		return dirX;
	}


	public void setDirX(int dirX) {
		this.dirX = dirX;
	}


	public int getDirY() {
		return dirY;
	}


	public void setDirY(int dirY) {
		this.dirY = dirY;
	}


	public void choque() {
		
	}
	
	
	

//Getters y Setters
	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getTam() {
		return tam;
	}


	public void setTam(int tam) {
		this.tam = tam;
	}


	public int getR() {
		return r;
	}


	public void setR(int r) {
		this.r = r;
	}


	public int getG() {
		return g;
	}


	public void setG(int g) {
		this.g = g;
	}


	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}


	public int getVel() {
		return vel;
	}


	public void setVel(int vel) {
		this.vel = vel;
	}




}
