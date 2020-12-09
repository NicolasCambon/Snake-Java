package model;

import java.util.Random;

public class Pomme {
	private final int nblin;
	private final int nbcol;
	public Position pose;
	
	public Pomme(int nblin,int nbcol) {
		this.nblin=nblin;
		this.nbcol=nbcol;
	}
	
	public Position tirerPomme() {
		Random rd = new Random();
		int poslin=rd.nextInt(nblin);
		int poscol=rd.nextInt(nbcol);
		return pose = new Position(poslin,poscol);	
	}
	

}
