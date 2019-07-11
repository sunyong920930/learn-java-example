package lean.java.example.BloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 判断一个字符串是否在一个文件中
 * 通过Scanner读文件流
 */
public class BloomFilterTest {

    /**
     * BloomFilter 预估数据总量
     */
    private static int fileMaxContenNum = 843194946;


    public static void main(String[] args){

        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), fileMaxContenNum);
        try {
            FileInputStream fis = new FileInputStream("D:\\mob_workspace\\learn-java-example\\src\\main\\resource\\5884.35.txt");
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                bloomFilter.put(line);
            }
            if(bloomFilter.mightContain("aaaa")){
                System.out.println("1111");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
