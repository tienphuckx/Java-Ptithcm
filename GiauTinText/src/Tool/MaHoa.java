package Tool;

public class MaHoa {

    public static String chuyenThanhNhiPhan(String vanBan) 
    {
        byte[] bytes = vanBan.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) 
        {
            int val = b;
            for (int i = 0; i < 8; i++) 
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            //binary.append(' '); // cach ra moi ki tu duoc chuyen thanh nhi phan
        }
        return binary.toString();
    }

    
    public static String chuyenThanhKhoangTrang(String chuoiNhiPhan) 
    {
        String Tab = "\t";
        String Space = " ";
        String Zero = "0";
        String One = "1";
        String vanBanMaHoa = "";
        char[] arrayBinary = chuoiNhiPhan.toCharArray();
        for (int i = 0; i < arrayBinary.length; i++) 
        { 
        	// 0 => space, 1 => tab
            if (String.valueOf(arrayBinary[i]).equals(Zero)) {
                vanBanMaHoa += Space; 
            } else {
                vanBanMaHoa += Tab;
            }
        }
        return vanBanMaHoa;
    }

    
    public static String maHoa(String vanBan) {
        String nhiPhan = chuyenThanhNhiPhan(vanBan);
        String khoangTrang = chuyenThanhKhoangTrang(nhiPhan);
        return khoangTrang;
    }

}
