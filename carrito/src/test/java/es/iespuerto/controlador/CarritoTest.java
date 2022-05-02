package es.iespuerto.controlador;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuerto.model.Producto;

public class CarritoTest {
    Map<Producto, Integer> productosCompradosTest = new TreeMap<>();
    Carrito carrito;
    Producto producto = new Producto("10", "Lechuga", 10, 11, 10);

    @BeforeEach
    public void before() {
        if (carrito == null) {
            carrito = new Carrito();
        }
    }

    @BeforeEach
    public void addProductosComprados() {
        productosCompradosTest.put(producto, 10);
    }

    @Test
    public void constructorTest() {
        Assertions.assertNotNull(carrito, "El objeto carrito no puede ser NULO");
    }

    @Test
    public void addTest() {
        carrito.add(producto, 10);

        Assertions.assertEquals(carrito.getProductosComprados(), productosCompradosTest,
                "El metodo Carrito.add no esta bien hecho");
    }
}
