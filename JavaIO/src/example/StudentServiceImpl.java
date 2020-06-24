package example;

import java.io.File;
import java.util.Arrays;

public class StudentServiceImpl implements IStudentService {
    private static final File SAVE_FILE = new File("E:" + File.separator + "test" + File.separator + "test.txt");
    private String content;
    private Student [] students;
    public StudentServiceImpl(){
        //this.content = FileUtil.load(SAVE_FILE);
        //this.handle();
    }
    private void handle(){
        if(this.content == null || "".equals(this.content)){
            return;
        }
        String [] result = this.content.split("\\|");
        this.students = new Student[result.length];
        for(int x = 0; x < this.students.length; x++){
            String temp [] = result[x].split(":");
            this.students[x] = new Student(temp[0],Double.parseDouble(temp[1]));
        }
    }

    @Override
    public void append(String str) {
        if(str.startsWith("|")){
            str = str.substring(1);
        }
        if(!str.endsWith("|")){
            str = str + "|";
        }
        FileUtil.append(SAVE_FILE,str);
    }

    @Override
    public Student[] getData() {
        this.content = FileUtil.load(SAVE_FILE);
        this.handle();
        return this.students;
    }
}
