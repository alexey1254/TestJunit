package es.iespuerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductoTest {

    public static final String CODIGO = "codigo";
    public static final String DESCRIPCION = "descripcion";
    public static final double PRECIO_COMPRA = 1;
    public static final double PRECIO_VENTA = 1;
    public static final int STOCK = 1;
    Producto producto;

    @BeforeEach
    public void before() {
        if (producto == null) {
            producto = new Producto(CODIGO, DESCRIPCION,
                    PRECIO_COMPRA,PRECIO_VENTA,STOCK);
        }
    }

    @Test
    public void constructorTest() {
       Assertions.assertNotNull(producto, "El objeto producto no puede ser NULO");
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(producto.toString(),"La respuesta es nula");
        Assertions.assertTrue(producto.toString().contains(CODIGO),"No contiene el codigo");
        Assertions.assertTrue(producto.toString().contains(DESCRIPCION),"No contiene el descripcion");
    }
    
    @Test
    public void changeStockTest(){
        producto.changeStock(2);
        producto.getStock();
        Assertions.assertEquals(3, producto.getStock(),"El stock no es el esperado");
    }

    @Test
    public void gettersTest(){
        Assertions.assertEquals(DESCRIPCION,producto.getDescripcion(),"La descripcion no es la esperada");
        Assertions.assertEquals(CODIGO,producto.getCodigo(),"El codigo no es el esperado");
        Assertions.assertEquals(PRECIO_VENTA,producto.getPrecioVenta(),"El precio de venta no es el esperado");
    }
    
    @Test
    public void compareToTest(){
        Producto comparar = new Producto(CODIGO, "", 2, 1, 16);
        Assertions.assertTrue(producto.compareTo(comparar) == 0, "Los objetos no son iguales");
    }

    @Test
    public void setStockTest(){
        producto.setStock(5);
        Assertions.assertEquals(5, producto.getStock(), "El setter de stock no está bien");
    }

    @Test
    public void compareToFalseTest(){
        Producto comparar = new Producto("CODIGO_2", "", 2, 1, 16);
        Assertions.assertTrue(producto.compareTo(comparar) != 1, "Los objetos no son iguales");
    }
}
