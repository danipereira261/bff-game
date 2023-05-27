package br.com.fiap.bffjogos.gateway.repository;

import br.com.fiap.bffjogos.gateway.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}
