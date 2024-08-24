package Tool;

import java.io.IOException;
import java.nio.file.Path;

public class GiauTin {

    public static void giauTin(String tinGiau, Path duongDan) throws IOException 
    {
        String tinGiauKhoangTrang = MaHoa.maHoa(tinGiau); 
        GhiFile.ghiFile(duongDan, tinGiauKhoangTrang); 

        System.out.println("GIAU TIN THANH CONG !");
    }
}
