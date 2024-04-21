package de.diehbg.api;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StickerController {
    private final StickerRepository repository;

    StickerController(StickerRepository stickerRepository) {
        this.repository = stickerRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/stickers")
    List<Sticker> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]


    @PostMapping("/stickers")
    Sticker insert(@RequestBody Sticker sticker) {
        return repository.save(sticker);
    }

    @GetMapping("/stickers/{id}")
    Sticker one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StickerNotFoundException(id));
    }
}
