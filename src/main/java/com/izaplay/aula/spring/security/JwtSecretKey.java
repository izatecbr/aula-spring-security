package com.izaplay.aula.spring.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
public class JwtSecretKey {
    public static void main(String[] args) {
        System.out.println(new String(Base64.getEncoder().encode(Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded())));

        //saida ilustrativa
        //25L+x4ic5gLDyYtOsVsLf40sX54Y8SoJ4/oCXqG9p2uzlKsPRiuu8+NRnzsoOEuALfZBT7Xe3pu/d/YQ5ZEdCw==
    }
}
