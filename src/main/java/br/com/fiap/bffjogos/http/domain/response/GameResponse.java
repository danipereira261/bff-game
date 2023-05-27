package br.com.fiap.bffjogos.http.domain.response;

import br.com.fiap.bffjogos.gateway.model.GameModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameResponse {

    private Long id;
    private String name;
    private String platafomr;
    private String urlLabel;
    private LocalDate releaseDate;
    private BigDecimal releasePrice;
    private LocalDateTime insertDate;

    public GameResponse(GameModel m) {
        this.id = m.getId();
        this.name = m.getName();
        this.platafomr = m.getPlatafomr();
        this.urlLabel = m.getUrlLabel();
        this.releaseDate = m.getReleaseDate();
        this.releasePrice = m.getReleasePrice();
        this.insertDate = m.getInsertDate();
    }
}
