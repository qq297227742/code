package cn.sxt.test;

import java.io.File;

/**
 * s使用递归算法打印目录树
 *
 */
public class PrintFileTree {
    public static void main(String[] args) {
        File file = new File("D:\\资料\\Downloads\\592705337_晴瞳100\\1809期Java+架构全套视频课程【北京尚学堂】");
        printFile(file,0);
    }

    public static void printFile(File file,int level) {
        //输出层数
        for (int i = 0 ; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                printFile(temp,level+1);
            }

        }
    }
}
