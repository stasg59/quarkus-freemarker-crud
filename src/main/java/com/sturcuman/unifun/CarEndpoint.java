package com.sturcuman.unifun;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.quarkiverse.freemarker.TemplatePath;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/")
public class CarEndpoint {

    @Inject
    @TemplatePath("home.ftlh")
    Template home;

    @Inject
    @TemplatePath("create-update.ftlh")
    Template creatUpdate;

    @Inject
    CarResource carResource;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAllCarView()
            throws TemplateException, IOException {
        List<Car> cars = carResource.getCars();
        StringWriter stringWriter = new StringWriter();
        home.process(Map.of("cars", cars), stringWriter);
        return stringWriter.toString();
    }

    @GET
    @Path("/create")
    @Produces(MediaType.TEXT_HTML)
    public String createCarView()
            throws TemplateException, IOException {
        Car car = new Car();
        Map<String, Object> obj = new HashMap<>();
        StringWriter stringWriter = new StringWriter();
        obj.put("car", car);
        obj.put("isUpdate", false);
        creatUpdate.process(obj, stringWriter);
        return stringWriter.toString();
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/create")
    public String createCar
            (@FormParam("type") String type,
             @FormParam("model") String
                     model, @FormParam("color") String color)
            throws TemplateException, IOException {
        Car car = new Car();
        car.setColor(color);
        car.setType(type);
        car.setModel(model);
        carResource.addCar(car);
        return getAllCarView();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/update/{id}")
    public String updateCar(@PathParam("id") Long id)
            throws TemplateException, IOException {
        Car car = carResource.getCar(id);
        Map<String, Object> obj = new HashMap<>();
        StringWriter stringWriter = new StringWriter();
        obj.put("car", car);
        obj.put("isUpdate", true);
        creatUpdate.process(obj, stringWriter);
        return stringWriter.toString();
    }

    @POST
    @Path("/update/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String createCar(@FormParam("type") String type,
                            @FormParam("model") String
                                     model, @FormParam("color")
                                         String color,
                            @PathParam("id") Long id)
            throws TemplateException, IOException {
        Car car = new Car();
        car.setColor(color);
        car.setType(type);
        car.setModel(model);
        car.setId(id);
        carResource.updateCar(car);
        return getAllCarView();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/delete/{id}")
    public String deleteCar(@PathParam("id") Long id)
            throws TemplateException, IOException {
        carResource.deleteCar(id);
        return getAllCarView();
    }
}