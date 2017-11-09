package com.didu.web;

import com.didu.domain.Carousel;
import com.didu.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
@Controller
public class CarouselControl {
    @Autowired
    private CarouselService carouserService;
    //图片的路径工具
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "carousel");
        // 验证文件夹是否存在，不存在就新建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //动态路径
    @RequestMapping("{jn}")
    public String t1(@PathVariable String jn){
        System.out.print(jn);
        return jn;
    }
    //上传图片
    @RequestMapping("/ImageUp")
    @ResponseBody
    public String addVideo(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            , Carousel picture) throws IOException {
        /*List<String> list = new ArrayList<String>();
        list.add(".JPG");
        list.add(".PNG");
        list.add(".MP4");
        list.add(".JPEG");*/
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
                    File file1 = new File(dir,System.currentTimeMillis() +"_"+ fileName);
                    files[i].transferTo(file1);
                    picture.setName(file1.getName());
                    picture.setUrl("carousel/" + file1.getName());
                    carouserService.addImage(picture);
                    return "true";
                }
                return "false";
            }
        }
        return "false";
    }
    //查看轮播图片
    @RequestMapping("/queryImage")
    @ResponseBody
    public List<Carousel> query(){
        List<Carousel> list = carouserService.query();
        System.out.println(list.toString());
        return list;
    }
    //删除图片
    @RequestMapping("/removeImage")
    @ResponseBody
    public String removeImage(int id,@ModelAttribute(value = "dir") File dir){
        Carousel image = carouserService.queryI(id);
        if(carouserService.removeImage(id)){
            String name = image.getName();
            String dir1 = dir.toString()+"/"+name;
            File file =  new File(dir1);
            file.delete();
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping("/updateImage")
    @ResponseBody
    public String updateImage(@RequestParam(name = "files", required = false) MultipartFile files,@ModelAttribute(value = "dir") File dir
            , Carousel picture) throws IOException {
        // 获取上传的文件的名称
        String fileName = files.getOriginalFilename();
        if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
            // 设置文件存储位置--->当前项目的平级目录下
            // 限制文件名称最长位50，若超出截取后面部分
            if (fileName.length() > 50) {

                fileName = fileName.substring(fileName.length() - 51);
            }
            Carousel image = carouserService.queryI(picture.getId());
            String name = image.getName();
            String dir1 = dir.toString().replaceAll("\\\\","/");
            String url = dir1+"/"+name;
            System.out.println(url);
            File f = new File(url);
            f.delete();
            File file1 = new File(dir, System.currentTimeMillis() + "_" + fileName);
            files.transferTo(file1);
            picture.setName(file1.getName());
            picture.setUrl("carousel/" + file1.getName());
            boolean a = carouserService.updateImage(picture);
            if (a) {
                return "true";
            } else {
                return "false";
            }
        }
        return "false";
    }
}
