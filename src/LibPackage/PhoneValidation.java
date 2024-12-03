/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibPackage;

import java.util.regex.Pattern;

/**
 *
 * @author moham
 */
 public class PhoneValidation {
    private static final String PHONE_REGEX = "^[+]?[0-9]{1,3}?[0-9]{7,14}$";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_REGEX, phoneNumber);
    }
}
