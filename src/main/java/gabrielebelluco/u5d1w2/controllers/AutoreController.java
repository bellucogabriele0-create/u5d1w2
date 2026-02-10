package gabrielebelluco.u5d1w2.controllers;

import gabrielebelluco.u5d1w2.entities.Autore;
import gabrielebelluco.u5d1w2.payload.NewAutorePayload;
import gabrielebelluco.u5d1w2.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class AutoreController {
    private final AutoreService autoreService;

    @Autowired
    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @GetMapping
    public List<Autore> findAll() {
        return this.autoreService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Autore createAutore(@RequestBody NewAutorePayload payload) {
        return this.autoreService.saveAutore(payload);
    }

    @GetMapping("/{autoreId}")
    public Autore getAutoreById(@PathVariable long autoreId) {
        return this.autoreService.findById(autoreId);
    }

    @PutMapping("/{autoreId}")
    public Autore getAutoreByIdAndUpdate(@PathVariable long autoreId, @RequestBody NewAutorePayload payload) {
        return this.autoreService.findByIdAndUpdate(autoreId, payload);
    }

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void getAutoreByIdAndDelete(@PathVariable long autoreId) {
        this.autoreService.findByIdAndDelete(autoreId);
    }
}
