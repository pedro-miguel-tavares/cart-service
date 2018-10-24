package com.labs.game.cartservice;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

  /*  @Test
    public void findByCustomer() {
        assertFalse("Not yet implemented", true);
    }
  */
  private CartService service;

    @Before
    public void setUp() {
        service = new CartService();
    }

    @Test
    public void findByCustomer_returnsMultipleProducts() {
        final CartItem[] cartItems = service.findByCustomer("111");
        assertThat(cartItems).isNotNull();
        assertThat(cartItems.length).isEqualTo(2);
        assertThat(extractProperty("product").from(cartItems)).contains("AAA", "BBB");

    }

    @Test
    public void findByCustomer_returnsSingleProduct() {
        final CartItem[] cartItems = service.findByCustomer("222");
        assertThat(cartItems).isNotNull();
        assertThat(cartItems.length).isEqualTo(1);
        assertThat(cartItems[0].getCustomer()).isEqualTo("222");

    }

    @Test
    public void findByCustomer_returnsEmptyArray() {
        final CartItem[] cartItems = service.findByCustomer("333");
        assertThat(cartItems).isNotNull();
        assertThat(cartItems.length).isEqualTo(0);
    }

}