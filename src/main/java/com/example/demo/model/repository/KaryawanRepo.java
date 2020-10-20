package com.example.demo.model.repository;

import com.example.demo.model.entity.Karyawan;
import org.springframework.data.repository.CrudRepository;

public interface KaryawanRepo extends CrudRepository<Karyawan, Integer> {

}
