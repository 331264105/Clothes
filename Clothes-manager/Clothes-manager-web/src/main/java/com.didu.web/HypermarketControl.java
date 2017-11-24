package com.didu.web;

import com.didu.domain.Carousel;
import com.didu.domain.Hypermarket;
import com.didu.domain.Navigation;
import com.didu.service.HypermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;



@Controller
public class HypermarketControl {
        @Autowired
        private HypermarketService hypermarketService;
    //图片的路径工具
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "hypermarket");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //上传专场
    @RequestMapping("/HypermarketUp")
    @ResponseBody
    public String addVideo(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            , Hypermarket picture) throws IOException {
        for (int i = 0; i < files.length; i++) {

            if (!files[i].isEmpty() && files[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = files[i].getOriginalFilename();
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                    // 设置文件存储位置--->当前项目的平级目录下
                    // 限制文件名称最长位50，若超出截取后面部分

                    if (fileName.length() > 50) {
                        fileName = fileName.substring(fileName.length() - 51);
                    }
                    File file1 = new File(dir, System.currentTimeMillis() +"_"+ fileName);
                    files[i].transferTo(file1);
                    picture.setUrl("hypermarket/" + file1.getName());
                    hypermarketService.addHypermarket(picture);
                    return "true";
                }
                return "false";
            }
        }
        return "false";
    }
    //进入主界面专场
    @RequestMapping("/queryHypermarket")
    @ResponseBody
    public List<Hypermarket> query(String property){
        List<Hypermarket> list = hypermarketService.query(property);
        System.out.println(list.toString());
        return list;
    }
    //删除专场
    @RequestMapping("/removeHypermarket")
    @ResponseBody
    public String removeImage(int id,HttpServletRequest request){
        Hypermarket image = hypermarketService.queryI(id);
        if(hypermarketService.removeHypermarket(id)){
            String ipath = image.getUrl();
            String path = request.getServletContext().getRealPath("/");
            String pa = path.replaceAll("\\\\","/");
            String realpath = pa+ipath;
            File file =  new File(realpath);
            file.delete();
            return "true";
        }else {
            return "false";
        }
    }
    //修改专场
    @RequestMapping("/updateHypermarket")
    @ResponseBody
    public String updateImage(@RequestParam(name = "files", required = false) MultipartFile files, @ModelAttribute(value = "dir") File dir
            , Hypermarket picture,HttpServletRequest request) throws IOException {
        // 获取上传的文件的名称
        System.out.println(picture.toString());
        String fileName = files.getOriginalFilename();
        if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
            // 设置文件存储位置--->当前项目的平级目录下
            // 限制文件名称最长位50，若超出截取后面部分
            if (fileName.length() > 50) {

                fileName = fileName.substring(fileName.length() - 51);
            }
            Hypermarket image = hypermarketService.queryI(picture.getId());
            String path = request.getServletContext().getRealPath("/");
            String dir1 = path.replaceAll("\\\\", "/");
            String url = dir1+image.getUrl();
            System.out.println(url);
            File f = new File(url);
            f.delete();
            File file1 = new File(dir, System.currentTimeMillis() + "_" + fileName);
            files.transferTo(file1);
            picture.setUrl("hypermarket/" +file1.getName());
            boolean a = hypermarketService.updateImage(picture);
            if (a) {
                return "true";
            } else {
                return "false";
            }
        }
        return "false";
    }
    //
    @RequestMapping("/updateHerpermarkettwo")
    @ResponseBody
    public String updateHerpermarkettwo(Hypermarket hypermarket){
        boolean b = hypermarketService.updateHerpermarkettwo(hypermarket);
        if (b){
            return "true";
        }else {
            return "false";
        }
    }
}
