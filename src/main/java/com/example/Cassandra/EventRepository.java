package com.example.Cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CassandraRepository<Event, Long> {
    //
}
