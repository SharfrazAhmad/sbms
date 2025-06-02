package in.ashokit.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Product;

@RestController
public class ProductRESTController {

	@GetMapping(value = "/product", produces = {"application/xml","application/json"})
	public ResponseEntity<Product> getProducts() {
		Product product = new Product(1000, "kjb", 1002.1);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProduct(){
		Product product1 = new Product(100, "sbms1", 100.00);
		Product product2 = new Product(101, "sbms2", 200.00);
		Product product3 = new Product(102, "sbms3", 300.00);
		List<Product> list = Arrays.asList(product1,product2,product3);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
