package quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import quarkus.entity.Temperatura;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
public class TemperaturaService implements ITemperaturaService {
    private List<Temperatura> temperaturas = new ArrayList<>();

    public Temperatura addTemperatura (Temperatura temperatura) {
        temperaturas.add(temperatura);
        return temperatura;
    }

    public List<Temperatura> getTemperaturas(){
        return temperaturas;
    }

    @Override
    public int getMayor() {
        return
                temperaturas
                        .stream()
                        .mapToInt(Temperatura::getMax)
                        .max()
                        .orElseThrow(
                                () -> new NoSuchElementException("No hay temperaturas registradas")
                        );
    }
}
