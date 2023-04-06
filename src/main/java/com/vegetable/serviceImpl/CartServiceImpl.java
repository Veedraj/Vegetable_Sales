package com.vegetable.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.entity.Cart;
import com.vegetable.entity.CartItem;
import com.vegetable.entity.Product;
import com.vegetable.exception.CartItemDoesNotExistsException;
import com.vegetable.exception.CartNotFoundException;
import com.vegetable.exception.InvalidCartItemDataException;
import com.vegetable.repository.CartItemRepository;
import com.vegetable.repository.CartRepository;
import com.vegetable.repository.ProductRepository;
import com.vegetable.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	  @Autowired
	    private CartRepository cartRepository;
	  
	  @Autowired
	    private CartItemRepository cartItemRepository;
	  
	  @Autowired
	   private ProductRepository productRepo;

	@Override
	public Cart getCartById(Long cartId) throws CartNotFoundException {
		try {
            return cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new CartNotFoundException("Cart id does not exists");
        }
	}

	@Override
    public Cart addToCart(Long cartId, Long productId) throws CartNotFoundException, InvalidCartItemDataException {
        Cart cart;
        try {
            cart = cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new CartNotFoundException("Cart id does not exists");
        }
        Product product = productRepo.findById(productId).get();
        List<CartItem> cartItems = cart.getCartItems();

        try {
            for (CartItem cI : cartItems) {
                if (cI.getCartItemName().equals(product.getProductName())) {
                    cI.setCartItemQuantity(cI.getCartItemQuantity() + 1);
                    cart.setCartItems(cartItems);
                    cart.setTotalAmount(cart.getTotalAmount() + cI.getCartItemPrice());
                    return cartRepository.save(cart);
                }
            }

            CartItem cartItem = new CartItem();
            cartItem.setCartItemName(product.getProductName());
            cartItem.setCartItemImage(product.getProductImage());
            cartItem.setCartItemPrice(product.getProductPrice());
            cartItem.setCartItemQuantity(1);
            cartItem.setCart(cart);

            cartItems.add(cartItem);
            cart.setCartItems(cartItems);
            cart.setTotalAmount(cart.getTotalAmount() + cartItem.getCartItemPrice());
            return cartRepository.save(cart);
        } catch (Exception e) {
            throw new InvalidCartItemDataException("Enter correct cart item data");
        }
    }

	@Override
    public Cart increaseQuantity(Long cartId, Long cartItemId) throws CartNotFoundException, CartItemDoesNotExistsException, InvalidCartItemDataException {
        Cart cart;
        try {
            cart = cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new CartNotFoundException("Cart id does not exists");
        }
        List<CartItem> cartItems = cart.getCartItems();
        try {
            for (CartItem cI : cartItems) {
                if (cI.getCartItemId() == cartItemId) {
                    cart.setTotalAmount(cart.getTotalAmount() + cI.getCartItemPrice());
                    cI.setCartItemQuantity(cI.getCartItemQuantity() + 1);
                    break;
                }
            }
        } catch (Exception e) {
            throw new CartItemDoesNotExistsException("Cart item does not exists");
        }
        cart.setCartItems(cartItems);
        return cartRepository.save(cart);
    }


	@Override
    public Cart removeFromCart(Long cartId, Long cartItemId) throws CartNotFoundException, CartItemDoesNotExistsException {
        Cart cart;
        try {
            cart = cartRepository.findById(cartId).get();
        } catch (Exception e) {
            throw new CartNotFoundException("Cart id does not exists");
        }
        List<CartItem> cartItems = cart.getCartItems();
        try {
            for (CartItem cI : cartItems) {
                if ((cI.getCartItemId() == cartItemId) && (cI.getCartItemQuantity() == 1)) {
                    cart.setTotalAmount(cart.getTotalAmount() - cI.getCartItemPrice());
                    cartItems.remove(cI);
                    cartItemRepository.deleteById(cartItemId);
                    break;
                }
                if ((cI.getCartItemId() == cartItemId) && (cI.getCartItemQuantity() > 1)) {
                    cart.setTotalAmount(cart.getTotalAmount() - cI.getCartItemPrice());
                    cI.setCartItemQuantity(cI.getCartItemQuantity() - 1);
                    break;
                }
            }
        } catch (Exception e) {
            throw new CartItemDoesNotExistsException("Cart item does not exists");
        }
        cart.setCartItems(cartItems);
        return cartRepository.save(cart);
    }


	@Override
    @Transactional
    public Cart removeAllFromCart(Long cartId) throws CartNotFoundException {
        try {
            Cart cart = cartRepository.findById(cartId).get();
            List<CartItem> cartItems = cart.getCartItems();
            cartItems.clear();
            cart.setCartItems(cartItems);
            cart.setTotalAmount(0.0);
            cartItemRepository.deleteAllByCart(cart);
            return cartRepository.save(cart);
        } catch (Exception e) {
            throw new CartNotFoundException("Cart id does not exists");
        }
    }

	@Override
	public Cart createCart() {
		Cart cart = new Cart(0l,0.0,new ArrayList<>());
		return this.cartRepository.save(cart);
	}

}
