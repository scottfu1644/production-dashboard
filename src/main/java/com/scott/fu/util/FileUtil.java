package com.scott.fu.util;

import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.util.PDFMergerUtility;
import org.apache.pdfbox.util.PDFTextStripper;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by ScottFu on 2016/1/4.
 */
public class FileUtil {



    public static void mergeImage(String path, List<String> sources) {
        List<BufferedImage> mergedImage = new ArrayList<BufferedImage>();
        BufferedImage image = null;
        try {

            int combinedWidth = 0;
            int combinedHeight = 0;
            for(String source : sources) {
                image = ImageIO.read(new File(source));
                combinedWidth += image.getWidth();
                combinedHeight = image.getHeight();
                mergedImage.add(image);
            }
            BufferedImage combined = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_RGB);
            Graphics g = combined.getGraphics();
            int increaseWidth = 0;
            for(int i = 0 ; i < mergedImage.size(); i++) {
                g.drawImage(mergedImage.get(i), increaseWidth, 0, null);
                increaseWidth += mergedImage.get(i).getWidth();
            }
            // Save as new image
            ImageIO.write(combined, "png", new File(path, "mergedImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTextInPDF(String inputFilePath) {
        PDDocument doc = null;
        try {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            doc = PDDocument.load(inputFilePath);
            return pdfTextStripper.getText(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void cutImage(int x,
                                int y,
                                int widthRange,
                                int heightRange,
                                String inputPath,
                                String outputPath) {
        ImageInputStream iis = null;
        BufferedImage bi = null;
        try {
            iis = ImageIO.createImageInputStream(new File(inputPath));
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(iis);
            ImageReader reader = (ImageReader) iterator.next();
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            Rectangle rectangle = new Rectangle(x, y, widthRange, heightRange);
            param.setSourceRegion(rectangle);

            bi = reader.read(0, param);
            File file = new File(outputPath);
            ImageIO.write(bi, reader.getFormatName(), file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void writePage(String inputPath, String outputPath) {
        PDDocument doc = null;
        try {
            doc = PDDocument.load(new FileInputStream(inputPath));
            PDDocumentCatalog pdDocumentCatalog = doc.getDocumentCatalog();
            List<PDPage> pages = pdDocumentCatalog.getAllPages();
            Iterator<PDPage> i = pages.iterator();
            int count = 1;

            PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();

            InputStream is = null;
            while(i.hasNext()) {
                PDPage page=i.next();
                is = page.getContents().createInputStream();
                pdfMergerUtility.addSource(is);
                count++;
            }
            pdfMergerUtility.setDestinationFileName(outputPath);
            pdfMergerUtility.mergeDocuments();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }

    }

    public static void convertPDF2JPGMerged(String inputPath, String outputPath, Map<Integer,String> regionMap) {
        PDDocument doc = null;
        List<BufferedImage> mergedImage = new ArrayList<BufferedImage>();
        try {
            doc = PDDocument.load(new FileInputStream(inputPath));
            PDDocumentCatalog pdDocumentCatalog = doc.getDocumentCatalog();
            List<PDPage> pages = pdDocumentCatalog.getAllPages();
            Iterator<PDPage> iterator = pages.iterator();
            Integer count = 1;
            String ext = outputPath.substring(outputPath.lastIndexOf(".") + 1);

            BufferedImage biRegion = null;

            int combinedWidth = 0;
            int combinedHeight = 0;

            while(iterator.hasNext()) {
                PDPage page=iterator.next();
                BufferedImage bi = page.convertToImage();
                String[] regionParams = regionMap.get(count).split(",");
                biRegion = bi.getSubimage(
                        Integer.parseInt(regionParams[0]),
                        Integer.parseInt(regionParams[1]),
                        Integer.parseInt(regionParams[2]),
                        Integer.parseInt(regionParams[3])
                );
                combinedWidth += biRegion.getWidth();
                combinedHeight = biRegion.getHeight();
                // Save as new image
                mergedImage.add(biRegion);
                count++;
            }

            BufferedImage combinedImage
                    = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_RGB);
            Graphics g = combinedImage.getGraphics();
            int increaseWidth = 0;
            for(int i = 0 ; i < mergedImage.size(); i++) {
                g.drawImage(mergedImage.get(i), increaseWidth, 0, null);
                increaseWidth += mergedImage.get(i).getWidth();
            }
            // Save as new image
            ImageIO.write(combinedImage, ext, new File(outputPath));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(doc != null) {
                try {
                    doc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
