package assesstment.test.rizkyazis.dao;

import assesstment.test.rizkyazis.dto.ProdukDto;
import assesstment.test.rizkyazis.entity.Produk;
import assesstment.test.rizkyazis.entity.Produsen;
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
public class ProdukDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Produk findId(Integer id) throws EmptyResultDataAccessException {
        String query = "select produk.id as id, produk.nama as nama, produk.jenis as jenis, produk.berat as berat, " +
                "produsen.id as prodId, produsen.nama as prodNama, produsen.kode as prodKode, produsen.alamat as prodAlamat " +
                "from produk " +
                "left join produsen on produk.produsen_id = produsen.id " +
                "where produk.id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Produk>() {
            @Override
            public Produk mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produk produk = new Produk();
                produk.setId(rs.getInt("id"));
                produk.setNama(rs.getString("nama"));
                produk.setJenis(rs.getString("jenis"));
                produk.setBerat(rs.getString("berat"));

                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("prodId"));
                produsen.setNama(rs.getString("prodNama"));
                produsen.setKode(rs.getString("prodKode"));
                produsen.setAlamat(rs.getString("prodAlamat"));

                produk.setProdusen(produsen);
                return produk;
            }
        });
    }

    public List<Produk> list() {
        String query = "select produk.id as id, produk.nama as nama, produk.jenis as jenis, produk.berat as berat, " +
                "produsen.id as prodId, produsen.nama as prodNama, produsen.kode as prodKode, produsen.alamat as prodAlamat " +
                "from produk " +
                "left join produsen on produk.produsen_id = produsen.id ";
        return jdbcTemplate.query(query, new RowMapper<Produk>() {
            @Override
            public Produk mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produk produk = new Produk();
                produk.setId(rs.getInt("id"));
                produk.setNama(rs.getString("nama"));
                produk.setJenis(rs.getString("jenis"));
                produk.setBerat(rs.getString("berat"));

                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("prodId"));
                produsen.setNama(rs.getString("prodNama"));
                produsen.setKode(rs.getString("prodKode"));
                produsen.setAlamat(rs.getString("prodAlamat"));

                produk.setProdusen(produsen);
                return produk;
            }
        });
    }

    public Integer insert(ProdukDto.New value) {
        String query = "insert into produk (nama,jenis,berat,produsen_id) " +
                "values " +
                "(:nama, :jenis, :berat, :produsen_id)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nama", value.getNama());
        map.addValue("jenis", value.getJenis());
        map.addValue("berat", value.getBerat());
        map.addValue("produsen_id", value.getProdusen().getId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, map, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void update(ProdukDto.Update value) {
        String query = "update produk set nama=:nama, " +
                "jenis=:jenis, berat=:berat, produsen_id=:produsen_id " +
                "where id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", value.getId());
        map.addValue("nama", value.getNama());
        map.addValue("jenis", value.getJenis());
        map.addValue("berat", value.getBerat());
        map.addValue("produsen_id", value.getProdusen().getId());
        jdbcTemplate.update(query, map);
    }

    public void delete(Integer id){
        String query = "delete from produk where id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }
}
