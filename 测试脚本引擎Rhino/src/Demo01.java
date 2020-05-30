import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 测试脚本引擎JavaScript代码
 */
public class Demo01 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        //获得脚本引擎对象
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("javascript");

        //定义变量,存储到引擎上下文中
        engine.put("msg","I am a good man");
        String str="var user = {name:'gaoqi',age:18,schools:['清华大学','北京大学']};";
        str += " print(user.name);";

        //执行脚本
        engine.eval(str);
        engine.eval("msg = 'sxt is a good school';");

        System.out.println(engine.get("msg"));
        System.out.println("##########################");


        //定义函数
        engine.eval("function add(a,b){var sum = a + b; return sum;}");
        //取得调用接口
        Invocable jsInvoke = (Invocable) engine;
        //执行脚本中定义的方法
        Object result = jsInvoke.invokeFunction("add", new Object[]{13, 21});
        System.out.println(result);

        //导入其他java包，使用其他包中的Java类,若需要深入了解细节，可以详细学习Rhino的语法
        String jsCode = "; var list=java.util.Arrays.asList([\"北京大学\",\"清华大学\"]);";
        engine.eval(jsCode);

        List<String> list = (List) engine.get("list");
        for (String o : list) {
            System.out.println(o);
        }



        //执行js文件（将a.js置于项目src下即可）
        URL url = Demo01.class.getClassLoader().getResource("a.js");
        FileReader fileReader=new FileReader(url.getPath());
        engine.eval(fileReader);
        fileReader.close();//由于是测试，就不那么规范了，实际使用时用try catch finally
    }
}
