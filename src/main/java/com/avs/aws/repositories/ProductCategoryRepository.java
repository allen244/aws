package com.avs.aws.repositories;

import com.avs.aws.domain.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 5/6/16.
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
