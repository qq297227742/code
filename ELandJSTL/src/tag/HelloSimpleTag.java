package tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class HelloSimpleTag implements SimpleTag {
    private String value;
    private String  count;

    public void setValue(String value) {
        this.value = value;
    }

    public void setCount(String count) {
        this.count = count;
    }

    //标签体逻辑实际应该编写到该方法中。
    @Override
    public void doTag() throws JspException, IOException {
//        System.out.println("value:"+value+",count"+count);
//
//        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//        pageContext.getOut().print("Hello :" + request.getParameter("name"));
        JspWriter out = pageContext.getOut();
        int c=0;

        c = Integer.parseInt(count);
        for (int i = 0; i < c; i++) {
            out.print(value);
            out.print("<br>");
        }

    }

    @Override
    public void setParent(JspTag jspTag) {
        System.out.println("setParent");
    }

    @Override
    public JspTag getParent() {
        System.out.println("getParent");
        return null;
    }

    private PageContext pageContext;

    //JSP 引擎调用，把代表 JSP 页面的PageContext 对象传入
    //PageContext 可以获取 JSP 页面的其它8个隐含对象。
    //所以凡是 JSP 页面可以做的 标签处理器都可以完成。
    @Override
    public void setJspContext(JspContext jspContext) {
        System.out.println(jspContext instanceof PageContext);
        pageContext = (PageContext) jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        System.out.println("setJspBody");
    }
}
