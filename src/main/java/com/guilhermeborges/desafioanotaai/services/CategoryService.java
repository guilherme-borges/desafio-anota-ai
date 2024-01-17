package com.guilhermeborges.desafioanotaai.services;

import com.guilhermeborges.desafioanotaai.domain.category.Category;
import com.guilhermeborges.desafioanotaai.domain.category.CategoryDTO;
import com.guilhermeborges.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.guilhermeborges.desafioanotaai.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);

        this.repository.save(newCategory);
        return newCategory;
    }


    public List<Category> getAll() {

        return this.repository.findAll();
    }

    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        if (!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if (!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.repository.save(category);

        return category;
    }

    public void delete(String id) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        this.repository.delete(category);
    }
}
