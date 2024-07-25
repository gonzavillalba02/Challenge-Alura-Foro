package challenge.alura.foro.domain.topico;

public record DatosRespuestaTopico(
        String titulo,
        String nombreCurso,
        String mensaje,
        Long idUsuario,
        Boolean activo
) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getTitulo(), topico.getNombreCurso(), topico.getMensaje(), topico.getUsuario().getId(), topico.getActivo());
    }
}
