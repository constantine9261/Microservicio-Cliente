package com.banking.nttdataProyectoI.model.api.shared.header;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@JacksonAnnotationsInside
@JsonProperty("user-code")
@Pattern(
        regexp = "^[A-Z0-9]+$"
)
@Size(
        min = 4,
        max = 4
)
@NotNull
@Parameter(
        description = "Codigo de la aplicacion  que invoca el servicio. Se debe usar el codigo "
                + "de 4 caracteres que tienen asignada las aplicaciones, puede ser el canal.",
        name = "user-code",
        in = ParameterIn.HEADER,
        schema = @Schema(
                type = "string",
                example = "T10290",
                minLength = 4,
                maxLength = 4,
                pattern = "^[A-Z0-9]+$"
        )
)
@Constraint(
        validatedBy = {}
)
public @interface UserCodeHeader {
  String message() default "default";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
