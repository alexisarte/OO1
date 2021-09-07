package ar.edu.unlp.oo1.ejercicio1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlp.oo1.ejercicio1.impl.WallPostImpl;

/**
 * A WallpostTest is a test class for testing the behavior of Wallpost
 * 
 * @author ramiro
 *
 */
public class WallPostTest {

  WallPost wallPost;
  
  WallPost coolPost;
  
  @Before
  public void setUp() throws Exception {
    wallPost = new WallPostImpl();
    coolPost = new WallPostImpl()
        .like()
        .like()
        .like()
        .like()
        .toggleFeatured();
  }

  @Test
  public void testDislike() {
    coolPost.dislike();
    assertEquals(3, coolPost.getLikes());
    coolPost.dislike().dislike();
    assertEquals(1, coolPost.getLikes());
    coolPost.dislike();
    assertEquals(0, coolPost.getLikes());
    coolPost.dislike();
    assertEquals(0, coolPost.getLikes());
  }
  
  @Test
  public void testFeatured() {
    assertFalse(wallPost.isFeatured());
  }

  @Test
  public void testLike() {
    assertEquals(0, wallPost.getLikes());
    wallPost.like();
    assertEquals(1, wallPost.getLikes());
    wallPost
      .like()
      .like()
      .like();
    assertEquals(4, wallPost.getLikes());
  }

  @Test
  public void testText() {
    final String hello = "Hello";
    wallPost.text(hello);
    assertEquals(hello, wallPost.getText());    
    
    final String bye = "Bye";
    wallPost.text(bye);
    assertEquals(bye, wallPost.getText());    
  }
  
  @Test
  public void testToggleFeatured() {
    assertTrue(wallPost.toggleFeatured().isFeatured());
    assertFalse(coolPost.toggleFeatured().isFeatured());
  }
  
  @Test
  public void testWallpost() {
    assertEquals(0, wallPost.getLikes());
  }
  
}

        
        