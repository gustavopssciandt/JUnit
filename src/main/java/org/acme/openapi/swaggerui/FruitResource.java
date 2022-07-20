package org.acme.openapi.swaggerui;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/fruits")
@Tag(name = "Secure")
public class FruitResource {

    private static final String NAME_FRUIT = "Orange";

    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    @Path("/list")
    @Operation(summary = "List Fruits", description = "Find fruits for mongoDB")
    public Set<Fruit> list() {
        return fruits;
    }

    @GET
    @Path("/header")
    @Operation(summary = "Find Fruit", description = "Find fruits for header param")
    public Set<Fruit> find(@HeaderParam("nameFruit") final String nameFruit) {

        return fruits.stream().filter(fruit -> fruit.getName().equals(nameFruit)).collect(Collectors.toSet());

    }

    @GET
    @Path("/path/{pathParamTeste}")
    @Operation(summary = "Find Fruits", description = "Find fruits for path param")
    public Set<Fruit> path(@PathParam("nameFruit") final String nameFruit) {
        return fruits.stream().filter(fruit -> fruit.getName().equals(nameFruit)).collect(Collectors.toSet());
    }

    @GET
    @Path("/query")
    @Operation(summary = "Find Fruits", description = "Find fruits for query param")
    public Set<Fruit> query(@QueryParam("nameFruit") final String nameFruit) {
        return fruits.stream().filter(fruit -> fruit.getName().equals(nameFruit)).collect(Collectors.toSet());
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        if (NAME_FRUIT.equals(fruit.getName())){
            throw new RuntimeException();
        }
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }
}
