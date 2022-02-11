package com.example.pillservice.service.impl;

import com.ps.core.exception.AuthenticationException;
import com.ps.core.model.entity.PsUser;
import com.ps.core.model.entity.PsUserCredential;
import com.ps.core.repository.PsUserCredentialRepository;
import com.ps.core.service.UserCredentialsService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;

@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {

    private static final int SALT_LEN = 16;
    private static final int MEMORY = 65536;
    private static final int PARALLELISM = 1;
    private static final long HASH_TIME = 1000;
    private static final String SALT_HARD = "!6Ma-$%lF&_~gG:)";
    private static Argon2 argon2;
    private static final int ITERATIONS = findIterations();


    @Autowired
    private PsUserCredentialRepository userCredentialRepository;


    private static int findIterations() {
        argon2 = Argon2Factory.create();
        int iterations = Argon2Helper.findIterations(argon2, HASH_TIME, MEMORY, PARALLELISM);
        return iterations;
    }

    @Override
    public void createAndSavePassword(PsUser user, String password) {

        String salt = generateSalt();
        String hash = generateHash(password, salt);
        PsUserCredential userCredential = PsUserCredential.builder()
                .user(user)
                .passwordHash(hash)
                .passwordSalt(salt)
                .build();
        userCredentialRepository.save(userCredential);
    }

    @Override
    public boolean isPassword(PsUser user, String password) {
        PsUserCredential userCredential = userCredentialRepository.findByUser(user);

        String passwordHash = userCredential.getPasswordHash();
        String passwordSalt = userCredential.getPasswordSalt();

        return argon2.verify(passwordHash, fullPassword(password, passwordSalt));
    }

    @Override
    public void updatePassword(PsUser user, String oldPassword, String newPassword) {
        if (!isPassword(user, oldPassword)) {
            throw new AuthenticationException();
        }
        PsUserCredential userCredential = userCredentialRepository.findByUser(user);

        String salt = generateSalt();
        String hash = generateHash(newPassword, salt);

        userCredential.setPasswordSalt(salt);
        userCredential.setPasswordHash(hash);
        userCredentialRepository.save(userCredential);
    }

    private String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[SALT_LEN];
        secureRandom.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String generateHash(String password, String salt) {
        return argon2.hash(ITERATIONS, MEMORY, PARALLELISM,
                fullPassword(password, salt));
    }

    private char[] fullPassword(String password, String salt) {
        String fullPassword = password + SALT_HARD + salt;
        return fullPassword.toCharArray();
    }
}
