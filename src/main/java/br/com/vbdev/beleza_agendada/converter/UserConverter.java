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

        //Converter UserModel para UserForm

        userForm.setEmail(user.getUsername());
        userForm.setName(user.getFullName());
        userForm.setPhone(user.getPhone());
        userForm.setBirth_date(user.getBirth_date());

        userForm.setImage_path(user.getImage_path());

        //Converter AddressModel para AddressForm
        addressForm.setAddress(user.getAddress().getAddress());
        addressForm.setDistrict(user.getAddress().getDistrict());
        addressForm.setZip_code(user.getAddress().getZip_code());
        userForm.setAddress(addressForm);

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

        userModel.setPhone(user.getPhone());
        userModel.setBirth_date(user.getBirth_date());

        userModel.setImage_path(user.getImage_path());
//        userModel.setLogin(user.getLogin());

        //Converter AddressForm para AddressModel
        addressModel.setAddress(user.getAddress().getAddress());
        addressModel.setDistrict(user.getAddress().getDistrict());
        addressModel.setZip_code(user.getAddress().getZip_code());

        userModel.setAddress(addressModel);

        //Converter UserTypeForm para UserTypeModel
        userTypeModel.setUser_type(user.getUserType().getUser_type());

        userModel.setUserType(userTypeModel);
        userModel.setLogintype(user.getLogintype());

        return userModel;
    }

}
