package me.nattapon.backend.api;

import me.nattapon.backend.business.UserBusiness;
import me.nattapon.backend.entity.User;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserApi {

    // METHOD 1 : Field Injection
    //  @Autowired
    //  private TestBusiness business;

    // METHOD 2 : Constructor Injection
    private final UserBusiness business;

    public UserApi(UserBusiness business) {
        this.business = business;
    }

//    @GetMapping("/1")
//    public TestResponse test() {
//        TestResponse response = new TestResponse();
//        response.setName("Nat");
//        response.setFood("KFC");
//        return response;
//    }
//
//    @GetMapping("/2")
//
//    public TestResponse test2() {
//        TestResponse response = new TestResponse();
//        response.setName("Nui");
//        response.setFood("MK");
//        return response;
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MLoginRequest request) throws BaseException {
        String response = business.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<MRegisterResponse> register(@RequestBody MRegisterRequest request) throws BaseException {
        MRegisterResponse response = business.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);

    }
}

