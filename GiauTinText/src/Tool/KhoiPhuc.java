package Tool;

import java.io.IOException;
import java.nio.file.Path;

public class KhoiPhuc {

    // tinh nang khoi phuc tin giau
    public static String khoiPhuc(Path duongDan) throws IOException {
		return GiaiMa.layThongDiepAnTrongFile(duongDan);
    }

}
