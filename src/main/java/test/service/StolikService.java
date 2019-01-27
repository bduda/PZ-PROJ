package test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.model.Code;
import test.model.Menu;
import test.model.Stolik;
import test.payload.ApiResponse;
import test.payload.RoomModRequest;
import test.repository.CodeRepository;
import test.repository.StolikRepository;
import test.security.UserPrincipal;

import java.util.List;

@Service
public class StolikService {
    @Autowired
    StolikRepository stolikRepository;

    public List<Stolik> getAllStolik(UserPrincipal currentUser){
        List<Stolik> stolikList = stolikRepository.findAll();
        return stolikList;
    }

    public void modRoom(RoomModRequest roomModRequest){

        stolikRepository.updateUser(roomModRequest.getPojemnosc(), roomModRequest.getAktywnosc(), roomModRequest.getAktyp(),
        roomModRequest.getAkview(),roomModRequest.getAkdsbl(),roomModRequest.getZajetosc(),roomModRequest.numer);
    }
}