package ro.enered.magazin.service;

import ro.enered.magazin.models.Produs;
import ro.enered.magazin.repository.ProdusRepository;

public class ProdusService {
    private ProdusRepository produsrepository= new ProdusRepository();

    public boolean addItem(Produs produs){
        return produsrepository.addItem(produs);
    }

    public boolean deleteItem(int id){
        return produsrepository.deleteItem(id);
    }

    public Object viewList(){
        //am obs ca functia getByNumericalColumn si getAll se asemanau, doar cu o mica diferenta, asa ca le-am unit
        //si cand valoare e -1 in getBynumericalColumn, stiu ca vreau sa afisez toata lista

        return produsrepository.getByNumericalColumnOrAll("getALL",-1);
    }
     public Object get(int id){
        return produsrepository.getByNumericalColumnOrAll("id",id);

     }

}
