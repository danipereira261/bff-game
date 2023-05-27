package br.com.fiap.bffjogos.gateway.model;

import br.com.fiap.bffjogos.http.domain.request.GameRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_GAME")
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String platafomr;
    private String urlLabel;
    private LocalDate releaseDate;
    private BigDecimal releasePrice;
    private LocalDateTime insertDate;

    public GameModel(Long id, GameRequest r) {
        this.id = id;
        this.name = r.getName();
        this.platafomr = r.getPlatafomr();
        this.urlLabel = r.getUrlLabel();
        this.releaseDate = r.getReleaseDate();
        this.releasePrice = r.getReleasePrice();
    }

    public GameModel(GameRequest r) {
        this.name = r.getName();
        this.platafomr = r.getPlatafomr();
        this.urlLabel = r.getUrlLabel();
        this.releaseDate = r.getReleaseDate();
        this.releasePrice = r.getReleasePrice();
        this.insertDate = LocalDateTime.now();
    }
}
