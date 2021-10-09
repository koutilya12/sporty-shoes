package com.ecommerce.sportyshoes.helpers;

import com.ecommerce.sportyshoes.entity.Cart;
import com.ecommerce.sportyshoes.entity.Order;
import com.ecommerce.sportyshoes.entity.OrderSearchCriteria;
import com.ecommerce.sportyshoes.entity.Product;
import com.ecommerce.sportyshoes.entity.ProductStock;
import com.ecommerce.sportyshoes.entity.User;

public class Validator {

	public static String validateUser(User user) {
        if(user == null) {
        	return "User is empty";
        }
        if(user.getUserName() == null || user.getUserName().isBlank()) {
        	return "User Name is Invalid";
        }
        if(user.getMobileNum() == null || user.getMobileNum().isBlank()) {
        	return "Invalid Mobile Number"; 
        }
        if(user.getUserType() == null) {
        	return "Invalid User Type";
        }
        if(user.getStatus() == null) {
        	return "Invalid User Status";
        } 
		return null;
	}

	public static String validateLogin(User user) {
        if(user == null) {
        	return "User is empty";
        }
        if(user.getEmailId() == null || user.getEmailId().isEmpty()) {
        	return "User email is Invalid";
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()) {
        	return "password is empty"; 
        }
		return null;
	}

	public static String validateGetUsers(User user) {
		if(user == null) {
			return "Invalid user";
		}
		return null;
	}
	
	public static String validateProduct(Product product) {
		if(product == null) {
        	return "product is empty";
        }
        if(product.getProductName() == null || product.getProductName().isBlank()) {
        	return "Product Name is Invalid";
        }
        if(product.getBrand() == null || product.getBrand().getBrandName().isEmpty()) {
        	return "Invalid Brand"; 
        }
        if(product.getSize() == null) {
        	return "Invalid Size";
        }
        if(product.getCategory() == null || product.getCategory().getCategoryName().isEmpty()) {
        	return "Invalid Category";
        }
        if(product.getStatus() == null) {
        	return "Invalid status";
        }
		return null;
	}

	public static String validateProductStock(ProductStock productStock) {
		if(productStock == null){ 
			return "productstock is null";
		}
		if(productStock == null || productStock.getProduct() == null) {
			return "Invalid product/ product Id";
		}
		if(productStock.getStock() == null) {
			return "Stock not found";
		}
		if(productStock.getPrice() == null) {
			return "price invalid";
		}
		return null;
	}
	
	public static String validateGetProduct(Product product) {
		if(product == null) {
        	return "product is empty";
        }
        return null;
	}

	public static String validateCart(Cart cart) {
		if(cart == null) {
			return "Invalid cart";
		}
		if(cart.getUser() == null || cart.getUser().getUserId() == null) {
			return "Invalid userId";
		}
		if(cart.getTotPrice() == null) {
			return "Invalid price";
		}
		if(cart.getTotQuantity() == null) {
			return "Invalid quantity";
		}
		return null;
	}

	public static String validateUserId(Long userId) {
		if(userId == null) {
			return "Invalid userId";
		}
		return null;
	}

	public static String validateCartId(Long cartId) {
		if(cartId == null) {
			return "Invalid cart Id";
		}
		return null;
	}

	public static String validateSaveOrder(Order order) {
		if(order == null) {
			return "Invalid order";
		}
		if(order.getTotPrice() == null) {
			return "Invalid total price";
		}
		if(order.getTotQuantity() == null) {
			return "Invalid total quantity";
		}
		if(order.getStatus() == null) {
			return "Invalid status";
		}
		if(order.getBookingTime() == null) {
			return "Invalid booking time";
		}
		if(order.getOrderDetails() == null) {
			return "Invalid order details";
		}
		if(order.getTotQuantity() != order.getOrderDetails().size()) {
			return "error in order details size";
		}
		if(order.getOrderDetails().get(0) != null) {
			for(int i=0; i < order.getOrderDetails().size(); i++) {
				if(order.getOrderDetails().get(i).getProductStock().getSkuId() == null) {
					return "Invalid product stock id";
				}
			 	if(order.getOrderDetails().get(i).getQuantity() == null) {
					return "Invalid order details - quantity";
				}
			}
		} else {
			return "Invalid order details";
		}
		return null; 
	}

	public static String validateGetOrder(OrderSearchCriteria orderSearchCriteria) {
		if(orderSearchCriteria == null) {
			return "Invalid order search";
		}
		return null;
	}
}
