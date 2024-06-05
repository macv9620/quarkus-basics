package quarkus.service;

import quarkus.entity.Temperatura;

import java.util.List;

public interface ITemperaturaService {

    Temperatura addTemperatura (Temperatura temperatura);

    List<Temperatura> getTemperaturas();

    int getMayor();
}
