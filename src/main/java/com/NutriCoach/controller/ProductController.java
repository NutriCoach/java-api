package com.NutriCoach.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.NutriCoach.entities.Product;
import com.NutriCoach.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productos")
@Api(value="REST informacion de productos")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation("Registro de productos")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveProduct(@Valid @RequestBody Product product){
		try {
			Product pro =new Product();
			pro=productService.save(product);
			URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pro.getId()).toUri(); 
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Listado de productos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> fetchProducts(){
		try {
			List<Product> products = new ArrayList<>();
			products= productService.findAll();
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener producto por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> fetchProduct(@PathVariable("id") Integer id) {

		try {
			Optional<Product> product = productService.findById(id);

			if (!product.isPresent()) {
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar producto")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Product product) {
		try {
			productService.update(product);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar producto por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Product> product = productService.findById(id);

			if (!product.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				productService.deleteById(id);
				return new ResponseEntity<>("Producto se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
