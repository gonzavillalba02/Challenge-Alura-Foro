package challenge.alura.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico (
        @NotNull
        Long idUsuario,
        @NotBlank
        String mensaje,
        @NotNull
        String nombreCurso,
        @NotBlank
        String titulo
){
}
