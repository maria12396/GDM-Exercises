# QuantizingProgram

## Description:
This project reads an RGB image (24-bit, 8 bits per channel)
and applies scalar quantization to reduce it to an 8-bit image. The processed image is then saved.

## How to Run:
1. Place the image in the root directory (or provide the path in the `QuantizingProgram.java` file).
2. Modify the paths for the input and output images in the code as needed.
3. Run the program using an IDE like IntelliJ IDEA or via the command line.

## Breakdown 
Step 1: Reading the Image File
The readFile method is called to load the image from the specified file path.

If the image is found, it is stored as a BufferedImage object for further processing.
If the image cannot be found or read (e.g., due to an incorrect path), the method will return null and the program will not proceed further.

Step 2: Converting the Image (Quantization)
Once the image is successfully read, it is passed to the convertImage() method, where scalar quantization is applied. This reduces the color depth of the image from 24 bits to 8 bits.

Step 3: Saving the Image
The processed image (after quantization) is saved using the saveImage() method. The output image is saved in .jpg format at the specified file location

## Reading the Image (readFile)
This method takes the path of an image file and reads it into memory as a BufferedImage object using the ImageIO.read() method.

input: Path to the image file (e.g., "C:/path/to/image.jpg").
Output: A BufferedImage object that represents the image, or null if an error occurs.
If the image is not found or can't be read, an error message will be printed, and the method will return null.

## Converting the Image (convertImage)
This method applies scalar quantization to reduce the color depth of the image.
nput: The original image (BufferedImage object).
Output: The quantized image (BufferedImage object) with reduced color depth

## how Scalar Quantization Works:
Each pixel's red, green, and blue components are originally represented by 8 bits (values ranging from 0 to 255).
Red and Green channels: Reduced from 8 bits to 3 bits by dividing by 32 and multiplying back (ranges from 0 to 224).
Blue channel: Reduced from 8 bits to 2 bits by dividing by 64 and multiplying back (ranges from 0 to 192).
This reduces the total color depth from 24 bits per pixel (8 bits per channel) to 8 bits per pixel.

## Saving the Image (saveImage)
The saveImage() method writes the quantized image to the specified file location using ImageIO.write().

Input: The quantized image (BufferedImage) and the output path.
Output: The image is saved to the specified path (e.g., "C:/path/to/quantized_image.jpg").
The method uses ImageIO.write() to save the image in .jpg format. You can change the format to .png or .bmp by modifying the second argument.


## Supported Formats:
- Input: `.jpg`, `.png`, `.bmp`
- Output: `.jpg` (modifiable to `.png` or `.bmp`)

## Requirements:
- Java Development Kit (JDK 8 or later).
