package ro.enered.magazin.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.enered.magazin.models.UserClient;
import ro.enered.magazin.service.UserClientService;

@RestController
@CrossOrigin(origins = "*")

public class UserClientEndPoints {
    private UserClientService uc = new UserClientService();

    @RequestMapping(value = "/users/register")
    public ResponseEntity<?>addUser(
            @RequestBody UserClient user
            ){
        return ResponseEntity.ok(uc.addUser(user));
    }

    @RequestMapping(value = "/users/exist")
    public ResponseEntity<?>existedUser(@RequestParam String email )
    {
        return ResponseEntity.ok(uc.existedUser(email));

    }

}
