package br.com.fiap.bffjogos.service;

import br.com.fiap.bffjogos.exeption.GameNotFoundExeption;
import br.com.fiap.bffjogos.gateway.model.GameModel;
import br.com.fiap.bffjogos.gateway.repository.GameRepository;
import br.com.fiap.bffjogos.http.domain.build.GameBuild;
import br.com.fiap.bffjogos.http.domain.request.GameRequest;
import br.com.fiap.bffjogos.http.domain.response.GameResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Autowired
    private GameBuild gameBuild;

    public void save(GameRequest request) {
        log.info("****[SERVICE - GameService - save()]****");
        repository.save(gameBuild.parseToModel(request));
    }

    public void deleteById(Long id) {
        log.info("****[SERVICE - GameService - deleteById()]****");
        Optional<GameModel> optionalGame = repository.findById(id);
        if (optionalGame.isPresent()) {
            repository.deleteById(optionalGame.get().getId());
        } else {
            throw new GameNotFoundExeption();
        }
    }

    public void update(Long id, GameRequest request) {
        log.info("****[SERVICE - GameService - update()]****");
        Optional<GameModel> optionalGame = repository.findById(id);
        if (optionalGame.isPresent()) {
            repository.save(gameBuild.parseToModel(optionalGame.get(), request));
        } else {
            throw new GameNotFoundExeption();
        }
    }

    public GameResponse findById(Long id) {
        log.info("****[SERVICE - GameService - findById()]****");
        Optional<GameModel> optionalGame = repository.findById(id);
        if (optionalGame.isPresent()) {
            return gameBuild.build(optionalGame.get());
        } else {
            throw new GameNotFoundExeption();
        }
    }

    public List<GameResponse> findAll() {
        log.info("****[SERVICE - GameService - findById()]****");
        return gameBuild.build(repository.findAll());
    }
}
