package com.shopette.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dami Olawoyin-Yussuf
 * @project backend
 * @created 08/01/2025
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "items")
public class Item
{
    @Id
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private double price;
}
