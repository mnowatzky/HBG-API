package de.diehbg.api;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class StickerController {
    private final StickerRepository repository;

    StickerController(StickerRepository stickerRepository) {
        this.repository = stickerRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/stickers")
    Iterable<Sticker> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @GetMapping("/stickers/filter")
    List<Sticker> filter(@RequestParam Optional<String> name,
                         @RequestParam Optional<String> city,
                         @RequestParam Optional<String> state,
                         @RequestParam Optional<String> country,
                         @RequestParam Optional<LocalDateTime> startDate,
                         @RequestParam Optional<LocalDateTime> endDate) {
        Sticker sticker = new Sticker();

        name.ifPresent(sticker::setName);
        city.ifPresent(sticker::setCity);
        state.ifPresent(sticker::setState);
        country.ifPresent(sticker::setCountry);

        //TODO filter between startDate and endDate

        return repository.findAll(Example.of(sticker));
    }

    @GetMapping("/stickers/count")
    long count() {
        return repository.count();
    }

    @PostMapping("/stickers")
    Sticker insert(@RequestBody Sticker sticker) {
        return repository.save(sticker);
    }

    @GetMapping("/stickers/id/{id}")
    Sticker getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }
}
