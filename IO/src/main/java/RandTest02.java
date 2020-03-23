

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入RandomAccessFile
 */
public class RandTest02 {
    public static void main(String[] args) throws IOException {
        //分多少快
        File src = new File("C:\\java\\code\\IO\\src\\Copy.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize=1024;
        //多少块
        int size = (int) Math.ceil(len * 1.0 / blockSize);
        System.out.println(size);
        //起始位置、实际大小
        int beginPos = 0;
        int actualSize= blockSize>len? (int) len :blockSize;
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize;
            }
            System.out.println(i+"-->"+beginPos+"-->"+actualSize);
            split(i,beginPos,actualSize);
        }

    }


    /**
     *指定第i快起始位置和实际长度
     * @param i
     * @param beginPos
     * @param actualSize
     * @throws IOException
     */
    //分块思想：起始、实际大小
    public static void split(int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("C:\\java\\code\\IO\\src\\Copy.java"), "r");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File("/"+i+"Copy.java"), "rw");

        //起始位置
//        int beginPos=2;
        //实际大小
//        int actualSize=1026;
        //随机读取
        randomAccessFile.seek(beginPos);
        //读取
        byte[] flush = new byte[1024];
        int len= -1;
        while ((len = randomAccessFile.read(flush)) != -1) {
            if (actualSize>len) {//获取本次读取的所有内容
                System.out.println(new String(flush,0,len));
                randomAccessFile2.write(flush,0,len);
                actualSize-=len;
            } else {
                System.out.println(new String(flush,0,actualSize));
                randomAccessFile2.write(flush,0,actualSize);
                break;
            }
        }
        randomAccessFile2.close();
        randomAccessFile.close();
    }
}
