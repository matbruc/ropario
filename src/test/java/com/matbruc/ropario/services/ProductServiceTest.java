package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Product;
import com.matbruc.ropario.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProductGet() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.getOne(product.getId())).thenReturn(product);

        Product prod = productService.getProductById(product.getId());
        assertThat(prod.getId(), is(1L));
    }

    @Test
    public void testProductGetAll() {
        List<Product> list = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1L);
        list.add(product1);
        Product product2 = new Product();
        product2.setId(2L);
        list.add(product2);

        when(productRepository.findAll()).thenReturn(list);

        List<Product> testList = productService.getAllProducts();
        assertThat(testList, is(list));

    }

    @Test
    public void testProductAdd() {
        Product product = new Product();
        product.setId(2L);
        product.setDescription("Test");




        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.addProduct(product);

        assertThat(2L, is(result.getId()));
        assertThat("Test", is(result.getDescription()));

    }

    @Test
    public void testProductUpdate() {
        Product product = new Product();
        product.setId(2L);
        product.setDescription("Test");
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.updateProduct(product);

        assertThat(2L, is(result.getId()));
        assertThat("Test", is(result.getDescription()));

    }


}
