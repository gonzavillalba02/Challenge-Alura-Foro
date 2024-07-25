package challenge.alura.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosGetTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long idUsuario
) {
    public DatosGetTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getUsuario().getId());
    }
}
