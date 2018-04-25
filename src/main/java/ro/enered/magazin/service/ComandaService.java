package ro.enered.magazin.service;

import ro.enered.magazin.models.Comanda;
import ro.enered.magazin.models.Produs;
import ro.enered.magazin.repository.ComandaRepository;
import ro.enered.magazin.repository.ProdusRepository;

public class ComandaService {
    private ComandaRepository comandaRepository = new ComandaRepository();
    private ProdusRepository produsRepository = new ProdusRepository();

    public boolean send(Comanda comanda){
        return comandaRepository.create(comanda);
    }
    public Object getByIdClient(int idClient){
        return comandaRepository.getByNumericalColumnOrAll("id_user",idClient);
    }
    public Object getAll(){
        return comandaRepository.getByNumericalColumnOrAll("getAll", -1);

    }
    public  boolean aprobaComanda(int idComanda){
        Comanda c = (Comanda) comandaRepository.getByNumericalColumnOrAll("id",idComanda);
        //luam produsul din comanda
        Produs p = (Produs) produsRepository.getByNumericalColumnOrAll("id",c.id);

        //verificam daca comanda nu e aprobata pentru a nu se putea repeta comanda de mai multe ori
        if(c.status ==0)
            if(c.cantitate<=p.cantitate){
                //daca avem cantitatea in stoc setam comanda aprobata
                //si scadem din stoc cantitatea din comanda
                c.status = 1;
                p.cantitate = p.cantitate = c.cantitate;
                produsRepository.update(p);
                return comandaRepository.update(c);
            }else{
                return false;
            }
        else return false;
        }

}
