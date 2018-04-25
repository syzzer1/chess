package ro.enered.magazin.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.enered.magazin.models.Produs;
import ro.enered.magazin.service.ProdusService;

@CrossOrigin(origins="*")
@RestController
public class ProdusEndpoints {
    private ProdusService ps = new ProdusService();

    @RequestMapping(value = "/product/add")
    public ResponseEntity<?>addItem(@RequestBody Produs produs){
        if(ps.addItem(produs)==true)
            return ResponseEntity.ok("Added");
        else
            return ResponseEntity.ok("Not added");
    }
    @RequestMapping(value = "/product/delete")
    public ResponseEntity<?>deleteProduct(@RequestParam int id){
        if(ps.deleteItem(id)==true)
            return ResponseEntity.ok("Deleted");
        else
            return ResponseEntity.ok("Not deleted");
    }
    @RequestMapping(value="/product/list")
    public ResponseEntity<?>lista(){
        return ResponseEntity.ok(ps.viewList());
    }

    @RequestMapping(value ="/product/get")
        public ResponseEntity<?>get(@RequestParam int id){
        return ResponseEntity.ok(ps.get(id));
    }
}
