import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sebas.lab.testing.GestionBiblioteca;

public class TestGB {
    private GestionBiblioteca gb = new GestionBiblioteca();
    @Before
    public void setUp() {
        gb =  new GestionBiblioteca();
    }
    @After
    public void tearDown() {
        gb = null;
    }
    @Test
    public void calcularDescuentoCero() {
        double precioBase = 100;
        double descuento = 0;
        Assert.assertEquals(precioBase,gb.calcularPrecioConDescuento(precioBase,descuento),0.001);
    }
    @Test
    public void calcularDescuentoCincuenta() {
        double precioBase = 100;
        double descuento = 50;
        Assert.assertEquals(precioBase/2,gb.calcularPrecioConDescuento(precioBase,descuento),0.001);
    }
    @Test
    public void calcularDescuentoCein() {
        double precioBase = 100;
        double descuento = 100;
        Assert.assertEquals(0,gb.calcularPrecioConDescuento(precioBase,descuento),0.001);
    }
    // Esta disponible
    @Test
    public void libroNoDisponible() {
        Assert.assertFalse(gb.estaDisponible("Harry Potter"));
    }
    @Test
    public void libroDisponible(){
        gb.agregarLibro("Harry Potter");
        Assert.assertTrue(gb.estaDisponible("Harry Potter"));
    }
    @Test
    public void libroNull(){
        Assert.assertFalse(gb.estaDisponible(null));
    }
    // Agrwegar Libro
    @Test
    public void agregarLibroNull(){
        Assert.assertFalse(gb.agregarLibro(null));
    }
    @Test
    public void agregarLibroDuplicado(){
        gb.agregarLibro("Harry Potter");
        Assert.assertFalse(gb.agregarLibro("Harry Potter"));
    }
    // CDategoria Lector
    @Test
    public void lectorPrincipiante(){
        Assert.assertEquals("Principiante",gb.obtenerCategoriaLector(0));
    }
    @Test
    public void lectorIntermedio(){
        Assert.assertEquals("Intermedio",gb.obtenerCategoriaLector(5));
    }
    @Test
    public void lectorAvanzado(){
        Assert.assertEquals("Avanzado",gb.obtenerCategoriaLector(25));
    }
    // Obtener libros disponibles
    @Test
    public void nuncaEsNulo(){
        Assert.assertNotNull(gb.obtenerLibrosDisponibles());
    }
    @Test
    public void listaVacia() {
        Assert.assertTrue(gb.obtenerLibrosDisponibles().isEmpty());
    }
}
