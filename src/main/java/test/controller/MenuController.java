package test.controller;

import java.io.IOException;
import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import test.exception.AppException;
import test.model.*;
import test.repository.*;

import java.lang.Exception;
import test.payload.*;
import test.security.CurrentUser;
import test.security.UserPrincipal;
import test.service.CodeService;
import test.service.MenuService;
import test.service.MenuTmpService;
import test.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuService menuService;

    @Autowired
    MenuTmpService menuTmpService;

    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(PollController.class);

    public MenuController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @GetMapping("/menu")
    @PreAuthorize("hasRole('USER')")
    public List<Menu> getAllMenu(@CurrentUser UserPrincipal currentUser) {

        return menuService.getAllMenu(currentUser);
    }

    @PostMapping("/menu/savemenu")
    public ResponseEntity<?> saveMenu(@Valid @RequestBody MenuRequest menuRequest) {


        // Creating user's account
        Menu menu = new Menu( menuRequest.getNazwa(),menuRequest.getOpis(),
                menuRequest.getKategoria(), Float.parseFloat(menuRequest.getCena()), Integer.parseInt(menuRequest.getIlosc()));

        Menu result = menuRepository.save(menu);

        return ResponseEntity.ok(new ApiResponse(true, "Menu item added successfully"));

    }

    @PostMapping("/menu/deletemenu")
    public ResponseEntity<?> deleteMenu(@Valid @RequestBody MenuRequest menuRequest) {

        long tmpId = Long.parseLong(menuRequest.getId());
        menuRepository.deleteById(tmpId);

        return ResponseEntity.ok(new ApiResponse(true, "Menu item deleted successfully"));
    }

    @PostMapping("/menu/modifymenu")
    public ResponseEntity<?> modifyMenu(@Valid @RequestBody MenuRequest menuRequest) {

        if(!menuRepository.existsById(Long.parseLong(menuRequest.getId()))) {
            return new ResponseEntity(new ApiResponse(false, "Code doesn't exists!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Menu menu = new Menu( menuRequest.getNazwa(),menuRequest.getOpis(),
                menuRequest.getKategoria(), Float.parseFloat(menuRequest.getCena()), Integer.parseInt(menuRequest.getIlosc()));

        long tmpId = Long.parseLong(menuRequest.getId());
        menuRepository.deleteById(tmpId);

        Menu result = menuRepository.save(menu);

        return ResponseEntity.ok(new ApiResponse(true, "Menu item modified successfully"));
    }

    @GetMapping("/menu/getkat")
    @PreAuthorize("hasRole('USER')")
    public List<String> getKategorie(@CurrentUser UserPrincipal currentUser) {

        return menuService.getKategorie(currentUser);
    }

    @GetMapping("/menu/getbykat/{kat}")
    @PreAuthorize("hasRole('USER')")
        public List<Menu> funcfindByKategoria(@PathVariable String kat) {

        System.out.println();

        return menuService.funcfindByKategoria(kat);
    }

    @PostMapping("/menu/tmp/create")
    public ResponseEntity<?> createMenuTmp(@Valid @RequestBody StolikNrRequest stnr) {

        String stnr2 = new String(stnr.getNumer());

        return menuTmpService.createMenuTmp(stnr2);
    }

    @GetMapping("/menu/tmp/get/{stnr}")
    @PreAuthorize("hasRole('USER')")
    public List<MenuTmp> getAllMenuTmp(@PathVariable String stnr) {
        int stnr2 = Integer.parseInt(stnr);

        return menuTmpService.getAllMenuTmp(stnr2);
    }

    @PostMapping("/menu/tmp/del")
    public ResponseEntity<?> deleteTmpMenu(@Valid @RequestBody StolikNrRequest stnr) {

        String stnr2 = new String(stnr.getNumer());

        return menuTmpService.deleteTmpMenu(stnr2);
    }

    @PostMapping("/menu/tmp/rach")
    public ResponseEntity<?> deleteRachMenu(@Valid @RequestBody StolikNrRequest stnr) throws IOException {

        String stnr2 = new String(stnr.getNumer());

        return menuTmpService.deleteRachMenu(stnr2);
    }
    @PostMapping("/menu/tmp/item")
    public ResponseEntity<?> createTmpItem(@Valid @RequestBody MenuTmpRequest menuTmpRequest) {

        MenuTmp menuTmp = modelMapper.map(menuTmpRequest, MenuTmp.class);

        return menuTmpService.createTmpItem(menuTmp);
    }

    @PostMapping("/menu/tmp/inc")
    public ResponseEntity<?> incTmp(@Valid @RequestBody IdTmpReq idTmpReq) {

        long id = Long.parseLong(idTmpReq.getId());

        return menuTmpService.incTmp(id);
    }
}