package br.com.fiap.bffjogos.http.v1;

import br.com.fiap.bffjogos.http.domain.request.GameRequest;
import br.com.fiap.bffjogos.http.domain.response.GameResponse;
import br.com.fiap.bffjogos.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/game")
@CrossOrigin
public class GameController {


    @Autowired
    private GameService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void save(@Valid @RequestBody GameRequest request) {
        log.info("****[CONTROLLER - GameController - save()]****");
        service.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameResponse> findAll() {
        log.info("****[CONTROLLER - GameController - findAll()]****");
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameResponse findById(@RequestParam("id") @DecimalMin("1") @NotNull Long id) {
        log.info("****[CONTROLLER - GameController - findById()]****");
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@RequestParam("id") @DecimalMin("1") @NotNull Long id) {
        log.info("****[CONTROLLER - GameController - deleteById()]****");
        service.deleteById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(
            @RequestParam("id") @DecimalMin("1") @NotNull Long id,
            @Valid @RequestBody GameRequest request
    ) {
        log.info("****[CONTROLLER - GameController - deleteById()]****");
        service.update(id, request);
    }
}
