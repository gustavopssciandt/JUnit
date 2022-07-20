package org.acme.openapi.swaggerui.swagger;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
            @Tag(name = "Secure")
        },
        info = @Info(
            title="Manager API VIVO MVE",
            version = "1.0.1",
            description = "Just an example service vivo b2b",
            contact = @Contact(
                name = "Example API Support",
                url = "http://exampleurl.com/contact",
                email = "techsupport@example.com")))
public class OpenApiSwagger extends Application {
}
