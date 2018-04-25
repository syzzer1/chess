package ro.enered.magazin.service;

import ro.enered.magazin.models.UserClient;
import ro.enered.magazin.repository.UserClientRepository;

import java.util.ArrayList;

public class UserClientService {
    private UserClientRepository uc = new UserClientRepository();

    public boolean addUser(UserClient user){
        return uc.addUser(user);
    }

    public ArrayList<UserClient> arataLista(String email){
         ArrayList<UserClient> lista = (ArrayList<UserClient>) uc.getByStringColumn("email", email);
        return lista;
    }

    }


}
