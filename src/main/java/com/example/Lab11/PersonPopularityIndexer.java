package com.example.Lab11;

import com.example.Lab11.entities.PersonEntity;

public class PersonPopularityIndexer implements Comparable<PersonPopularityIndexer>
{
    private PersonEntity person;
    int popularity;

    public PersonPopularityIndexer(PersonEntity person)
    {
        this.person = person;
        popularity = 1;
    }

    public void incrementPopularity()
    {
        popularity++;
    }

    public String getCnp() {
        return person.getCnp();
    }

    public int getPopularity() {
        return popularity;
    }

    public PersonEntity getPerson() {
        return person;
    }

    @Override
    public int compareTo(PersonPopularityIndexer o)
    {
        if (this.popularity < o.popularity)
            return 1;

        if (this.popularity > o.popularity)
            return -1;

        return 0;
    }
}
