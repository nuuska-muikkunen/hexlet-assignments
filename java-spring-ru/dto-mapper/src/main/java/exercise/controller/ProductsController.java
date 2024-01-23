package exercise.controller;

import exercise.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import exercise.repository.ProductRepository;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> index() {
        return productRepository.findAll().stream()
                .map(p -> productMapper.map(p))
                .toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO show(@PathVariable long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found."));
        System.out.println("Name received from repository= " + product.getName());
        System.out.println("barcode received from repository= " + product.getBarcode());
        ProductDTO result = productMapper.map(product);
        System.out.println("Title set into DTO= " + result.getTitle());
        System.out.println("vendorCode set into DTO= " + result.getVendorCode());
        return result;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO productData) {
        var product = productMapper.map(productData);
        var result = productRepository.save(product);
        return productMapper.map(result);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@RequestBody ProductUpdateDTO productData, @PathVariable long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found."));
        System.out.println("Name received from repository= " + product.getName());
        System.out.println("barcode received from repository= " + product.getBarcode());
        System.out.println("cost received from repository= " + product.getCost());
        productMapper.update(productData, product);
        Product result = productRepository.save(product);
        System.out.println("Name after save= " + result.getName());
        System.out.println("barcode after save= " + result.getBarcode());
        System.out.println("cost after save= " + result.getCost());
        ProductDTO end = productMapper.map(result);
        System.out.println("Title set into DTO= " + end.getTitle());
        System.out.println("vendorCode set into DTO= " + end.getVendorCode());
        System.out.println("price set into DTO= " + end.getPrice());
        return end;
    }
    // END
}
