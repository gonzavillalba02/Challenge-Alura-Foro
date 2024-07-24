package challenge.alura.foro.domain.topico;

public record DatosRespuestaTopico(
        String titulo,
        String nombreCurso,
        String mensaje,
        Long idUsuario
) {
}
