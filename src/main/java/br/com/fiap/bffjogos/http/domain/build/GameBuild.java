package br.com.fiap.bffjogos.http.domain.build;

import br.com.fiap.bffjogos.gateway.model.GameModel;
import br.com.fiap.bffjogos.http.domain.request.GameRequest;
import br.com.fiap.bffjogos.http.domain.response.GameResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameBuild {

    public GameResponse build(GameModel model) {
        return new GameResponse(model);
    }
    public List<GameResponse> build(List<GameModel> games) {
        return games.stream().map(GameResponse::new).collect(Collectors.toList());
    }

    public GameModel parseToModel(GameModel m, GameRequest r) {
        return new GameModel(m.getId(), r);
    }

    public GameModel parseToModel(GameRequest request) {
        return new GameModel(request);
    }
}
