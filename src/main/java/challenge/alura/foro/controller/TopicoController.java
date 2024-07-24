package challenge.alura.foro.controller;

import challenge.alura.foro.domain.topico.DatosRegistroTopico;
import challenge.alura.foro.domain.topico.DatosRespuestaTopico;
import challenge.alura.foro.domain.topico.Topico;
import challenge.alura.foro.domain.topico.TopicoRepository;
import challenge.alura.foro.domain.usuario.Usuario;
import challenge.alura.foro.domain.usuario.UsuarioRepository;
import challenge.alura.foro.infra.errores.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarMedico(@RequestBody @Valid DatosRegistroTopico parametro, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioRepository.findById(parametro.idUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));;
        Topico topico = topicoRepository.save(new Topico(parametro, usuario));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getTitulo(),
                topico.getNombreCurso(),
                topico.getMensaje(),
                topico.getUsuario().getId()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Topico no encontrado con id " + id));
        return ResponseEntity.ok(topico);
    }

}
