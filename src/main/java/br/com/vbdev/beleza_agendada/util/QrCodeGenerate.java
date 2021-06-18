package br.com.vbdev.beleza_agendada.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QrCodeGenerate {

    public static String generateQrCode(Long id, String prefix) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String year = format.format(date);

        String qrCode = "#" + prefix + year + id.toString();
        System.out.println(qrCode);
        return qrCode;
    }
}
