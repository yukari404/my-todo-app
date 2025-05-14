package com.example.todo.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ユーザー情報全件取得
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //　ユーザー情報登録
    @PreAuthorize("hasAuthority('ADMIN')")
    public void create(String username, String password,String authority) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // パスワードをBCryptでエンコード
        String encodedPassword = encoder.encode(password);

        //var encodedPassword = passwordEncoder.encode(password);
        userRepository.insert(username, encodedPassword, authority);
    }
}
