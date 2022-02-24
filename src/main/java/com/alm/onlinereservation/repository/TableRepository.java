package com.alm.onlinereservation.repository;

import com.alm.onlinereservation.model.Floor;
import com.alm.onlinereservation.model.Table;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<Table, String> {
}
