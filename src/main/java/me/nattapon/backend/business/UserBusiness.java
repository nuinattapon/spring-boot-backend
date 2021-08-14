package me.nattapon.backend.business;

import me.nattapon.backend.entity.User;
import me.nattapon.backend.exception.BaseException;
import me.nattapon.backend.exception.FileException;
import me.nattapon.backend.exception.UserException;
import me.nattapon.backend.mapper.UserMapper;
import me.nattapon.backend.model.MLoginRequest;
import me.nattapon.backend.model.MLoginResponse;
import me.nattapon.backend.model.MRegisterRequest;
import me.nattapon.backend.model.MRegisterResponse;
import me.nattapon.backend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserBusiness {

    private final UserService userService;
    private final UserMapper userMapper;


    public UserBusiness(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public MRegisterResponse register(MRegisterRequest request) throws BaseException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());

        // mapper
        return userMapper.toRegisterResponse(user);
    }


    public String login(MLoginRequest request) throws BaseException {
        // Validate request
        // Verify database
        Optional<User> opt = userService.findByEmail(request.getEmail());
        if(opt.isEmpty()) {
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        if( !userService.matchPassword(request.getPassword(),user.getPassword())) {
            throw UserException.loginFailPasswordIncorrect();
        }

        // TODO: Generate JWT
        String token = "JWT TO DO";

        return token;
    }

    public String uploadProfilePicture(MultipartFile file) throws BaseException {

        // Validate file
        if (file == null ) {
            // throw error
            throw FileException.fileNull();
        }

        // Validate size
        if (file.getSize() > 1048576 *2) {
            // throw error
            throw FileException.fileMaxSize();
        }

        // Validate type
        String contentType = file.getContentType();
        if (Objects.isNull(contentType)) {
            // throw error
            throw FileException.unsupportedFileType();
        }

        List<String> supportedType = Arrays.asList("image/jpeg","image/png");
        if(!supportedType.contains(contentType)) {
            //throw error (unsupported)
            throw FileException.unsupportedFileType();
        }


        // TODO: upload file File Storage (AWS S3, etc...)
        try {
            byte[] bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
