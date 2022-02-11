package com.example.pillservice.model.web.form17;

import com.ps.core.validators.formType.ValidFormType;
import com.ps.core.validators.image.ImageFormats;
import com.ps.core.validators.image.ImageMeasureSize;
import com.ps.core.validators.image.ValidImageFormat;
import com.ps.core.validators.image.ValidImageSize;
import com.ps.core.validators.letter.ValidForm17Letters;
import com.ps.core.validators.nationalID.NationalIdChecksum;
import com.ps.core.validators.nationalID.NationalIdFormat;
import com.ps.core.validators.sizeListImage.ValidSizeListImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FormSeventeenRequest {

    @Length(min = 3, max = 20,
            message = "First name length should be between 3 and 20 characters")
    @NotBlank(message = "First name cannot be blank")
    @ValidForm17Letters
    private String firstName;

    @Length(min = 3, max = 20,
            message = "Last name length should be between 3 and 20 characters")
    @NotBlank(message = "Last name cannot be blank")
    @ValidForm17Letters
    private String lastName;

    @Email(message = "Email format is incorrect")
    @Length(min = 3, max = 20,
            message = "First name length should be between 3 and 20 characters")
    @NotBlank(message = "First name cannot be blank")
    private String email;

    @NationalIdChecksum
    @NationalIdFormat
    @NotBlank(message = "NationalId is required")
    private String nationalId;

    @NotBlank(message = "FormType cannot be empty")
    @ValidFormType
    private String formType;

    @NotBlank(message = "First name cannot be blank")
    @Size(max = 500, message = "Description exceeds 500 symbols")
    private String description;

    @ValidSizeListImage
    private List<@ValidImageFormat(format = ImageFormats.JPG)
    @ValidImageSize(imageMeasure = ImageMeasureSize.KILOBYTE) String> content;

}
