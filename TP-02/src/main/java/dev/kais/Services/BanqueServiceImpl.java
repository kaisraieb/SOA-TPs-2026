package dev.kais.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dev.kais.Entities.Compte;
import jakarta.jws.WebService;

@WebService
public class BanqueServiceImpl implements BanqueService {

    public double convertionEuroToDinar(double montont) {
        return montont * 3.5;
    }

    public Compte getCompte(long code) {
        return new Compte(code, 1000 + Math.random() * 9000, new Date());
    }

    public List<Compte> getComptes() {
        List<Compte> comptes = new ArrayList<Compte>();

        comptes.add(new Compte(1, 9200, new Date()));
        comptes.add(new Compte(2, 10500, new Date()));
        comptes.add(new Compte(3, 8700, new Date()));

        return comptes;
    }
}
