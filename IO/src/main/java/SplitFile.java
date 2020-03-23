

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 面向对象思想封装 分割
 *
 */
public class SplitFile {
    //源头
    private File src;
    //目的地（文件夹）
    private String destDir;
    //所有分割后的文件存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //块数;多少块
    private int size;

    public SplitFile(String  srcPaht, String destDir, int blockSize) {
        this.src = new File(srcPaht);
        this.destDir=destDir;
        this.blockSize=blockSize;
        this.destPaths=new ArrayList<>();

        //初始化
        init();
    }
    private void init(){
        long len = this.src.length();
        //多少块
         this.size = (int) Math.ceil(len * 1.0 / blockSize);
         //路径
        for (int i = 0; i < size; i++) {
            this.destPaths.add(this.destDir + i + this.src.getName());
        }
    }

    /**
     * 分割
     * 1、计算每一块的起始位置以及大小
     * 2、分割
     */

    public void split() throws IOException {
        //起始位置、实际大小
        long len = this.src.length();
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
            splitDetail(i,beginPos,actualSize);
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
    private void splitDetail(int i,int beginPos,int actualSize) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.src, "r");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.destPaths.get(i), "rw");

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
//                System.out.println(new String(flush,0,len));
                randomAccessFile2.write(flush,0,len);
                actualSize-=len;
            } else {
//                System.out.println(new String(flush,0,actualSize));
                randomAccessFile2.write(flush,0,actualSize);
                break;
            }
        }
        randomAccessFile2.close();
        randomAccessFile.close();
    }
    public void merge(String destPath) {
        //输出流
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destPath,true))) {

            Vector<InputStream> inputStreamVector=new Vector<>();

            SequenceInputStream sequenceInputStream = null;
            for (int i = 0; i < this.destPaths.size(); i++) {
                inputStreamVector.add(new BufferedInputStream(new FileInputStream(this.destPaths.get(i))));
            }
            sequenceInputStream = new SequenceInputStream(inputStreamVector.elements());
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = sequenceInputStream.read(flush)) != -1) {
                outputStream.write(flush,0,len);
            }
            outputStream.flush();
            sequenceInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输入流
    }
}
