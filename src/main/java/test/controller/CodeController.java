package test.controller;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import test.exception.AppException;
import test.model.*;
import test.repository.CodeRepository;
import java.lang.Exception;
import test.payload.*;
import test.repository.PollRepository;
import test.repository.UserRepository;
import test.repository.VoteRepository;
import test.security.CurrentUser;
import test.security.UserPrincipal;
import test.service.CodeService;
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
@RequestMapping("/api/code")
public class CodeController {

    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    private CodeService codeService;

    private static final Logger logger = LoggerFactory.getLogger(PollController.class);

    private final ModelMapper modelMapper;

    public CodeController(CodeService codeService,
                             ModelMapper modelMapper) {
        this.codeService = codeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/codes")
    @PreAuthorize("hasRole('USER')")
    public List<Code> getAllCodes(@CurrentUser UserPrincipal currentUser) {

        return codeService.getAllCodes(currentUser);
    }

    @PostMapping("/codes/savecode")
    public ResponseEntity<?> saveCode(@Valid @RequestBody CodeSaveRequest codeSaveRequest) {
//        if(codeRepository.existsByCode(codeSaveRequest.getCode())) {
//            return new ResponseEntity(new ApiResponse(false, "Code is already taken!"),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        // Creating user's account
//        Code code = new Code( codeSaveRequest.getCode(),codeSaveRequest.getKind(),
//                codeSaveRequest.getType(), codeSaveRequest.getValue());
//
//        Code result = codeRepository.save(code);
//
//        return ResponseEntity.ok(new ApiResponse(true, "Code added successfully"));

        Code code = modelMapper.map(codeSaveRequest, Code.class);
//        return modelMapper.map(productService.createOrUpdate(product), ProductDTO.class);

        Code code2 = modelMapper.map('d',Code.class);

        return codeService.saveCode(code);

    }

    @PostMapping("/codes/deletecode")
    public ResponseEntity<?> deleteCode(@Valid @RequestBody CodeSaveRequest codeSaveRequest) {

        long tmpId = Long.parseLong(codeSaveRequest.getId());
        codeRepository.deleteById(tmpId);

        return ResponseEntity.ok(new ApiResponse(true, "Code deleted successfully"));
    }

    @PostMapping("/codes/modifycode")
    public ResponseEntity<?> modifyCode(@Valid @RequestBody CodeSaveRequest codeSaveRequest) {

        if(!codeRepository.existsByCode(codeSaveRequest.getCode())) {
            return new ResponseEntity(new ApiResponse(false, "Code doesn't exists!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Code code = new Code( codeSaveRequest.getCode(),codeSaveRequest.getKind(),
                codeSaveRequest.getType(), codeSaveRequest.getValue());

        long tmpId = Long.parseLong(codeSaveRequest.getId());
        codeRepository.deleteById(tmpId);

        Code result = codeRepository.save(code);

        return ResponseEntity.ok(new ApiResponse(true, "Code modified successfully"));
    }

}