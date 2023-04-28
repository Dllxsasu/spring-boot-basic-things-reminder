package com.example.paging.pruebas;

import com.example.paging.*;
import com.example.paging.producto.Producto;
import com.example.paging.producto.ProductoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class practicaTest{
//Ejercicio JUnit: Crea una clase de prueba para una función que sume dos números enteros. Verifica que la suma es correcta para diferentes pares de números.{
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    ClienteRepository clienteRepository;


    @Test
    @DisplayName("verificar si suma")
    public void verificarSuma(){
        int a =1, b=2;
        int suma = a+b;
        Assertions.assertThat(suma).isEqualTo(3);
    }
    //Ejercicio @DataJpaTest: Crea una entidad Producto con las propiedades id (clave primaria), nombre, precio y stock. Crea un repositorio para la entidad Producto que incluya un método para buscar productos por nombre. Utiliza la anotación @DataJpaTest para crear una prueba de integración que guarde algunos productos en la base de datos y luego busque productos por nombre. Verifica que la lista de productos encontrados contiene los productos correctos.
    @Test
    @DisplayName("verificar busqueda")
    public void findByApellidoTest(){

        Persona per = new Persona(1L,"nombree","luk");
        personaRepository.saveAndFlush(per);

        List<Persona> pers = personaRepository.findByApellido("luk");

        Assertions.assertThat(pers.get(0)).isEqualTo(per);

    }

    //Ejercicio @DataJpaTest: Crea una entidad Producto con las propiedades id (clave primaria), nombre, precio y stock. Crea un repositorio para la entidad Producto que incluya un método para buscar productos por nombre. Utiliza la anotación @DataJpaTest para crear una prueba de integración que guarde algunos productos en la base de datos y luego busque productos por nombre. Verifica que la lista de productos encontrados contiene los productos correctos.
    @Test
    @DisplayName("Verificar que guarde y busque producto by nombre")
    public void searchAndSaveProductTest(){
        Producto producto = Producto.builder().
                precio(1)
                .nombre("a")
                .stock(100)
                .build();

        productoRepository.save(producto);
        Optional<Producto> obj = productoRepository.findByNombre("a");

        Assertions.assertThat(obj.isPresent()).isEqualTo(true); //Si funciona el buscar
        Assertions.assertThat(obj.get().getNombre()).isEqualTo(producto.getNombre()); //Se encontro el mismo que se busco


    }


    //Ejercicio JUnit: Crea una clase de prueba para una función que calcule el promedio de una lista de números. Verifica que el promedio es correcto para diferentes listas de números.
    @Test
    @DisplayName("provar que el avg de matti es correct")
    public void avgTest(){
        //When
        List<Integer> nums = List.of(1,1,1,1);
        int expected =1;
        //Then
       Assertions.assertThat(mati.avg(nums)).isEqualTo(expected);


    }


    //Ejercicio @DataJpaTest: Crea una entidad Cliente con las propiedades id (clave primaria), nombre y apellido. Crea un repositorio para la entidad Cliente que incluya un método para buscar clientes por apellido. Utiliza la anotación @DataJpaTest para crear una prueba de integración que guarde algunos clientes en la base de datos y luego busque clientes por apellido. Verifica que la lista de clientes encontrados contiene los clientes correctos.

    @Test
    @DisplayName("test save and findByNombre cliente")
    public void saveAndFindByNombre(){
        //When
        Cliente client = Cliente.builder()
                .apellido("a")
                .nombre("jorgue")
                .build();

        clienteRepository.saveAndFlush(client);
        Optional<Cliente> cliente = clienteRepository.findByApellido("a");
        //then
        Assertions.assertThat(cliente.isPresent()).isEqualTo(true); //Existe
        Assertions.assertThat(cliente.get().getNombre()).isEqualTo(client.getNombre());

    }
}


