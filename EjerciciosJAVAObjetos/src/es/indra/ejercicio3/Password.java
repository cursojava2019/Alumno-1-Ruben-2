package es.indra.ejercicio3;

public class Password {
	
	protected int longitud=8;
	protected String contrasena;
	
	public Password()
	{
		super();
		
	}
	
	public Password(int longitud) {
		super();
		this.longitud = longitud;		
		this.contrasena=generarPassword();
	}
	
	
	
	
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContrasena() {
		return contrasena;
	}



	public String generarPassword() {
		contrasena = "";
		for (int i = 0; i < this.longitud; i++) {

			switch ((int) (Math.random() * 3)) {
			case 0:
				contrasena += (char) (Math.random() * 26 + 'A');
				break;
			case 1:
				contrasena += (char) (Math.random() * 26 + 'a');
				break;
			case 2:
				contrasena += (char) (Math.random() * 10 + '0');
				break;
			}
		}
		return contrasena;
	}
	
	public boolean esFuerte() {
		int mayusc=0, minus=0, num=0;
		int ascii;
		for(int i = 0; i < getContrasena().length(); i++) {
			char valor=contrasena.charAt(i);
	        ascii=(int)valor;    
	        
	        if(ascii>=65 && ascii<=90){
	            mayusc++;
	        }else if(ascii>=97 && ascii<=122){
	            minus++;
	        }else if(ascii>=48 && ascii<=57){
	            num++;
	        }
		}  
	        if(mayusc>2 && minus>1 && num>5)
	        {
	        	
	        	return true;
	        }else {
	        	
	        	return false;
	        }
			
			
	}
	
	
	
}
