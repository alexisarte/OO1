package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	private String text;
	private boolean featured;
	private int likes;
	
	/**
	 * Complete con su implementación
	 */
	
	
	/*
	* Permite construir una instancia del Wallpost.
	* Luego de la invocación, el Wallpost debe tener como texto: “Undefined post”,
	* no debe estar marcado como destacado y la cantidad de “Me gusta” deben ser 0.
	*/
	public WallPostImpl() {
		text = "Undefined post";
		featured = false;
		likes = 0; 
	}

	/*
	* Retorna el texto descriptivo de la publicación
	*/
	public String getText() {
		return this.text;
	}
	
	/*
	* setea el texto descriptivo de la publicación
	*/
	public void setText (String descriptionText) {
		this.text = descriptionText;
	}
	
	/*
	 * Setea el texto descriptivo de la publicación y retorna la instancia de Wallpost
	 */
	public WallPost text(String text) {
		this.setText(text);
		return this;
	}
	
	/*
	* retorna la cantidad de “me gusta”
	*/
	public int getLikes() {
		return this.likes;
	}
	
	/*
	* Incrementa la cantidad de likes en uno y retorna la instancia de Wallpost.
	*/
	public WallPost like() {
		++this.likes;
		return this;
	}
	
	/*
	* Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada. Retorna la
	instancia de Wallpost.
	*/
	public WallPost dislike() {
		if (this.likes >= 1) {
			--this.likes;
		}
		return this;
	}
	
	/*
	* Retorna true si el post está marcado como destacado, false en caso contrario
	*/
	public boolean isFeatured() {
		return this.featured;
	}
	
	/*
	* Cambia el post del estado destacado a no destacado y viceversa. Retorna la
	instancia de Wallpost.
	*/
	public WallPost toggleFeatured() {
		this.featured = !this.featured;
		return this;
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */ 
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }    

}
