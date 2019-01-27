package test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Code;
import test.model.Menu;
import test.payload.MenuByKatRequest;
import test.repository.CodeRepository;
import test.repository.MenuRepository;
import test.security.UserPrincipal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    private static final Logger logger = LoggerFactory.getLogger(PollService.class);

    public List<Menu> getAllMenu(UserPrincipal currentUser){


        List<Menu> menuList = menuRepository.findAll();
        return menuList;
    }

    public List<String> getKategorie(UserPrincipal currentUser){

        List<Menu> menuKatList = menuRepository.findAll();

//        System.out.println(menuKatList);

        List<String> katList = new ArrayList<String>();

        String tmpKat = null;
        Menu tmpMenu = new Menu();

        for(int i=0;i<menuKatList.size();i++){
            tmpMenu = menuKatList.get(i);
//            System.out.println(tmpMenu);
            tmpKat = tmpMenu.getKategoria();
//        System.out.println(tmpKat);

        katList.add(tmpKat);
        }

        Set<String> katDistList = new HashSet<String>(katList);

        katList.clear();

        katList.addAll(katDistList);

        return katList;
    }

    public List<Menu> funcfindByKategoria(String kat){

//        System.out.println(kat);
        List<Menu> menuKatList = menuRepository.findAll();

        List<Menu> byKatList = new ArrayList<Menu>();

        String tmpKat = null;
        Menu tmpMenu = new Menu();

        for(int i=0;i<menuKatList.size();i++){
            tmpMenu = menuKatList.get(i);
//            System.out.println(tmpMenu.getKategoria());
            tmpKat = tmpMenu.getKategoria();
//            System.out.println();

//            System.out.println(tmpKat);
//            System.out.println(kat);
       if(tmpKat.equals(kat)&&(!kat.equals("MENU"))) {
//                   System.out.println(tmpKat);
//            System.out.println(kat);

        byKatList.add(tmpMenu);
        System.out.println(tmpKat);
    }
    else if(kat.equals("MENU")) {
           byKatList.add(tmpMenu);
       }
    }


        Set<Menu> menuByKatList = new HashSet<Menu>(byKatList);

        byKatList.clear();

        byKatList.addAll(menuByKatList);

        return byKatList;
    }

}
