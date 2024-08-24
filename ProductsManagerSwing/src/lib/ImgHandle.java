/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author griff
 */
public class ImgHandle {
    
    
    /*RESIZE IMG*/
    public static ImageIcon reSizeImg(String imgPath, byte[] img, JLabel jLabelImg)
    {
        ImageIcon imageIcon = null;
        if(imgPath != null)
        {
            imageIcon = new ImageIcon(imgPath);
        }else{
            imageIcon = new ImageIcon(img);
        }
        Image inputImg = imageIcon.getImage();
        Image outputImg = inputImg.getScaledInstance(jLabelImg.getWidth(),
                jLabelImg.getHeight(), 
                Image.SCALE_SMOOTH);
        ImageIcon imageIconResult = new ImageIcon(outputImg);
        return imageIconResult;   
    }
}
