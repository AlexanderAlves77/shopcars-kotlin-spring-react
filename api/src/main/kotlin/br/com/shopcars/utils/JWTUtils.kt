package br.com.shopcars.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component

@Component
class JWTUtils {

    private val chaveSeguranca = "MinhaChaveDeSegurancaSuperSecretaKotlinNaoCompartilhar"

    fun gerarToken(idUsuario : String) : String {
        return Jwts.builder()
            .setSubject(idUsuario)
            .signWith(SignatureAlgorithm.ES512, chaveSeguranca.toByteArray())
            .compact()
    }
}