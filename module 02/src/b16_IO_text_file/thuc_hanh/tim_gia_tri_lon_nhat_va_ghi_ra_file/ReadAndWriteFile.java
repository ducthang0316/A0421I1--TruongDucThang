package b16_IO_text_file.thuc_hanh.tim_gia_tri_lon_nhat_va_ghi_ra_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e){
            System.out.println("File is not existed or errored");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max){
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write("the max value is: " + max);
            bufferedWriter.close();
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static int findMax (List<Integer> list){
        int max = list.get(0);
        for (int i =0; i < list.size(); i++){
            if (max < list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\b16_IO_text_file\\thuc_hanh\\tim_gia_tri_lon_nhat_va_ghi_ra_file\\number");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\b16_IO_text_file\\thuc_hanh\\tim_gia_tri_lon_nhat_va_ghi_ra_file\\result" , maxValue);
    }
}
