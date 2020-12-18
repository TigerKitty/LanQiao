import java.io.File;

public class digui_showfilename {
    public static void main(String[] args) {
        File file = new File("E:\\");
        f(file);
    }
    static void f(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
                if (files!=null) {
                    int i = 0;
                    while (i < files.length) {
                        f(files[i]);
                        i++;
                    }
                }
            System.out.println(file.getName());
        }
        }
    }