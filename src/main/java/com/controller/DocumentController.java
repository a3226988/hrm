package com.controller;

import com.entity.Document;
import com.entity.User;
import com.service.DocumentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

/**
 * Create by gc on 2020/5/21
 * 铁甲依然在
 */
@Controller
@RequestMapping("document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @RequestMapping("upload")
    @RequiresPermissions("document:upload")
    public String upload(MultipartFile upfile, HttpServletRequest request, Document document){
        if(upfile==null || upfile.getSize()==0){
            return "redirect:/document/list";
        }
        try {
            String documentDir = "document";
            //将文件上传到服务器的指定目录下
            String dir = request.getServletContext().getRealPath(documentDir);
            String savefilename = UUID.randomUUID().toString();
            String filesuffix = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
            String savepath = dir+"/"+savefilename+filesuffix;
            upfile.transferTo(new File(savepath));

            //将文件信息保存到数据库
            User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
            document.setUserId(user.getId());
            document.setCreatedate(new Date());
            document.setFilepath(documentDir+"/"+savefilename+filesuffix);
            document.setSuffix(filesuffix);
            document.setSize(upfile.getSize());
            documentService.insert(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/document/list";
    }
    @RequestMapping("list")
    public String listFile(Model model){
        model.addAttribute("filelist",documentService.queryAllByLimit(0,100));
        return "file/list";
    }

    @RequestMapping("download/{id}")
    @RequiresPermissions("document:download")
    public void download(HttpServletResponse resp,HttpServletRequest request,@PathVariable("id") Integer id){

        Document document = documentService.queryById(id);
        if(document==null){
            return;
        }

         //获取文件输入流
        InputStream in = null;
        try {
            resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(document.getFilename()+document.getSuffix(), "UTF-8"));
            String dir = request.getServletContext().getRealPath("");
            in = new FileInputStream(dir+"/"+document.getFilepath());
            int len = 0;
            byte[] buffer = new byte[1024];
            OutputStream out = resp.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);//将缓冲区的数据输出到客户端浏览器
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
