import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 写出内容
 */
public class CIOTest04 {
    public static void main(String[] args) throws IOException {
       //写出文件
       FileUtils.write(new File("happy.txt"),"学习是一件伟大的事业\r\n","UTF-8",true );
       FileUtils.writeStringToFile(new File("happy.txt"),"学习是一件伟大的事业\r\n","UTF-8",true );
        FileUtils.writeByteArrayToFile(new File("happy.txt"), "学习是一件幸福的事业\r\n".getBytes("utf-8"), true);

        //写出列表
        List<String> datas = new ArrayList<>();
        datas.add("马云");
        datas.add("马化腾");
        datas.add("马赛克");
        FileUtils.writeLines(new File("happy.txt"), datas,true);

    }
}
