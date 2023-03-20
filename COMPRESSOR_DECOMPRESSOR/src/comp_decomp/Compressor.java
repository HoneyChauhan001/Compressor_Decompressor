package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) throws IOException{
        /*
        Method to compress the file,
        logic -->
        read file using FileInoutStream -> Compress using GZIPOutputStream -> Write new compressed file using FileOutputStream
         */

        String fileDirectory = file.getParent();//get parent folder path to store our compressed file in same folder

        FileInputStream fis = new FileInputStream(file);
        /*
        This line creates a FileInputStream object named fis and initializes it with the input File object.
         */
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");
        /*
        This line creates a FileOutputStream object named fos and initializes it with the output file path.
        This will write the compressed data to a new file named "DecompressedFileCheck.txt" in the same directory as the original Decompressed file.
         */

        GZIPOutputStream gzip = new GZIPOutputStream(fos);//output file => compress the output stream file
        /*
        This line creates a GZIPInputStream object named gzip and initializes it with the FileOutputStream object fos.
        This allows to compress the file into Output Stream
         */


        byte[] buffer = new byte[1024];
        /*
        This line creates a byte array named buffer with a size of 1024 bytes.
        This array is used to temporarily store data read from the decompressed file
         */

        int len;
        while((len=fis.read(buffer))!=-1){
            gzip.write(buffer,0,len);//write array of bytes to the compressed output stream
        }
        gzip.close();
        fis.close();
        fos.close();

    }

    public static void main(String[] args) throws IOException {
        File path = new File("");//address of file => example
    }
}
