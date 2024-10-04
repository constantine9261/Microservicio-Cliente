package com.banking.nttdataProyectoI.model.api.shared.header;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;




@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@JacksonAnnotationsInside
@JsonProperty("Ocp-Apim-Subscription-Key")
@Size(
        min = 32,
        max = 32
)
@Pattern(
        regexp = "^[a-z0-9]{32}$"
)
@Parameter(
        description = "Identificador de suscripción, este campo es obtenido al momento "
                + "de la suscripción.",
        name = "Ocp-Apim-Subscription-Key",
        in = ParameterIn.HEADER,
        schema = @Schema(
                type = "string",
                minLength = 32,
                maxLength = 32,
                pattern = "^[a-z0-9]{32}$",
                example = "3cfdad6e03c24d0ab7112dce75cdba35"
        ),
        required = true
)
@Constraint(
        validatedBy = {}
)
public @interface OcpApimSuscriptionKeyHeader {
  String message() default "default";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
