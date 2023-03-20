package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) throws IOException{
        /*
        Method to compress the file,
        logic -->
        read file using FileInoutStream -> read Compressed file correctly using GZIPOutputStream -> Write new decompressed file using FileOutputStream
         */
        String fileDirectory = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        /*
        This line creates a FileInputStream object named fis and initializes it with the input File object.
         */
        GZIPInputStream gzip = new GZIPInputStream(fis);
        /*
        This line creates a GZIPInputStream object named gzip and initializes it with the FileInputStream object fis.
        This allows the decompressor to read a GZIP compressed file
         */
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile");//write decompressed file
        /*
        This line creates a FileOutputStream object named fos and initializes it with the output file path.
        This will write the decompressed data to a new file named "DecompressedFileCheck.txt" in the same directory as the original compressed file.
         */

        byte[] buffer = new byte[1024];
        /*
        This line creates a byte array named buffer with a size of 1024 bytes.
        This array is used to temporarily store data read from the compressed file
         */

        int len;
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        gzip.close();
        fis.close();
        fos.close();
        /*
        These lines close the input and output streams to release system resources and ensure that all data is written to the output file.
         */
    }

    public static void main(String[] args) throws IOException {
        File path = new File("");

    }
}
