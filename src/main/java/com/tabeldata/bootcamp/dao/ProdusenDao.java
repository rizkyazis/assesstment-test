package com.tabeldata.bootcamp.dao;

import com.tabeldata.bootcamp.dto.ProdusenDto;
import com.tabeldata.bootcamp.entity.Produk;
import com.tabeldata.bootcamp.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProdusenDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Produsen findId(Integer id) throws EmptyResultDataAccessException {
        String query = "select id, nama, kode, alamat " +
                "from produsen " +
                "where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Produsen>() {
            @Override
            public Produsen mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("id"));
                produsen.setNama(rs.getString("nama"));
                produsen.setKode(rs.getString("kode"));
                produsen.setAlamat(rs.getString("alamat"));
                return produsen;
            }
        });
    }

    public List<Produsen> list() {
        String query = "select id, nama, kode, alamat " +
                "from produsen ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(query, new RowMapper<Produsen>() {
            @Override
            public Produsen mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("id"));
                produsen.setNama(rs.getString("nama"));
                produsen.setKode(rs.getString("kode"));
                produsen.setAlamat(rs.getString("alamat"));
                return produsen;
            }
        });
    }

    public Integer insert(ProdusenDto.New value) {
        String query = "insert into produsen (nama,kode,alamat) " +
                "values " +
                "(:nama, :kode, :alamat)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nama", value.getNama());
        map.addValue("kode", value.getKode());
        map.addValue("alamat", value.getAlamat());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, map, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void update(ProdusenDto.Update value) {
        String query = "update produsen set nama=:nama, " +
                "kode=:kode, alamat=:alamat " +
                "where id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", value.getId());
        map.addValue("nama", value.getNama());
        map.addValue("kode", value.getKode());
        map.addValue("alamat", value.getAlamat());
        jdbcTemplate.update(query, map);
    }

    public void delete(Integer id){
        String query = "delete from produsen where id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }
}
