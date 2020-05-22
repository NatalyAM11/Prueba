package main;

import java.util.ArrayList;
import java.util.LinkedList;

import Exceptions.FirstException;
import Exceptions.SecondException;
import processing.core.PApplet;

public class Main extends PApplet {
	
	LinkedList <Figura> circulos;
	int cantidadFiguras=100;
	boolean activar;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}

	
	
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		circulos= new LinkedList <Figura>();
		activar=false;
	}
	
	public void draw() {
		background(0);
		text("X:" + mouseX + "Y:" + mouseY, mouseX, mouseY);
		
		
		//Try del choque
		try{
			
			choque();
		    verificarCirculos();
		      
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			
		}catch (Exception e) {
			 System.out.println(e.getMessage());
			 fill(255);
			 textSize(20);
	         text (e.getMessage(),137,64);
		}
		
		
		//try ya no hay interaccion
try{
			
			choque();
			verificarInteraccion();
		      
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			
		}catch (Exception e) {
			 System.out.println(e.getMessage());
			 fill(255);
			 textSize(20);
	         text (e.getMessage(),137,64);
		}
		
		
		
		
		
	
		
		
		//Boton eliminar
			
				fill(255);
				rect(298,550,150,50);
				fill(0);
				text("Eliminar",332,570);
	
		//For para el choque 
		for (int i=0; i<circulos.size();i++) {
		
			
			circulos.get(i).pintar();
			
			//Hilo
			new Thread (circulos.get(i)).start();
			
		}
		
		
		
	}
	
	public void mousePressed() {
		if( (mouseX>0 && mouseX<800)&& (mouseY>0 && mouseY<550)){
		circulos.add(new Figura((int)random(20,580),(int)random(20,580),(int)random(50,80),this));
		activar=true;
		}
		
		
		
		if( (mouseX>298 && mouseX<448)&& (mouseY>550 && mouseY<600)){
			circulos.removeLast();
			System.out.println("no funciona");
			
		}
	}
	
	
	//Metodo para eliminar la bolita en el choque
	public void choque() {
		for (int i=0; i<circulos.size();i++) {
		for (int j=0; j<circulos.size();j++) {
			
			if(circulos.get(i).getTam()>circulos.get(j).getTam()) {
			if(dist(circulos.get(i).getPosX(), circulos.get(i).getPosY(), circulos.get(j).getPosX()+25,
					circulos.get(j).getPosY())<25) {
				
				//cambio de color
				circulos.get(i).setR(circulos.get(j).getR());
				circulos.get(i).setG(circulos.get(j).getG());
				circulos.get(i).setB(circulos.get(j).getB());
				
					circulos.remove(j);
					
				
			
					
			}
			}
			
			
			if(circulos.get(j).getTam()>circulos.get(i).getTam()) {
				if(dist(circulos.get(i).getPosX(), circulos.get(i).getPosY(), circulos.get(j).getPosX()+25,
						circulos.get(j).getPosY())<25) {
					
					
					circulos.get(j).setR(circulos.get(i).getR());
					circulos.get(j).setG(circulos.get(i).getG());
					circulos.get(j).setB(circulos.get(i).getB());
					
						circulos.remove(i);
				
				}
				}
			
			
			if(circulos.get(i).getTam()==circulos.get(j).getTam()) {
				if(dist(circulos.get(i).getPosX(), circulos.get(i).getPosY(), circulos.get(j).getPosX()+25,
						circulos.get(j).getPosY())<25) {
				circulos.get(i).setDirX(circulos.get(i).getDirX()*-1) ;
				circulos.get(i).setDirY(circulos.get(i).getDirY()*-1) ;
				circulos.get(j).setDirX(circulos.get(j).getDirX()*-1) ;
				circulos.get(j).setDirY(circulos.get(j).getDirY()*-1) ;
				
			}
			}
			
		}
	}
	}
	
	
	//Exception de que ya no puede eliminar mas bolas 
	 public void verificarCirculos() throws FirstException {
			
				
				if((circulos.size()==0)&& activar==true) {
					throw new FirstException ("Ya no puedes eliminar mas bolas");
				
			}
	
			 }
	 
		//Exception de que ya no puede eliminar mas bolas 
	 public void verificarInteraccion() throws SecondException {
		 for (int i=0; i<circulos.size();i++) {
				for (int j=0; j<circulos.size();j++) {
				
					if(circulos.get(i).getTam()==circulos.get(j).getTam()) {
					throw new SecondException ("Ya no hay mas interacciones");
				
			}
	
			 }
		 }
	 }
	 
	 
		 
		
	 
}
