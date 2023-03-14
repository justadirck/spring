package boot.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "TEAMMATE")
    public Set<Person> teammates;

    public Person() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void worksWith(Person person) {
        if (this.teammates == null) {
            this.teammates = new HashSet<>();
        }
        this.teammates.add(person);
    }

    public String toString() {

        return this.name + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                        Collections.emptySet()).stream()
                        .map(Person::getName)
                        .collect(Collectors.toList());
    }


}