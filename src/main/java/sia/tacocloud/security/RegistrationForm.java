package sia.tacocloud.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.domain.entities.UserTaco;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public UserTaco toUser(PasswordEncoder encoder){
        UserTaco userTaco = new UserTaco();

        userTaco.setUsername(username);
        userTaco.setPassword(encoder.encode(password));
        userTaco.setFullname(fullname);
        userTaco.setStreet(street);
        userTaco.setCity(city);
        userTaco.setState(state);
        userTaco.setPhoneNumber(phone);
        userTaco.setZip(zip);

        return userTaco;
    }
}

