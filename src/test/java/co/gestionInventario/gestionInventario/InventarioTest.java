package co.gestionInventario.gestionInventario;

import model.Inventario;
import model.Producto;
import model.bussinesException.BussinesException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InventarioTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public  void  crearProductoConCantidadCero()throws Exception {
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.CANTIDAD_PRODUCTO_REQUERIDA);
        Inventario inventario=new Inventario.inventarioBuilder()
                .setProducto(new Producto(1,"arroz",true,0))
                .build();
    }
    @Test
    public  void  crearObjetoConCantidadNegativaProducto()throws Exception {
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.CANTIDAD_NEGATIVA_PRODUCTO);
        Inventario inventario=new Inventario.inventarioBuilder()
                .setProducto(new Producto(1,"arroz",true,-1))
                .build();
    }
    @Test
    public void cantidadInventarioVacio() throws Exception{
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.CANTIDAD_INVENTARIO_REQUERIDA);
        Inventario inventario= new Inventario.inventarioBuilder()
                .setIdInventario(1)
                .setProducto(new Producto( 1, "Papas", true, 5))
                .build();

    }

    @Test
    public void cantidadInventarioNegativa() throws Exception{
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.CANTIDAD_NEGATIVA_IVENTARIO);
        Inventario inventario= new Inventario.inventarioBuilder()
                .setIdInventario(1)
                .setProducto(new Producto( 1, "Papas", true, 5))
                .setCantidadInventario(-6)
                .build();

    }
    @Test
    public void tansaccionInventario() throws Exception{
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.CANTIDAD_INVENTARIO_ES_MAYOR_AL_EXISTENTE);
        Inventario inventario= new Inventario.inventarioBuilder()
                .setIdInventario(1)
                .setProducto(new Producto( 1, "Papas", true, 5))
                .setCantidadInventario(6)
                .build();

    }
    @Test
    public void validarLimiteSuperiorVacio() throws Exception {
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.CANTIDAD_LIMITE_SUPERIOR_REQUERIDA);
        Inventario inventario = new Inventario.inventarioBuilder()
                .setCantidadInventario(1)
                .setLimiteInferio(2)
                .setProducto(new Producto(1, "arroz", true,12))
                .build();
    }


    @Test
    public void validarLimiteSuperior() throws Exception {
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.LIMITE_SUPERIOR_ALCANZADO);
        Inventario inventario = new Inventario.inventarioBuilder()
                .setLimiteSuperior(30)
                .setLimiteInferio(2)
                .setProducto(new Producto(1, "arroz", true,32))
                .setCantidadInventario(1)
                .build();
    }
    @Test
    public void validarLimiteInferiorVacio() throws Exception {
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.CANTIDAD_LIMITE_INFERIOR_REQUERIDA);
        Inventario inventario = new Inventario.inventarioBuilder()
                .setCantidadInventario(1)
                .setProducto(new Producto(1, "arroz", true,12))
                .setLimiteSuperior(340)
                .build();
    }


    @Test
    public void validarLimiteInferior() throws Exception {
        exception.expect(BussinesException.class);
        exception.expectMessage(Inventario.LIMITE_INFERIOR_ALCANZADO);
        Inventario inventario = new Inventario.inventarioBuilder()
                .setLimiteInferio(3)
                .setCantidadInventario(1)
                .setProducto(new Producto(1, "arroz", true,2))

                .build();
    }

    @Test
    public void retirarProducto() throws Exception {

        Inventario inventario = new Inventario.inventarioBuilder()
                .setLimiteSuperior(30)
                .setLimiteInferio(2)
                .setProducto(new Producto(1, "arroz", true ,15))
                .setCantidadInventario(5)

                .build();

        int valorReal = inventario.retirarProducto();
        int valorEsperado = 10;
        Assert.assertEquals(valorEsperado, valorReal, 1);
    }

    @Test
    public void ingresarProducto() throws Exception {


        Inventario inventario = new Inventario.inventarioBuilder()
                .setLimiteSuperior(30)
                .setLimiteInferio(2)
                .setProducto(new Producto(1, "arroz",true, 7))
                .setCantidadInventario(5)
                .build();

        int valorReal = inventario.ingresarProducto();
        int valorEsperado = 12;
        Assert.assertEquals(valorEsperado, valorReal, 1);

    }






}
