import java.io.*;

/**
 * 自定义文件系统加载器
 * @author weiwei
 */
public class FileSystemClassLoader extends ClassLoader {

    //com.test.User --> c:/myjava/ com/test/User.class
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        //应该要先查询有没有加载过这个类，如果已经加载，则直接返回加载好的类。如果没有，则加载新的类
        if (loadedClass != null) {
            return loadedClass;
        } else {
            ClassLoader parent = this.getParent();
            Class<?> loadClass = null;//委派给父类加载
            try {
                loadClass = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            }
            if (loadClass != null) {
                return loadClass;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    loadedClass = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return loadedClass;
    }

    private byte[] getClassData(String name) {
        String path = rootDir + "/" + name.replace(".", "/") + ".class";
        InputStream inputStream = null;
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        try {
            inputStream = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = inputStream.read(buffer)) != -1) {
                baos.write(buffer,0,temp);
            }

            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
