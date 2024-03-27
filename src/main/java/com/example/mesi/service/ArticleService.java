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
    private final UserService userService;

    public List<Article> findAllArticles() {
        return this.articleRepository.findAll();
    }

    public Article findArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public boolean deleteArticleById(Long id) {
        Optional<Article> articleToDelete = articleRepository.findById(id);
        if (articleToDelete.isPresent()) {
            articleRepository.delete(articleToDelete.get());
            return true;
        } else {
            return false;
        }
    }

    public Article saveOrUpdateArticle(Article article, String vendeur) {
            article.setVendeur(userService.getVendeur(vendeur));
            return articleRepository.save(article);
    }
}
