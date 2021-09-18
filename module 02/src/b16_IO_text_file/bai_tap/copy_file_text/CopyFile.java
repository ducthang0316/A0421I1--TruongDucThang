package b16_IO_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static List<String> readFile (String path ) throws IOException {
        List<String> list  = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try{
            File file = new File(path);
            if (!file.exists()){
                throw new FileNotFoundException();
            }

            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                if (line.isEmpty()){
                    continue;
                }
                String [] data = line.split("");
                for (String str: data ) {
                    list.add(str);
                }
            }
        } catch (Exception e){
            System.out.println("File is not existed or errored");
        } finally {
            bufferedReader.close();
        }
        return list;
    }

    public static void writeFile (String path, List<String> sourceText) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String str : sourceText) {
                bufferedWriter.write(str);
            }
            bufferedWriter.newLine();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public static void main(String[] args) throws IOException {
        CopyFile copyFile = new CopyFile();
        List<String> sourceText = copyFile.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\b16_IO_text_file\\bai_tap\\copy_file_text\\sourceText");
        copyFile.writeFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\b16_IO_text_file\\bai_tap\\copy_file_text\\targetText", sourceText);
    }
}
