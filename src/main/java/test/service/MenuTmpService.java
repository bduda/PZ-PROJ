package test.service;

import antlr.collections.AST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.model.Menu;
import test.model.MenuTmp;
import test.payload.ApiResponse;
import test.payload.MenuTmpRequest;
import test.repository.MenuRepository;
import test.repository.MenuTmpRepository;
import test.security.UserPrincipal;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by AAAaaaAAA on 25.01.2019.
 */
@Service
public class MenuTmpService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuTmpRepository menuTmpRepository;

    public ResponseEntity<?> createMenuTmp(String stnr) {

        List<Menu> menuList = menuRepository.findAll();

        List<MenuTmp> mTmpLst = menuTmpRepository.findAll();

        List<MenuTmp> menuTmpList = new ArrayList<MenuTmp>();

        Menu tmpMenu = new Menu();

        MenuTmp tmpMenuTmp = new MenuTmp();

        boolean stolikExists=false;

        for(int i=0;i<mTmpLst.size();i++){
            tmpMenuTmp = mTmpLst.get(i);

            if((tmpMenuTmp.getStolik()) == Integer.parseInt(stnr)) {
                System.out.println(tmpMenuTmp.getStolik());
                System.out.println(Integer.parseInt(stnr));
                stolikExists=true;
            }
        }

        if(!stolikExists) {
            for (int i = 0; i < menuList.size(); i++) {
                tmpMenu = menuList.get(i);

                tmpMenuTmp = new MenuTmp(tmpMenu.getNazwa(), tmpMenu.getCena(), tmpMenu.getIlosc(), Integer.parseInt(stnr));

                MenuTmp result = menuTmpRepository.save(tmpMenuTmp);
            }
        }
        return ResponseEntity.ok(new ApiResponse(true, "Menu op completed"));
    }

    public List<MenuTmp> getAllMenuTmp(int stnr){


        List<MenuTmp> menuList = menuTmpRepository.findAll();


//        List<Menu> menuKatList = menuRepository.findAll();

        List<MenuTmp> byStList = new ArrayList<MenuTmp>();

        int tmpNr = 0;
        MenuTmp tmpMenu = new MenuTmp();

        for(int i=0;i<menuList.size();i++){
            tmpMenu = menuList.get(i);
//            System.out.println(tmpMenu.getKategoria());
            tmpNr = tmpMenu.getStolik();
//            System.out.println();

//            System.out.println(tmpKat);
//            System.out.println(kat);
            if(tmpNr==stnr) {
//                   System.out.println(tmpKat);
//            System.out.println(kat);

                byStList.add(tmpMenu);
//                System.out.println(tmpKat);
            }
        }


        Set<MenuTmp> menuByStList = new HashSet<MenuTmp>(byStList);

        byStList.clear();

        byStList.addAll(menuByStList);

        return byStList;
    }

    public ResponseEntity<?> deleteTmpMenu(String stnr) {

        List<MenuTmp> mTmpLst = menuTmpRepository.findAll();

        MenuTmp tmpMenuTmp = new MenuTmp();

        boolean stolikExists=false;

        for(int i=0;i<mTmpLst.size();i++){
            tmpMenuTmp = mTmpLst.get(i);

            if((tmpMenuTmp.getStolik()) == Integer.parseInt(stnr)) {
                System.out.println(tmpMenuTmp.getStolik());
                System.out.println(Integer.parseInt(stnr));

                menuTmpRepository.deleteById(tmpMenuTmp.getId());
            }
        }
        return ResponseEntity.ok(new ApiResponse(true, "Menu op completed"));
    }

    public ResponseEntity<?> incTmp(long id) {

        List<MenuTmp> mTmpLst = menuTmpRepository.findAll();

        MenuTmp tmpMenuTmp = new MenuTmp();

        boolean stolikExists=false;

        List<MenuTmp> menuTmpList = new ArrayList<MenuTmp>();

        for(int i=0;i<mTmpLst.size();i++){
            tmpMenuTmp = mTmpLst.get(i);
                if(tmpMenuTmp.getId() == id){
                    int ile = tmpMenuTmp.getIlosc();
                    ile++;
                    tmpMenuTmp.setIlosc(ile);
                        }
            menuTmpList.add(tmpMenuTmp);
                menuTmpRepository.deleteById(id);
        }

        Set<MenuTmp> menuByTmpList = new HashSet<MenuTmp>(menuTmpList);

        mTmpLst.clear();

        mTmpLst.addAll(menuByTmpList);
            menuTmpRepository.saveAll(mTmpLst);

        return ResponseEntity.ok(new ApiResponse(true, "Menu op completed"));
    }

    @PostMapping("/menu/tmp/item")
    public ResponseEntity<?> createTmpItem(MenuTmp menuTmp) {


        MenuTmp menuTmpRes = new MenuTmp(menuTmp.getNazwa(),menuTmp.getCena(),menuTmp.getIlosc(),menuTmp.getStolik());
        MenuTmp result = menuTmpRepository.save(menuTmpRes);

        return ResponseEntity.ok(new ApiResponse(true, "Dodano!"));
    }

    public ResponseEntity<?> deleteRachMenu(String stnr) throws IOException {

        float suma = 0;
        int licznik = 1;
        String fileSeparator = System.getProperty("file.separator");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Instant instant = timestamp.toInstant();

        String fname = new String();
        fname = "RACH_"+instant;
        fname=fname.replaceAll(":",".");
        fname=fname.replaceAll("Z","");
        fname=fname.replaceAll("T","_");
        fname = fname+".TXT";

        //absolute file name with path
        String absoluteFilePath = "C:\\Users\\AAAaaaAAA\\Documents\\ai_prz\\rachunki\\"+fname;
        System.out.println(absoluteFilePath);
        File file = new File(absoluteFilePath);
        if(file.createNewFile()){
            System.out.println(absoluteFilePath+" File Created");
        }else System.out.println("File "+absoluteFilePath+" already exists");

        PrintWriter zapis = new PrintWriter(absoluteFilePath);
        zapis.println("*******************************");
        zapis.println("******  RESTAURACJA AI  *******");
        zapis.println("******     RACHUNEK     *******");
        zapis.println("*STOLIK: "+stnr+"    *******");
        zapis.println("* "+timestamp+" *");
        zapis.println("*******************************");

        zapis.println("");
        zapis.println("POZYCJE:");
        zapis.println("");



        List<MenuTmp> mTmpLst = menuTmpRepository.findAll();

        MenuTmp tmpMenuTmp = new MenuTmp();

        boolean stolikExists=false;

        for(int i=0;i<mTmpLst.size();i++){
            tmpMenuTmp = mTmpLst.get(i);

            if((tmpMenuTmp.getStolik()) == Integer.parseInt(stnr)) {
                zapis.println(licznik+" | "+tmpMenuTmp.getNazwa()+" | "+tmpMenuTmp.getCena());
                licznik++;
                suma+=tmpMenuTmp.getCena();

                menuTmpRepository.deleteById(tmpMenuTmp.getId());
            }
        }
        zapis.println("");
        zapis.println("SUMA: "+suma);
        zapis.println("*******************************");

        zapis.close();


        String mess = "Wygenerowano rachunek. Lokalizacja: "+absoluteFilePath;
        return ResponseEntity.ok(new ApiResponse(true, mess));
    }
}
