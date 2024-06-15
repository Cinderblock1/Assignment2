package CMPT276.Assignment2.models;

import CMPT276.Assignment2.models.Rectangle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RectangleRepository extends JpaRepository<Rectangle, Integer> {
    List<Rectangle> findByWidth(int width);
    List<Rectangle> findByHeight(int height);
    List<Rectangle> findByName(String name);
    List<Rectangle> findByNameAndColor(String name, String color);
    boolean existsById(int id);
    void deleteById(int id);
}
