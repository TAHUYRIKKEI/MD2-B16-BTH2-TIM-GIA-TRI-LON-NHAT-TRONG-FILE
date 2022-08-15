package rikkei.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filepath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filepath);

            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        }
        catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("file ko ton tai or noi dung co loi");
        }
        return  numbers;

    }
    public void writeFile(String filePath , int max){
        try {
            FilterWriter writer = new FilterWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("gia tri lon nhat la:" + max);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
