import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class QuantizingProgram {

    public static void main(String[] args) {
        QuantizingProgram program = new QuantizingProgram();
        // Reading the image file
        BufferedImage img = program.readFile("C:/Users/Marwa/OneDrive/Bilder/wuerfel.jpg"); // Specify the image path
        if (img != null) {
            // Convert the image after reading
            BufferedImage quantizedImage = program.convertImage(img);
            // Save the quantized image
            program.saveImage(quantizedImage, "C:/Users/Marwa/Downloads/quantized_image.jpg");
        }
    }

    // Method to read the image file
    private BufferedImage readFile(String pathToFile) {
        try {
            return ImageIO.read(new File(pathToFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to process and quantize the image
    private BufferedImage convertImage(BufferedImage source) {
        int width = source.getWidth();
        int height = source.getHeight();
        BufferedImage quantizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Iterate over all pixels to modify them
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = source.getRGB(x, y);

                // Extracting the color channels
                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;

                // Quantizing the RGB values (reduce color depth)
                int newR = (r / 32) * 32;
                int newG = (g / 32) * 32;
                int newB = (b / 64) * 64;

                // Recombine the quantized RGB values
                int newRGB = (newR << 16) | (newG << 8) | newB;
                quantizedImage.setRGB(x, y, newRGB);
            }
        }
        return quantizedImage;
    }

    // Method to save the image to a file
    private void saveImage(BufferedImage image, String outputPath) {
        try {
            File output = new File(outputPath);
            ImageIO.write(image, "jpg", output);
            System.out.println("Image successfully saved at: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error while saving the image.");
            e.printStackTrace();
        }
    }
}
