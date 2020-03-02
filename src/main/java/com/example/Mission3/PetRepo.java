package com.example.Mission3;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class PetRepo {
    private JdbcTemplate jdbcTemplate;
    public PetRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /* create pet */
    public int createPet(Pet pet) {
        return
                jdbcTemplate.update
                        ("INSERT INTO pet(id, name, age, type) values(?,?,?,?)"
                                , pet.getId(), pet.getName(), pet.getAge(), pet.getType());
    }

    /* read */
    // row mapper - maps query results to java objects
    public class PetRowMapper implements RowMapper<Pet> {
        @Override
        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pet pet = new Pet();

            pet.setId(rs.getString("id"));
            pet.setName(rs.getString("name"));
            pet.setAge(rs.getInt("age"));
            pet.setType(rs.getString("type"));

            return pet;
        }
    }

    /* read all pet */
    public List<Pet> readAll() {
        return jdbcTemplate.query
                ("SELECT * FROM pet",
                        (rs, rowNum) ->
                                new Pet(
                                        rs.getString("id"),
                                        rs.getString("name"),
                                        rs.getInt("age"),
                                        rs.getString("type")
                                )
                );
    }

    /* read specific pet by id */
    public Pet readById(String id) {
        return jdbcTemplate.queryForObject
                ("SELECT * FROM pet WHERE id=?",
                        new Object[]{id},
                        new PetRowMapper());

    }

    /* read specific pet by id and name */
    public List<Pet> readByIdAndName(String id, String name) {
        return jdbcTemplate.query
                ("SELECT * FROM pet WHERE id = ? AND name = ?",
                        new Object[]{id, name},
                        new PetRowMapper());
    }

    /* count how many pets in the pet table */
    public int countPet() throws SQLException, Exception {
        int result = 1234;
        result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM pet", Integer.class);
        return result;
    }

    /* update pet */
    public int updatePet(String iden, Pet pet) throws SQLException {
        String sql = "UPDATE pet SET id =?, name =?, age=?, type=? WHERE id =?";
        return jdbcTemplate.update(sql, pet.getId(), pet.getName(), pet.getAge(), pet.getType(), iden);

    }

    /* delete pet */
    public int deletePet(String iden) throws SQLException {
        String sql = "DELETE FROM pet WHERE id=?";
        return jdbcTemplate.update(sql, iden);
    }

}
