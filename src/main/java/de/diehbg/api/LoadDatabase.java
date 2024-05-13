package de.diehbg.api;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//    @Bean
//    CommandLineRunner initDatabase(StickerRepository repository) {
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime1 = LocalDateTime.parse("2019-04-13 11:17:38", formatter);
//        LocalDateTime dateTime2 = LocalDateTime.parse("2019-04-13 11:39:53", formatter);
//
//        return args -> {
//            Point point = new GeometryFactory().createPoint(new Coordinate(12.34343, 12.232424));
//            log.info("Preloading " + repository.save(new Sticker(point, "Malte", dateTime1, "Norderstedt", "Schleswig-Holstein", "Deutschland")));
//            log.info("Preloading " + repository.save(new Sticker(point, "Timo", dateTime2, "Norderstedt", "Schleswig-Holstein", "Deutschland")));
//        };
//    }
}
