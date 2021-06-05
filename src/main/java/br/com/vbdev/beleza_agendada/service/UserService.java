package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.converter.UserConverter;
import br.com.vbdev.beleza_agendada.model.AddressModel;
import br.com.vbdev.beleza_agendada.model.UserModel;
import br.com.vbdev.beleza_agendada.model.UserTypeModel;
import br.com.vbdev.beleza_agendada.model.form.AddressForm;
import br.com.vbdev.beleza_agendada.model.form.UserForm;
import br.com.vbdev.beleza_agendada.model.form.UserTypeForm;
import br.com.vbdev.beleza_agendada.model.types.LoginType;
import br.com.vbdev.beleza_agendada.repository.AddressRepository;
import br.com.vbdev.beleza_agendada.repository.UserRepository;
import br.com.vbdev.beleza_agendada.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserModel userModel = new UserModel();

    @Autowired
    private AddressRepository addressRepository;
    private AddressModel addressModel = new AddressModel();

    @Autowired
    private UserTypeRepository userTypeRepository;
    private UserTypeModel userTypeModel = new UserTypeModel();

    public UserForm createUser(@RequestBody @Valid UserForm user) {

        userModel = UserConverter.toModel(user);
        addressRepository.save(userModel.getAddress());
        userTypeRepository.save(userModel.getUserType());
        userRepository.save(userModel);

        return user;
    }

    public UserForm getUser(Long id) {

        UserForm user;
        Optional<UserModel> userModelOptional = userRepository.findById(id);
        if(userModelOptional.isPresent()) userModel = userModelOptional.get();

        user = UserConverter.toForm(userModel);

        return user;
    }

    public List<UserForm> getAll() {
        List<UserForm> allUsers = new ArrayList<>();
        List<UserModel> allUserModels = new ArrayList<>();

        allUserModels = userRepository.findAll();

        for(UserModel u : allUserModels){
            allUsers.add(UserConverter.toForm(u));
            System.out.println(u.getLogin());
        }

        return allUsers;
    }
}
