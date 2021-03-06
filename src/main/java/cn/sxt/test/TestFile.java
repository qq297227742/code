package cn.sxt.test;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
    public static void main(String[] args) {
        File file = new File("d:/a.txt");
        System.out.println(file);
        file.renameTo(new File("d:/bb.txt"));
        System.out.println(System.getProperty("user.dir"));


        File f2 = new File("gg.txt");
        try {
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File 是否存在" + f2.exists());
        System.out.println("File是否是目录" + f2.isDirectory());
        System.out.println("File是否是文件" + f2.isFile());
        System.out.println("File最后修改时间" + new Date(f2.lastModified()));
        System.out.println("File的大小" + f2.length());
        System.out.println("File的文件名" + f2.getName());
        System.out.println("File的目录路径"+f2.getPath());
        f2.delete();


        File f3 = new File("d:/电影/华语/大陆");
        boolean flag = f3.mkdir();//目录结构中有一个不存在，则不会创建整个目录树
//        boolean flag = f3.mkdirs();//目录结构中有一个不存在也没关系，创建整个目录树
        System.out.println(flag);

    }
}
