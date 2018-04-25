package ro.enered.magazin.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.enered.magazin.models.Comanda;
import ro.enered.magazin.service.ComandaService;

public class ComandaEndPoints {
    private ComandaService comandaService = new ComandaService();

    //daca imi aduc aminte pentru FrontEND ei trebui sa primeasca ca raspuns
    //ce zicea vlad TRUE/FALSE sau Object
    @RequestMapping(value = "/comanda/send")
    public ResponseEntity<?> hello(@RequestBody Comanda comanda) {
        //O sa returneze TRUE daca comanda a mers cum trebuie si FALSE daca nu
        return ResponseEntity.ok(comandaService.send(comanda));
    }

    @RequestMapping(value = "/comanda/get")
    public ResponseEntity<?> grettings(@RequestParam int idClient) {

        return ResponseEntity.ok(comandaService.getByIdClient(idClient));
    }

    @RequestMapping(value = "comanda/list")
    public ResponseEntity getall() {

        return ResponseEntity.ok(comandaService.getAll());
    }

    @RequestMapping(value = "/comanda/aproba")
    public ResponseEntity<?> aproba(@RequestParam int idComanda) {

        return ResponseEntity.ok(comandaService.aprobaComanda(idComanda));
    }

}


}
