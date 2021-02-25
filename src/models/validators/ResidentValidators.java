package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Resident;

public class ResidentValidators {
    public static List<String>validate(Resident r ){
        List<String>errors = new ArrayList<String>();

        String error = _validateRoom(r.getRoom());
        if(!error.equals("")){
            errors.add(error);
        }
        return errors;

    }
    private static String _validateRoom(String room ){
        if(room == null || room.equals("")){
            return "部屋番号を入力してください。";
        }
        return "";
}
}
