package br.com.vbdev.beleza_agendada.converter;

import br.com.vbdev.beleza_agendada.model.AddressModel;
import br.com.vbdev.beleza_agendada.model.BeautySalonModel;
import br.com.vbdev.beleza_agendada.model.form.BeautySalonForm;

public class BeautySalonConverter {

    public static BeautySalonModel toModel(BeautySalonForm salonForm) {
        AddressModel addressModel = new AddressModel();
        BeautySalonModel beautySalonModel = new BeautySalonModel();

        beautySalonModel.setName(salonForm.getName());
        beautySalonModel.setCnpj(salonForm.getCnpj());
        beautySalonModel.setEmail(salonForm.getEmail());
        beautySalonModel.setDescription(salonForm.getDescription());
        beautySalonModel.setLogin(salonForm.getLogin());
        beautySalonModel.setPassword(salonForm.getPassword());
        beautySalonModel.setImage_path(salonForm.getImage_path());

        addressModel.setAddress(salonForm.getAddress().getAddress());
        addressModel.setZip_code(salonForm.getAddress().getZip_code());
        addressModel.setDistrict(salonForm.getAddress().getDistrict());
        beautySalonModel.setAddress(addressModel);

        return beautySalonModel;
    }


}
