package com.example.mesi.service;

import com.example.mesi.entity.Article;
import com.example.mesi.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> findAllArticles() {
        return this.articleRepository.findAll();
    }

    public Article findArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }
}
