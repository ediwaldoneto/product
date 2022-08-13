package br.com.api.product.repository.impl;

import br.com.api.product.model.Product;
import br.com.api.product.repository.ProductRepository;
import br.com.api.product.repository.sql.ProductQuerys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public void insertProduct(Product product) {

    }

    @Override
    public void deleteProduct(int productId) {

    }

    @Override
    public void updateProduct(int productId) {

    }

    @Override
    public Product findProduct(int productId) {
        try {
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("productId", productId);
            return jdbcTemplate.queryForObject(ProductQuerys.FIND_BY_ID, parameterSource ,mapRow());
        } catch (EmptyResultDataAccessException e) {
            logger.info("Not found id {} ", productId);
            throw new EmptyResultDataAccessException("Not found id ", productId);
        }
    }

    private RowMapper<Product> mapRow(){
        return (rs, rowNum) -> {
            final Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setNome(rs.getString("nome"));
            product.setCodigo(rs.getInt("codigo"));
            return product;
        };
    }
}
