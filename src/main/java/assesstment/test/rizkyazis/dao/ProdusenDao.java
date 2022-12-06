package assesstment.test.rizkyazis.dao;

import assesstment.test.rizkyazis.dto.ProdusenDto;
import assesstment.test.rizkyazis.entity.Produsen;
import assesstment.test.rizkyazis.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProdusenDao implements CrudRepository<Produsen, Integer> {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    ProdukRepository repo;

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

    public void delete(Integer id) {
        String query = "delete from produsen where id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }

    @Override
    public <S extends Produsen> S save(S entity) {
        return repo.save(entity);
    }

    @Override
    public <S extends Produsen> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Produsen> findById(Integer integer) {
        return repo.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Produsen> findAll() {
        return repo.findAll();
    }

    @Override
    public Iterable<Produsen> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Produsen entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Produsen> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
