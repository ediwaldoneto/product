package br.com.api.product.repository.impl;

import br.com.api.product.model.Product;
import br.com.api.product.repository.ProductRepository;
import br.com.api.product.repository.sql.ProductQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public void insertProduct(Product product) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nome", product.getNome());
        parameterSource.addValue("marca", product.getMarca());
        jdbcTemplate.update(ProductQuerys.INSERT_PRODUCT, parameterSource);
    }

    @Override
    public void deleteProduct(Long productId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("productId", productId);
        jdbcTemplate.update(ProductQuerys.DELETE_PRODUCT, parameterSource);
    }

    @Override
    public void updateProduct(Product product) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("contractId", product.getId());
        parameterSource.addValue("nome", product.getNome());
        parameterSource.addValue("marca", product.getMarca());
        jdbcTemplate.update(ProductQuerys.UPDATE_PRODUCT, parameterSource);
    }

    @Override
    public Product findProduct(Long productId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("productId", productId);
        return jdbcTemplate.queryForObject(ProductQuerys.FIND_BY_ID, parameterSource, mapRow());
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(ProductQuerys.FIND_ALL_PRODUCT, mapRow());
    }

    private RowMapper<Product> mapRow() {
        return (rs, rowNum) -> {
            final Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setNome(rs.getString("nome"));
            product.setMarca(rs.getString("marca"));
            return product;
        };
    }
}
