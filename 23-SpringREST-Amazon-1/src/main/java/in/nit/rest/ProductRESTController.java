package in.nit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.nit.binding.ProductInfo;
import in.nit.binding.ProductStatus;

@RestController
public class ProductRESTController {

	@PostMapping("/product")
	public ResponseEntity<ProductStatus> getStatus(@RequestBody ProductInfo productInfo) {
		// logic to store product in database

		ProductStatus status = new ProductStatus(productInfo.getPName(), "pink", "cancelled");
		System.out.println(productInfo);
		return new ResponseEntity<ProductStatus>(status, HttpStatus.OK);
	}

}
