package com.example.mesi.mapper;

import com.example.mesi.dto.ArticleDto;
import com.example.mesi.entity.Article;
import com.example.mesi.entity.User;
import com.example.mesi.repository.UserRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ArticleMapper {

    @Autowired
    private UserRepository userRepository;

    @Mapping(target = "vendeur", expression = "java(article.getVendeur().getLogin())")
    public abstract ArticleDto toArticleDto(Article article);

    @Mapping(target = "vendeur", ignore = true)
    public abstract Article toArticle(ArticleDto articleDto);

    public abstract List<ArticleDto> toArticleDtoList(List<Article> articles);
}