package com.example.chartographer.service.impl;

import com.example.chartographer.service.ImageCreatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
public class PapyrusImageCreatorServiceImpl implements ImageCreatorService {

    private static final String imagePath = "./src/main/resources/images/Papyrus";
    private static Path imageStoragePath;
    static {
        try {
            imageStoragePath = Paths.get(imagePath);
            Files.createDirectories(imageStoragePath);
            log.info("{}", "Papyrus image storage created or existed at " + imagePath);
        } catch (IOException e) {
            log.info("{}", "Failed to create image storage at " + imagePath);
        }
    }

    private static BufferedImage map(int sizeX, int sizeY ){
        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
        for (int x = 0; x < sizeX; x++){
            for (int y = 0; y < sizeY; y++){
                res.setRGB(x, y, Color.WHITE.getRGB() );
            }
        }
        return res;
    }

    private static void savePNG( final BufferedImage bi, final String path ){
        try {

            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
            //ImageIO.write(rendImage, "PNG", new File(path));
            //ImageIO.write(rendImage, "jpeg", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UUID createImage(Integer width, Integer height) {

        // create BMP image
        width = 20;
        height = 50;

        UUID imgUuid = UUID.randomUUID();
        BufferedImage img = map( width, height );
        savePNG( img, imagePath + "/" + imgUuid + ".bmp" );

        return UUID.randomUUID();
    }
}
