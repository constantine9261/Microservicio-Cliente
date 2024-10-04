package com.banking.nttdataProyectoI.model.api.shared.header;

import com.banking.nttdataProyectoI.util.Constants;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@JacksonAnnotationsInside
@JsonProperty("utc-zone")
@Size(
        min = 9,
        max = 9
)
@Parameter(
        description = "Zona horaria del cliente que invoca el servicio.",
        name = "utc-zone",
        in = ParameterIn.HEADER,
        schema = @Schema(
                type = "string",
                example = Constants.DEFAULT_UTC_ZONE,
                minLength = 9,
                maxLength = 9
        )
)
@Constraint(
        validatedBy = {}
)
public @interface UtcZoneHeader {
  String message() default "default";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
