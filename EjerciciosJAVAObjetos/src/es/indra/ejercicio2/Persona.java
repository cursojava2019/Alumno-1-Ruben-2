package es.indra.ejercicio2;

public class Persona {
	
	
	protected String nombre;
	protected Integer edad;
	protected String DNI;
	static char HOMBRE='H';
	static char MUJER='M';
	protected Float peso;
	protected Float altura;
	protected char sexo;
	
	static int PESOBAJO=-1;
	static int PESOIDEAL=0;
	static int SOBREPESO=1;
	
	
	
	public Persona() {
		
		super();
		this.nombre = "";
		this.edad = 0;
		this.sexo = HOMBRE;
		this.DNI = generaDNI();
		this.peso = Float.valueOf(0);
		this.altura = Float.valueOf(0);
	}
	

	public Persona(String nombre, Integer edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.DNI = generaDNI();
		this.peso = Float.valueOf(0);
		this.altura = Float.valueOf(0);
	}




	public Persona(String nombre, Integer edad, Float peso, Float altura,char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		//DNI = dNI;
		this.peso = peso;
		this.altura = altura;
		this.sexo=HOMBRE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

/*	public void setDNI(String dNI) {
		DNI = dNI;
	}*/

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public int calcularIMC() {
		
	
		double imc=0;
		double factor = this.getPeso() / (Math.pow(this.getAltura(), 2));
		imc=this.getPeso()/factor;
		if (imc<20)
		{
			return PESOBAJO;
		}
		if (imc>=20 && imc<=25)
		{
			return PESOIDEAL;
		}
		if (imc>25)
		{
			return SOBREPESO;
		}
		return -1;
	}
	
	public boolean esMayorEdad() {
		if(this.getEdad()>18) {
			return true;
		}else {
			return false;
		}
		
	}
	
	private char comprobarSexo(char sexo) {
		if(sexo==HOMBRE || sexo==MUJER) {
			return this.sexo;
		}else {
			return HOMBRE;
		}
			
		
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", peso=" + peso + ", altura=" + altura
				+ ", sexo=" + sexo + "]";
	}
	
	//int valorDado = Math.floor(Math.random()*10+1);
	
	  private static char generaLetraDNI(int var1) {
	        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y','F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
	            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
	 
	        return letras[var1];
	 }
	
	public static String generaDNI() {
		 final int divisor = 23;
		 String dni;
		 
	     int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
	     int var1 = numDNI - (numDNI / divisor * divisor);
	 
	     char letraDNI = generaLetraDNI(var1);
	 
	     dni = Integer.toString(numDNI) + letraDNI;
	     return dni;
		
	}

}
