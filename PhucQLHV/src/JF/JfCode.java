
package JF;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JfCode extends JFrame {
    //var ===
    //private JFrame frame; // JFrame --> là 1 cái khung
    JButton button;         // JButton --> là các btn --> chèn vào trong khung Frame
    
    //constructor ====
    public JfCode(){
        creatAndShow();
    }
    //function creatAndShow() 
    public void creatAndShow(){
        button = new JButton("OK"); // tao btn trong khung Jframe
        //frame = new JFrame("Quản Lý Học Viên"); // set tittel
        this.setSize(1000, 600);        // set size of Jframe
        this.setLocationRelativeTo(null); // set giữa màn hình
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit --> close() !
        this.add(button);
        this.setLayout(new FlowLayout());
        //this.pack(); --> nó tự set size vừa đủ
        this.setVisible(true);         // set hiển thị
    }
    
    //main ==========================================================
    public static void main(String[] args) {
        new JfCode();
    }
}
