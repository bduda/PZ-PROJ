package test.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import test.exception.AppException;
import test.model.*;
import test.repository.*;

import java.lang.Exception;
import test.payload.*;
import test.security.CurrentUser;
import test.security.UserPrincipal;
import test.service.ReserService;
import test.service.ReserService;
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
@RequestMapping("/api")
public class ReserController {


    @Autowired
    private ReserRepository reserRepository;

    @Autowired
    private ReserService reserService;
    
    private final ModelMapper modelMapper;

    public ReserController(ReserService reserService,
                          ModelMapper modelMapper) {
        this.reserService = reserService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/reser/all")
    @PreAuthorize("hasRole('USER')")
    public List<Reser> getAllResers(@CurrentUser UserPrincipal currentUser) {

        return reserService.getAllResers(currentUser);
    }

    @PostMapping("/resers/add")
    public ResponseEntity<?> saveReser(@Valid @RequestBody ReserSaveRequest reserSaveRequest) {
        System.out.println(reserSaveRequest);
        System.out.println();
//            return new ResponseEntity(new ApiResponse(false, "Reser is already taken!"),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        // Creating user's account
//        Reser reser = new Reser( reserSaveRequest.getReser(),reserSaveRequest.getKind(),
//                reserSaveRequest.getType(), reserSaveRequest.getValue());
//
//        Reser result = reserRepository.save(reser);
//
//        return ResponseEntity.ok(new ApiResponse(true, "Reser added successfully"));

        Reser reser = modelMapper.map(reserSaveRequest, Reser.class);
//        return modelMapper.map(productService.createOrUpdate(product), ProductDTO.class);

        return reserService.saveReser(reser);
    }

    @PostMapping("/resers/deletereser")
    public ResponseEntity<?> deleteReser(@Valid @RequestBody ReserSaveRequest reserSaveRequest) {

        long tmpId = Long.parseLong(reserSaveRequest.getId());
        reserRepository.deleteById(tmpId);

        return ResponseEntity.ok(new ApiResponse(true, "Reser deleted successfully"));
    }

    @GetMapping("/reser/data/{stol}")
    @PreAuthorize("hasRole('USER')")
    public List<Reser> funcfindByKategoria(@PathVariable String stol) {


        return reserService.getReserStol(stol);
    }

}