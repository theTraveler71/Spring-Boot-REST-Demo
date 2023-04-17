package net.must;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.must.data.Coffee;
import net.must.data.CoffeeRepository;

@RestController
@RequestMapping("/coffees")
public class RestApiController
{
    private final CoffeeRepository coffeeRepository;

    public RestApiController(CoffeeRepository coffeeRepository)
    {
        this.coffeeRepository = coffeeRepository;

    }

    @GetMapping
    Iterable<Coffee> getCoffees()
    {
        return this.coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id)
    {

        return this.coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee)
    {
        return this.coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee)
    {

        return (coffeeRepository.existsById(id)) ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
                : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void delerCoffee(@PathVariable String id)
    {
        coffeeRepository.deleteById(id);
    }
}
