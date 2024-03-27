package com.example.mesi.controller;

import com.example.mesi.dto.ArticleDto;
import com.example.mesi.mapper.ArticleMapper;
import com.example.mesi.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @GetMapping("/all")
    public ResponseEntity<List<ArticleDto>> findAllArticles() {
        return ResponseEntity.ok(
                articleMapper.toArticleDtoList(
                        articleService.findAllArticles()
                )
        );
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDto> findArticleById(@PathVariable String articleId) {
        return ResponseEntity.ok(
                articleMapper.toArticleDto(
                        articleService.findArticleById(
                                Long.valueOf(articleId)
                        )
                )
        );
    }

    @PostMapping("/save")
    public ResponseEntity<ArticleDto> saveOrUpdateArticle(@RequestBody ArticleDto articleDto) {
        return ResponseEntity.ok(
                articleMapper.toArticleDto(
                        articleService.saveOrUpdateArticle(
                                articleMapper.toArticle(articleDto),
                                articleDto.getVendeur()
                        )
                )
        );
    }


    @DeleteMapping("/{articleId}")
    public ResponseEntity<Boolean> deleteArticleById(@PathVariable Long articleId) {
        return ResponseEntity.ok(
                articleService.deleteArticleById(articleId)
        );
    }
}
