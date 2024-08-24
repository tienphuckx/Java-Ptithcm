package Tool;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class GhiFile {

    // ham ghi file
    // ghi them noi dung, khong ghi de len noi dung da co
    public static void ghiFile(Path duongDan, String noiDung) throws IOException {
        File file = new File(String.valueOf(duongDan));
        boolean newFile = file.createNewFile(); // tao file moi
        if (newFile) { // neu file chua ton tai
            Files.write(duongDan, noiDung.getBytes());
        } else { // neu file da ton tai - ghi tiep noi dung
            String content = new String(Files.readAllBytes(duongDan), StandardCharsets.UTF_8).trim();
            String noiDungMoi = content.concat(noiDung);
            Files.write(duongDan, noiDungMoi.getBytes());
        }
    }
}
