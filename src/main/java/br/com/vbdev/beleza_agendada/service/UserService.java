package br.com.vbdev.beleza_agendada.service;

import br.com.vbdev.beleza_agendada.controller.ProfessionalController;
import br.com.vbdev.beleza_agendada.converter.UserConverter;
import br.com.vbdev.beleza_agendada.model.*;
import br.com.vbdev.beleza_agendada.model.form.AddressForm;
import br.com.vbdev.beleza_agendada.model.form.UserForm;
import br.com.vbdev.beleza_agendada.model.form.UserTypeForm;
import br.com.vbdev.beleza_agendada.model.types.LoginType;
import br.com.vbdev.beleza_agendada.model.types.UserType;
import br.com.vbdev.beleza_agendada.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
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

    @Autowired
    private ProfessionalUserRepository professionalUserRepository;
    private ProfessionalUserModel professionalUserModel = new ProfessionalUserModel();

    @Autowired
    private BeautySalonRepository beautySalonRepository;
    private BeautySalonModel beautySalonModel = new BeautySalonModel();

    @Autowired
    private OpeningHoursBeautySalonRepository openingHoursBeautySalonRepository;
    private OpeningHoursBeautySalonModel openingHoursBeautySalonModel = new OpeningHoursBeautySalonModel();

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
        userModel.setUserName(user.getEmail());
        userModel.setFullName(user.getName());
        userModel.setAccountNonExpired(true);
        userModel.setAccountNonExpired(true);
        userModel.setCredentialsNonExpired(true);
        userModel.setEnabled(true);
        userModel.setPermissions(permission);
        userModel.setAccountNonLocked(true);

        userTypeModel = userTypeRepository.findByUserType(user.getUserType().getUser_type());
        System.out.println(user.getUserType().getUser_type().toString());
        userModel.setUserType(userTypeModel);

        addressRepository.save(userModel.getAddress());

        UserModel created = userRepository.save(userModel);
        if(userModel.getUserType().getUser_type() == UserType.professional)
            createProfessionalProfile(user.getSalonCode(), created.getId());


        return user.getEmail();
    }

    /**
     * @description: Conecta o profissional ao salão selecionado
     * @param salonCode, id */
    private void createProfessionalProfile(String salonCode, Long id) {

        Optional<BeautySalonModel> beautySalonModelOptional
                = beautySalonRepository.findByqrCode(salonCode);

        if(beautySalonModelOptional.isPresent())
            beautySalonModel = beautySalonModelOptional.get();

        professionalUserModel.setBeauty_salon(beautySalonModel);
        professionalUserModel.setQrCode(generateQrCode(id));
        professionalUserModel.setUser(userModel);

        professionalUserRepository.save(professionalUserModel);
    }

    private String generateQrCode(Long id) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String year = format.format(date);

        String qrCode = "#PROF" + year + id.toString();
        System.out.println(qrCode);
        return qrCode;
    }

    public List<UserForm> getAll() {

        List<UserForm> userForms = new ArrayList<>();
        List<UserModel> userModels = userRepository.findAll();

        for(UserModel u : userModels) {

            UserForm userForm = new UserForm();
            userForm.setName(u.getUsername());
            userForm.setImage_path(u.getImage_path());
            AddressForm addressForm = new AddressForm();
            addressForm.setAddress(u.getAddress().getAddress());
            userForm.setAddress(addressForm);

//            System.out.println(u.getUserType().getUser_type());

            UserTypeForm userTypeForm = new UserTypeForm();
//            userTypeForm.setUser_type(u.getUserType().getUser_type());

//            userForm.setUserType(userTypeForm);
//            System.out.println(userForm.getUserType().getUser_type());

            userForms.add(userForm);
            System.out.println(userForm.getAddress().getAddress());
            System.out.println(userForm.getName());
        }

        return userForms;
    }

}
