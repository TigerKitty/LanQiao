import java.io.File;

public class while_showfilename {
        public static void main(String[] args){
            File file = new File("E:\\");
            File[] files = file.listFiles();
            int i = 0;
            while(i<files.length){
                if(files[i].isDirectory()){
                    System.out.println(files[i].getName());
                }
                i++;
            }
        }
}