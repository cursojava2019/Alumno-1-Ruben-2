package es.indra.ejercicio5;

import java.util.ArrayList;

public class Ejercicio5Main  {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Videojuego[] lista=new Videojuego[5];	
		  ArrayList<Videojuego> listaVideojuego = new ArrayList<Videojuego>();
		  
		  Serie[] lista2=new Serie[5];	
		  ArrayList<Serie> listaSerie = new ArrayList<Serie>();
		  
		  Videojuego v1=new Videojuego();
		  Videojuego v2=new Videojuego("Zelda",45);
		  Videojuego v3=new Videojuego("Mario",12,"Plataformas", "Nintendo");
		  Videojuego v4=new Videojuego("Sonic",12,"Plataformas", "Sega");
		  Videojuego v5=new Videojuego("Columns",7);
		  
		  Serie s1=new Serie();
		  Serie s2=new Serie("Serie1","Antonio");
		  Serie s3=new Serie("Serie2",24,"Policiaco", "FOX");
		  Serie s4=new Serie("Serie3",14,"Drama", "Miramax");
		  Serie s5=new Serie("Serie4",2,"Policiaco", "Sony");
		 
		  listaVideojuego.add(v1);
		  listaVideojuego.add(v2);
		  listaVideojuego.add(v3);
		  listaVideojuego.add(v4);
		  listaVideojuego.add(v5);
		  listaSerie.add(s1);
		  listaSerie.add(s2);
		  listaSerie.add(s3);
		  listaSerie.add(s4);
		  listaSerie.add(s5);
		  
		  listaSerie.get(1).entregar();
		  listaSerie.get(3).entregar();
		  listaVideojuego.get(1).entregar();
		  
		  int e1=0;
		  int e2=0;
		  for (int i=0; i<=listaVideojuego.size();i++)
		  {
			  if( listaVideojuego.get(i).isEntregado())
			  {
				  e1++;
			  }
			  
		  }
		  for (int i=0; i<=listaSerie.size();i++)
		  {
			  if( listaSerie.get(i).isEntregado())
			  {
				  e2++;
			  }
			  
		  }
		  
		  System.out.println("El total de videojuegos entregados es: " + e1);
		  System.out.println("El total de series entregadas es: " + e2);

	}

}
