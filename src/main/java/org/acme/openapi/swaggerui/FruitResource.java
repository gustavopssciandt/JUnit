package org.acme.openapi.swaggerui;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/fruits")
@Tag(name = "Secure")
public class FruitResource {

    private static final String NAME_FRUIT = "Orange";

    private List<Fruit> fruits = new ArrayList<>();

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    @Path("/list")
    @Operation(summary = "List Fruits", description = "Find fruits for mongoDB")
    public List<Fruit> list() {
        return fruits;
    }

    @GET
    @Path("/header")
    @Operation(summary = "Find Fruit", description = "Find fruits for header param")
    public List<Fruit> find(@HeaderParam("nameFruit") final String nameFruit) {

        return fruits.stream().filter(fruit -> fruit.getName().equals(nameFruit)).collect(Collectors.toList());

    }

    @GET
    @Path("/path/{pathParamTeste}")
    @Operation(summary = "Find Fruits", description = "Find fruits for path param")
    public List<Fruit> path(@PathParam("pathParamTeste") final String nameFruit) {
        if(nameFruit.equals("Maçã")){
            throw new RuntimeException();
        }
        return fruits.stream().filter(fruit -> fruit.getName().equals(nameFruit)).collect(Collectors.toList());
    }

    @GET
    @Path("/query")
    @Operation(summary = "Find Fruits", description = "Find fruits for query param")
    public List<Fruit> query(@QueryParam("nameFruit") final String nameFruit) {
        return fruits.stream().filter(fruit -> fruit.getName().equals(nameFruit)).collect(Collectors.toList());
    }

    @POST
    public List<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }
}
