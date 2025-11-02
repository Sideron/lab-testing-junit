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
        Assert.assertNotNull(gb.obtenerLibrosDisponibles());
    }

}
