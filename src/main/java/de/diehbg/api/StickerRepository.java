package de.diehbg.api;

import org.springframework.data.jpa.repository.JpaRepository;

interface StickerRepository extends JpaRepository<Sticker, Long> {
}
