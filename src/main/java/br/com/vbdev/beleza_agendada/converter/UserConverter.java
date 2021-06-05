package br.com.vbdev.beleza_agendada.converter;

import br.com.vbdev.beleza_agendada.model.AddressModel;
import br.com.vbdev.beleza_agendada.model.UserModel;
import br.com.vbdev.beleza_agendada.model.UserTypeModel;
import br.com.vbdev.beleza_agendada.model.form.AddressForm;
import br.com.vbdev.beleza_agendada.model.form.UserForm;
import br.com.vbdev.beleza_agendada.model.form.UserTypeForm;

public class UserConverter {

    public static UserForm toForm(UserModel user) {
        UserForm userForm = new UserForm();
        AddressForm addressForm = new AddressForm();
        UserTypeForm userTypeForm = new UserTypeForm();
        userForm.setId(user.getId());
     //   System.out.println(user.getLogin());
        //Converter UserModel para UserForm
        userForm.setName(user.getName());
        userForm.setEmail(user.getEmail());
        userForm.setPhone(user.getPhone());
        userForm.setBirth_date(user.getBirth_date()); // TODO Talvez seja necessário converter aqui

        userForm.setImage_path(user.getImage_path());
        userForm.setLogin(user.getLogin());

        //Converter AddressModel para AddressForm
        addressForm.setAddress(user.getAddress().getAddress());
        addressForm.setDistrict(user.getAddress().getDistrict());
        addressForm.setZip_code(user.getAddress().getZip_code());
        userForm.setAddress(addressForm);

     //   System.out.println(user.getAddress().getAddress());
     //   System.out.println(user.getUserType().getUser_type());
        //Converter UserTypeModel para UserTypeForm
        userTypeForm.setUser_type(user.getUserType().getUser_type());

        userForm.setUserType(userTypeForm);
        userForm.setLogintype(user.getLogintype());
        return userForm;
    }

    public static UserModel toModel(UserForm user) {
         UserModel userModel = new UserModel();
         UserForm userForm = new UserForm();
        AddressModel addressModel = new AddressModel();
        UserTypeModel userTypeModel = new UserTypeModel();
        //Converter UserForm para UserModel
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword()); //TODO Precisa Criptografar senha
        userModel.setPhone(user.getPhone());
        userModel.setBirth_date(user.getBirth_date()); // TODO Talvez seja necessário converter aqui

        userModel.setImage_path(user.getImage_path());
        userModel.setLogin(user.getLogin());

        //Converter AddressForm para AddressModel
        addressModel.setAddress(user.getAddress().getAddress());
        addressModel.setDistrict(user.getAddress().getDistrict());
        addressModel.setZip_code(user.getAddress().getZip_code());

        // addressRepository.save(addressModel);
        userModel.setAddress(addressModel);

        //Converter UserTypeForm para UserTypeModel
        userTypeModel.setUser_type(user.getUserType().getUser_type());

        //userTypeRepository.save(userTypeModel);
        userModel.setUserType(userTypeModel);
        userModel.setLogintype(user.getLogintype());
        // userRepository.save(userModel);
        return userModel;
    }

}
