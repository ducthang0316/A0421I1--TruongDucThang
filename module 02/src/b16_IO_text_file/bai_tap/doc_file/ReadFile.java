package b16_IO_text_file.bai_tap.doc_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private static final String COMMA = ",";

    public static List<Country> readFile(String path) throws IOException {
        List<Country> countries = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(COMMA);
                int id = Integer.parseInt(data[0]);
                String code = data[1];
                String name = data[2];
                countries.add(new Country(id, code, name));
            }
        } catch (Exception e) {
            System.out.println("File is not existed or errored");
        } finally {
            bufferedReader.close();
        }

        return countries;
    }

    public static void main(String[] args) {
        List<Country> countryList = null;

        try {
            countryList = ReadFile.readFile("E:\\A0421I1- TruongDucThang\\module 02\\src\\b16_IO_text_file\\bai_tap\\doc_file\\country");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Country country : countryList){
            System.out.println(country);
        }
    }
}
