package net.must.data;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Coffee
{
    @Id
    private String id;
    private String name;

    public Coffee()
    {
        
    }
    
    public Coffee(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Coffee(String name)
    {
        this(UUID.randomUUID().toString() , name);
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}
