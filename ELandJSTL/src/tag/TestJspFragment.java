package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class TestJspFragment extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment bodyContent = getJspBody();
        //JspFragment.invoke(Writer)：writer 即为标签体内容输出的字符流，
        //若为 null ，则输出到 getJspContext().getOut()，即输出到页面上
//        bodyContent.invoke(null);

        //1.利用 StringWriter 得到标签体的内容
        StringWriter stringWriter=new StringWriter();
        bodyContent.invoke(stringWriter);

        //2.把标签体的内容都变为大写
        String content = stringWriter.toString().toUpperCase();

        //3. 获取JSP 页面的 out 隐含对象，输出到页面上
        getJspContext().getOut().print(content);


    }
}
