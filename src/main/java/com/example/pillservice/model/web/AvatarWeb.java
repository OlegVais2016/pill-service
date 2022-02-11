package com.example.pillservice.model.web;

import com.ps.core.validators.image.ImageFormats;
import com.ps.core.validators.image.ImageMeasureSize;
import com.ps.core.validators.image.ValidImageFormat;
import com.ps.core.validators.image.ValidImageSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AvatarWeb {

    @ValidImageFormat(format = ImageFormats.JPG)
    @ValidImageSize(maxSize = 100, imageMeasure = ImageMeasureSize.KILOBYTE)
    private String avatar;

}
