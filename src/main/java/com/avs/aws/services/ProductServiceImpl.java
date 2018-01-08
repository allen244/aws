package com.avs.aws.services;


import com.avs.aws.domain.Product;
import com.avs.aws.repositories.ProductRepository;
import com.avs.aws.services.jms.JmsTextMessageService;
import com.avs.aws.utils.AwsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 1/26/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private JmsTextMessageService jmsTextMessageService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setJmsTextMessageService(JmsTextMessageService jmsTextMessageService) {
        this.jmsTextMessageService = jmsTextMessageService;
    }

    @Override
    public Product getProduct(Integer id) {
        jmsTextMessageService.sendTextMessage("Fetching Product ID: " + id);
        Optional<Product> optionalProduct = productRepository.findById(id);

        return optionalProduct.get();
    }

    @Override
    public List<Product> listProducts() {
        List<Product> target = new ArrayList<>();
        List<Product> test = new ArrayList<>();
        jmsTextMessageService.sendTextMessage("Listing Products");
        productRepository.findAll().iterator().forEachRemaining(target::add);

        test = AwsUtil.toList(productRepository.findAll());
        return target;


    }


}
