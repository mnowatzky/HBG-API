package de.diehbg.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface StickerRepository extends JpaRepository<Sticker, Long> {
}
