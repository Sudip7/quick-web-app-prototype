package demo.controller;

import demo.domain.ProductService;
import demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller provides the REST methods
 */
@Controller
public class ProductsController {

    // Let Spring DI inject the service for us
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome() {
    	System.out.println("in welcome page");
    	return "redirect:/welcome.html";
    }
    @RequestMapping(value="/api/products/", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts() {
        // Ask the data store for a list of products
        return productService.getProducts();
    }

}
