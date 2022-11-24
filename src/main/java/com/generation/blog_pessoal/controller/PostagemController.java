package com.generation.blog_pessoal.controller;

import com.generation.blog_pessoal.model.Postagem;
import com.generation.blog_pessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    private ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable Long id){
        /*Optional<Postagem> buscaPostagem = postagemrepository.findById(id);
        if(buscaPostagem.isPresent())
            return ResponseEntity.ok(buscaPostagem.get());
        else
            return ResponseEntity.notFound(). build();*/

        //return buscaPostagem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   return postagemRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>>getTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagem>postPostagem(@Valid @RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
    }
    @PutMapping
    public ResponseEntity<Postagem>putPostagem(@Valid @RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void deletePostagem(@PathVariable Long id){
        postagemRepository.deleteById(id);
    }

}
