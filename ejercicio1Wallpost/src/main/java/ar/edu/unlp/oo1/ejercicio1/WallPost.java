package ar.edu.unlp.oo1.ejercicio1;

public interface WallPost {
	
	/**
	 * Retorna el texto descriptivo de la publicación
	 * 
	 * @return
	 */
	String getText();
	
	/**
	 * Setea el texto descriptivo de la publicación
	 * @param text
	 */
	void setText(String text);
	
	/**
	 * Setea el texto descriptivo de la publicación y retorna la instancia de Wallpost
	 * 
	 * @param text
	 * @return
	 */
	WallPost text(String text);

	/**
	 * Retorna la cantidad de “me gusta”
	 * 
	 * @return
	 */
	int getLikes();
	
	/**
	 * Incrementa la cantidad de likes en uno
	 */
	WallPost like();
	
	/**
	 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada
	 */
	WallPost dislike();
	
	/**
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	 * 
	 * @return
	 */
	boolean isFeatured();
	
	/**
	 * Cambia el post del estado destacado a no destacado y viceversa
	 */
	WallPost toggleFeatured();
	

	
}
