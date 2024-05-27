package de.diehbg.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        return repository.findAllByOrderByLoggedAtAsc();
    }
    // end::get-aggregate-root[]

    @GetMapping("/stickers/filter")
    List<Sticker> filter(@RequestParam Optional<String> name,
                         @RequestParam Optional<String> city,
                         @RequestParam Optional<String> state,
                         @RequestParam Optional<String> country,
                         @RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                         Optional<LocalDateTime> from,
                         @RequestParam
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                         Optional<LocalDateTime> to) {
        Sticker stickerPattern = new Sticker();

        name.ifPresent(stickerPattern::setName);
        city.ifPresent(stickerPattern::setCity);
        state.ifPresent(stickerPattern::setState);
        country.ifPresent(stickerPattern::setCountry);

        final List<Sticker> stickers = repository.findAll(Example.of(stickerPattern), Sort.by(Sort.Direction.ASC, "loggedAt"));

        from.ifPresent(f -> stickers.removeIf(s -> s.getLoggedAt().isBefore(f)));
        to.ifPresent(t -> stickers.removeIf(s -> s.getLoggedAt().isAfter(t)));

        return stickers;
    }

    @GetMapping("/stickers/count")
    long count() {
        return repository.count();
    }

    @PostMapping("/stickers")
    Sticker insert(@Valid @RequestBody Sticker sticker) {
        return repository.save(sticker);
    }

    @GetMapping("/stickers/id/{id}")
    Sticker getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
    }
}
