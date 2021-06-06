package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.converter.UserConverter;
import br.com.vbdev.beleza_agendada.model.AddressModel;
import br.com.vbdev.beleza_agendada.model.PermissionModel;
import br.com.vbdev.beleza_agendada.model.UserModel;
import br.com.vbdev.beleza_agendada.model.UserTypeModel;
import br.com.vbdev.beleza_agendada.model.form.AddressForm;
import br.com.vbdev.beleza_agendada.model.form.UserForm;
import br.com.vbdev.beleza_agendada.model.form.UserTypeForm;
import br.com.vbdev.beleza_agendada.model.types.LoginType;
import br.com.vbdev.beleza_agendada.model.types.UserType;
import br.com.vbdev.beleza_agendada.repository.AddressRepository;
import br.com.vbdev.beleza_agendada.repository.PermissionRepository;
import br.com.vbdev.beleza_agendada.repository.UserRepository;
import br.com.vbdev.beleza_agendada.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    private UserModel userModel = new UserModel();

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private AddressRepository addressRepository;
    private AddressModel addressModel = new AddressModel();

    @Autowired
    private UserTypeRepository userTypeRepository;
    private UserTypeModel userTypeModel = new UserTypeModel();

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(userName);
        if(user != null)
            return (UserDetails) user;
        else
            throw new UsernameNotFoundException("Username " + userName + "Not found");
    }

    private String passwordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(password);
        return result;
    }

    public String create(UserForm user) {
        List<PermissionModel> permission = new ArrayList<>();
        permission.add(permissionRepository.getOne(3L));

        userModel = UserConverter.toModel(user);
        userModel.setPassword(passwordEncoder(user.getPassword()));
        userModel.setAccountNonExpired(true);
        userModel.setAccountNonExpired(true);
        userModel.setCredentialsNonExpired(true);
        userModel.setEnabled(true);
        userModel.setPermissions(permission);

        userTypeModel = userTypeRepository.findByUserType(user.getUserType().getUser_type());
        System.out.println(user.getUserType().getUser_type().toString());
        userModel.setUserType(userTypeModel);
//        userTypeRepository.save(userModel.getUserType());
        addressRepository.save(userModel.getAddress());
        System.out.println(userModel.getPassword());
        System.out.println(userModel.getPermissions().get(0).getDescription());
        userRepository.save(userModel);

        return user.getEmail();
    }
}
