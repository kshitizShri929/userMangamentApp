// package com.service;

// public class userService {
    
// }
package com.keenable.user_manegement_app.service;

import com.keenable.user_manegement_app.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> userMap = new HashMap<>();

    public User registerUser(String username) {
        if (userMap.containsKey(username)) {
            return null; // Username already exists
        }
        String password = generateStrongPassword();
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptPassword(password));
        userMap.put(username, user);
        return user;
    }

    public User updateUser(String username, String newPassword) {
        User user = userMap.get(username);
        if (user != null) {
            user.setPassword(encryptPassword(newPassword));
            return user;
        }
        return null; // User not found
    }

    public User deleteUser(String username) {
        return userMap.remove(username); // Removes user and returns it
    }

    public User retrieveUser(String password) {
        return userMap.values().stream()
                .filter(user -> user.getPassword().equals(encryptPassword(password)))
                .findFirst()
                .orElse(null); // User not found
    }

    private String generateStrongPassword() {
        SecureRandom random = new SecureRandom();
        int passwordLength = 10; // Customize as needed
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            password.append(random.nextInt(10)); // Generate random digits
        }
        return password.toString();
    }

    private String encryptPassword(String password) {
        // Add your strong encryption logic here
        return password; // For simplicity, returning password directly
    }
}
