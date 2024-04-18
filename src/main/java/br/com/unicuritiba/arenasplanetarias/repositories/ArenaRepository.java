package br.com.unicuritiba.arenasplanetarias.repositories;

import br.com.unicuritiba.arenasplanetarias.models.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Long> {

}
