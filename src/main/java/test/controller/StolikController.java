package test.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import test.exception.AppException;
import test.model.*;
import test.repository.*;

import java.lang.Exception;
import test.payload.*;
import test.security.CurrentUser;
import test.security.UserPrincipal;
import test.service.CodeService;
import test.service.StolikService;
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
@RequestMapping("/api/stolik")
public class StolikController {

    @Autowired
    private StolikRepository stolikRepository;

    @Autowired
    private StolikService stolikService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    public List<Stolik> getAllStolik(@CurrentUser UserPrincipal currentUser) {

        return stolikService.getAllStolik(currentUser);
    }

    @PostMapping("/akt/modify")
    public ResponseEntity<?> modRoom(@Valid @RequestBody RoomModRequest roomModRequest) {

        stolikService.modRoom(roomModRequest);

        return ResponseEntity.ok(new ApiResponse(true, "Code modified successfully"));
    }
}