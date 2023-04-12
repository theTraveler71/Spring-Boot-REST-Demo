package net.must.data;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


@Component
public class DataLoader
{
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository)
    {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData()
    {
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Cafè Cereza"), 
                new Coffee("Cafè Ganador"),
                new Coffee("Cafè Lareño"), 
                new Coffee("Cafè Três Pontas")));
    }
}
