package com.samadhan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samadhan.model.Product;
import com.samadhan.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		
		Product product=productRepo.findById(id).get();
		
		if(product!=null)
		{
			productRepo.delete(product);
			return "Product delete successfully";
		}
		return "Something Wrong on server";
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		
		Product oldproduct=productRepo.findById(id).get();
		
		oldproduct.setProductName(p.getProductName());
		
		oldproduct.setDescription(p.getDescription());;
		
		oldproduct.setPrice(p.getPrice());
		
		oldproduct.setStatus(p.getStatus());
		return productRepo.save(oldproduct);
	}

	
	
}
