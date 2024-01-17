package com.guilhermeborges.desafioanotaai.domain.category;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryDTO categoryData) {

        this.title = categoryData.title();
        this.description = categoryData.description();
        this.ownerId = categoryData.ownerId();
    }
}
