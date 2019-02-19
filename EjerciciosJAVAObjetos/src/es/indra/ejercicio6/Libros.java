package es.indra.ejercicio6;

public class Libros {
	protected String isbn;
	protected String titulo;
	protected String autor;
	protected Integer numeroDePaginas;

	public Libros(String isbn, String titulo, String autor, Integer numeroDePaginas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumeroDePaginas() {
		return this.numeroDePaginas;
	}

	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	@Override
	public String toString() {
		return "El Libro con " + this.isbn + " creado por el autor " + this.autor + " tiene " + this.numeroDePaginas
				+ " paginas";
	}
}