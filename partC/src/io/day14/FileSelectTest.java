package io.day14;

import javax.swing.JFrame;
import java.awt.FileDialog;
import java.util.HashMap;
import java.util.Map;

public class FileSelectTest {

    public static void main(String[] args) {

        //GUI : Graphic User Interface
        //   java.awt와 java.swing 에서 제공합니다.
        
        JFrame jf = new JFrame();
       // jf.setSize(200,200);
        jf.setVisible(false);

        FileDialog fd= new FileDialog(jf,"파일 선택",FileDialog.LOAD);
        fd.setVisible(true);
        System.out.println("선택한 폴더 ㅣ"+fd.getDirectory()); //폴더=디렉토리
        System.out.println("선택한 파일 : "+fd.getFile());
        System.out.println(fd.getDirectory().replace("\\","\\\\")
                            +fd.getFile().replace("\\", "\\\\"));
        }
        public static Map<String,String> showDialog(){
            JFrame jf = new JFrame();
            // jf.setSize(200,200);
            jf.setVisible(false);
     
             FileDialog fd= new FileDialog(jf,"파일 선택",FileDialog.LOAD);
             fd.setVisible(true);
            //  System.out.println("선택한 폴더 ㅣ"+fd.getDirectory()); //폴더=디렉토리
            //  System.out.println("선택한 파일 : "+fd.getFile());
            //  System.out.println(fd.getDirectory().replace("\\","\\\\")+fd.getFile().replace("\\", "\\\\"));
            
            Map<String,String> map = new HashMap<>();
            map.put("folder",fd.getDirectory().replace("\\","\\\\"));
            map.put("filename",fd.getFile());
            //map.put("filesize",0);
            return map;
        }
    }
    

