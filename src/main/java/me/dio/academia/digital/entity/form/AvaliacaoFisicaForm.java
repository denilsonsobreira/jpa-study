package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvaliacaoFisicaForm {


  @NotNull(message = "Preencha o campo corretamente")
  private UUID alunoId;

  @NotNull(message = "Preencha o campo corretamente")
  @DecimalMin(value = "0.1")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente")
  @DecimalMin(value = "0.1")
  private double altura;
}
