package test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.model.*;
import test.payload.*;
import test.security.UserPrincipal;

import test.repository.ReserRepository;


import java.util.*;


@Service
public class ReserService {
    @Autowired
    ReserRepository reserRepository;
    private static final Logger logger = LoggerFactory.getLogger(PollService.class);


    public ResponseEntity<?> saveReser(Reser reser) {

        List<Reser> reserList = reserRepository.findAll();

        Reser resertmp = new Reser(reser.getStol(),
                reser.getKto(), reser.getData(), reser.getGodz());

        boolean dobrze = true;

        Reser rser = new Reser();

        for (int i = 0; i < reserList.size(); i++) {
            rser = reserList.get(i);

            if ((rser.getData().equals(resertmp.getData())) && rser.getStol()==resertmp.getStol() && ((resertmp.getGodz()<(reser.getGodz()+4)) || (resertmp.getGodz()>(reser.getGodz()-4)))) {
                dobrze = false;

            }
        }

        if(dobrze) {
            Reser result = reserRepository.save(reser);

            return ResponseEntity.ok(new ApiResponse(true, "Reser added successfully"));
        } else{
           return new ResponseEntity(new ApiResponse(false, "Reservation for this table is already done!"),
                    HttpStatus.BAD_REQUEST) ;
        }
    }

//
//
//    @Transactional
//    Boolean existsByReser(String reser){return reserRepository.existsbyReser()};

    public List<Reser> getAllResers(UserPrincipal currentUser) {

        List<Reser> reserList = reserRepository.findAll();
        reserList.sort(Comparator.comparing(Reser::getData));


        List<Reser> newReserList = new ArrayList<>();

        Date currDate = new Date();
        Reser reserTmp = new Reser();
        Date tmpDate = new Date();

        for (int i = 0; i < reserList.size(); i++) {
            reserTmp = reserList.get(i);
            tmpDate = reserTmp.getData();

            if (tmpDate.getYear() > currDate.getYear()) {
                newReserList.add(reserTmp);
            }else if(tmpDate.getYear() == currDate.getYear()) {
                if (tmpDate.getMonth() > currDate.getMonth()) {
                    newReserList.add(reserTmp);
                } else if (tmpDate.getMonth() == currDate.getMonth()) {
                    if (tmpDate.getDay() >= currDate.getDay()) {
                        newReserList.add(reserTmp);
                    }
                }
            }

        }
        return newReserList;
    }

    public List<Reser> getReserStol(String stol) {

        List<Reser> reserList = reserRepository.findAll();
        reserList.sort(Comparator.comparing(Reser::getData));


        List<Reser> newReserList = new ArrayList<>();

        Date currDate = new Date();
        Reser reserTmp = new Reser();
        Date tmpDate = new Date();

        for (int i = 0; i < reserList.size(); i++) {
            reserTmp = reserList.get(i);
            tmpDate = reserTmp.getData();

            if(reserTmp.getStol()== Integer.parseInt(stol)) {
                if (tmpDate.getYear() > currDate.getYear()) {
                    newReserList.add(reserTmp);
                } else if (tmpDate.getYear() == currDate.getYear()) {
                    if (tmpDate.getMonth() > currDate.getMonth()) {
                        newReserList.add(reserTmp);
                    } else if (tmpDate.getMonth() == currDate.getMonth()) {
                        if (tmpDate.getDay() >= currDate.getDay()) {
                            newReserList.add(reserTmp);
                        }
                    }
                }
            }

        }
        return newReserList;
    }
}