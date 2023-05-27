package br.com.fiap.bffjogos.http.domain.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameRequest {

    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;
    @NotNull(message = "platafomr is required")
    @NotBlank(message = "platafomr is required")
    private String platafomr;
    @NotNull(message = "urlLabel is required")
    @NotBlank(message = "urlLabel is required")
    private String urlLabel;
    private LocalDate releaseDate;
    private BigDecimal releasePrice;
}
