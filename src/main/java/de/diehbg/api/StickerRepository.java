package de.diehbg.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface StickerRepository extends JpaRepository<Sticker, Long> {
    List<Sticker> findAllByOrderByLoggedAtAsc();
}
