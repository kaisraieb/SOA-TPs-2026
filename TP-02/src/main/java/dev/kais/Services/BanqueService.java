package dev.kais.Services;

import java.util.List;

import dev.kais.Entities.Compte;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface BanqueService {

    @WebMethod(operationName = "conversionEuroToDinar")
    double convertionEuroToDinar(@WebParam(name = "montant") double montant);

    @WebMethod(operationName = "getCompte")
    Compte getCompte(@WebParam(name = "code") long code);

    @WebMethod(operationName = "getComptes")
    List<Compte> getComptes();
}
