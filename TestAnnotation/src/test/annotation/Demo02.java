package test.annotation;

@Annotation01
public class Demo02 {

    @Annotation01(age = 19,studentName = "老高",id = 1001,
            schools = {"北京大学","南京大学"})
    public void test() {

    }
    @Annotation02(value = "aaaaa")
    public void test02(){

    }
}
