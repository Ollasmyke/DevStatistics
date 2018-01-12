package com.webapp;

import com.google.gson.Gson;

public class ArrayHolder {
    public static void main (){
        Gson gson = new Gson();
//        int one;

        Object numbers = null;
        String countLangOne = gson.toJson(numbers);


    }
}
