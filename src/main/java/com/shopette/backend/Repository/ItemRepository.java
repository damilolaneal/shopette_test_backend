package com.shopette.backend.Repository;

import com.shopette.backend.Model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Dami Olawoyin-Yussuf
 * @project backend
 * @created 08/01/2025
 * @description
 */
public interface ItemRepository extends MongoRepository<Item, String>
{
}
