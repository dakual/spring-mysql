package com.daghan.springmysql.controller;

import com.daghan.springmysql.model.Menu;
import com.daghan.springmysql.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuRepository menuRepository;
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Menu> addNewMenu(@RequestBody Menu menu) {
        Menu result = menuRepository.save(menu);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Menu>> getAllMenu() {
        List<Menu> result = menuRepository.findAll();
        return ResponseEntity.ok(result);
    }
}
