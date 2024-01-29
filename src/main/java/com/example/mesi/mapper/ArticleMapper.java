package com.example.mesi.mapper;

import com.example.mesi.dto.ArticleDto;
import com.example.mesi.entity.Article;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ArticleMapper {
    ArticleDto toArticleDto(Article article);
    Article toArticle(ArticleDto articleDto);
    List<ArticleDto> toArticleDtoList(List<Article> articleList);
}
