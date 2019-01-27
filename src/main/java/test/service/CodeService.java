package test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import test.exception.BadRequestException;
import test.exception.ResourceNotFoundException;
import test.model.*;
import test.payload.*;
import test.repository.PollRepository;
import test.repository.UserRepository;
import test.repository.VoteRepository;
import test.security.UserPrincipal;
import test.util.AppConstants;
import test.util.ModelMapper;

import test.repository.CodeRepository;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class CodeService {
    @Autowired CodeRepository codeRepository;
    private static final Logger logger = LoggerFactory.getLogger(PollService.class);


    public ResponseEntity<?> saveCode(Code code) {
        if(codeRepository.existsByCode(code.getCode())) {
            return new ResponseEntity(new ApiResponse(false, "Code is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Code codetmp = new Code( code.getCode(),code.getKind(),
                code.getType(), code.getValue());

        Code result = codeRepository.save(code);

        return ResponseEntity.ok(new ApiResponse(true, "Code added successfully"));

    }

//
//
//    @Transactional
//    Boolean existsByCode(String code){return codeRepository.existsbyCode()};

    public List<Code> getAllCodes(UserPrincipal currentUser){

    List<Code> codeList = codeRepository.findAll();

    return codeList;
    }

}
