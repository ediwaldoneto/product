package br.com.api.product.repository.impl;

import br.com.api.product.model.Product;
import br.com.api.product.repository.ProductRepository;
import br.com.api.product.repository.sql.ProductQuerys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Logger logger = LoggerFactory.getLogger("logger");

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public void insertProduct(Product product) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nome", product.getNome());
        parameterSource.addValue("codigo", product.getCodigo());
        jdbcTemplate.update(ProductQuerys.INSERT_PRODUCT, parameterSource);
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public void updateProduct(Long productId) {

    }

    @Override
    public Product findProduct(Long productId) {
        try {
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("productId", productId);
            return jdbcTemplate.queryForObject(ProductQuerys.FIND_BY_ID, parameterSource, mapRow());
        } catch (Exception e) {
            logger.info("Product not found: {} ", productId);
            return null;
        }
    }

    private RowMapper<Product> mapRow() {
        return (rs, rowNum) -> {
            final Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setNome(rs.getString("nome"));
            product.setCodigo(rs.getInt("codigo"));
            return product;
        };
    }
}
