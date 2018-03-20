//package com.sunesoft.titan.webapp;
//
//import com.sunesoft.titan.annotations.UnCheckPermission;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URLEncoder;
//
///**
// * @author: Zhouzh
// * @Date: 2017/9/7
// */
//@Controller
//public class AuthHostController {
//
//
//
//    @UnCheckPermission
//    @RequestMapping(value = "/static/voucher/help/{fileName}.pdf")
//    public void mpFile(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response){
//        try {
//            // 取得文件名。
//            String filenames = fileName +".pdf";
//
//            // 以流的形式下载文件。
//            InputStream fis = this.getClass().getClassLoader().getResourceAsStream("/static/voucher/help/"+filenames);
//            byte[] buffer = new byte[fis.available()];
//            fis.read(buffer);
//            fis.close();
//            // 清空response
//            response.reset();
//            // 设置response的Header
//            response.addHeader("Content-Disposition", "attachment;filename=" +  URLEncoder.encode(filenames,"UTF-8"));
//            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//            response.setContentType("application/pdf");
//            toClient.write(buffer);
//            toClient.flush();
//            toClient.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//
//
//}
