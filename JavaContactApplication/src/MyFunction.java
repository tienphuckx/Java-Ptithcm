
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MyFunction 
{
    
        public ImageIcon reSizePic(String picPath, byte[] BLOBpic, int w, int h)
        {
            ImageIcon myImg;
            if(picPath != null)
            {
                myImg = new ImageIcon(picPath);
            }
            else
            {
                myImg = new ImageIcon(BLOBpic);
            }
            
            Image img = myImg.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            /*
            PICTURE RESULT
            */
            ImageIcon myResultImg = new ImageIcon(img);
            return myResultImg;
        }
        
        
        
        public String browseImage(JLabel lbl)
        {
            
        String path = "";
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        /*
        FILE EXTENDSION
        */
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.Images","jpg","png","gif");
        jfc.addChoosableFileFilter(fnef);
        
        int fileState = jfc.showSaveDialog(null);
        
        /*
        IF USER SELECTED A FILE
        */
        if(fileState == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = jfc.getSelectedFile();
            path = selectedFile.getAbsolutePath();
//            imagePath = path;
            /*
            DISPLAY THE SELECTED IMG INTO THE JLABEL
            APPLY RESIZE FUNCTION
            */
            lbl.setIcon(reSizePic(path,null, lbl.getWidth(), lbl.getHeight()));
            /*
            jLabelPic.setIcon(new ImageIcon(path));
            */
            
        }
        /*
        ELSE IF THE USER CANCEL THE CREATE FORM
        */
        else if(fileState == JFileChooser.CANCEL_OPTION)
        {
            System.out.println("No images selected!");
        }
        
        return path;
        }
}
