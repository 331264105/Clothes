package com.didu.web;

import com.didu.domain.Carousel;
import com.didu.domain.Navigation;
import com.didu.service.NavigationService;
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

/**
 * Created by Administrator on 2017/10/27.
 */
@Controller
public class NavigationControl {
    @Autowired
    private NavigationService navigationService;
    //图片的路径工具
    @ModelAttribute("dir")
    public File pre(HttpServletRequest request) {
        File dir = new File(new File(request.getServletContext().getRealPath("/")), "navigation");
        // 验证文件夹是否存在，不存在就新建
        System.out.println(dir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }
    //上传轮播图片
    @RequestMapping("/NavigationUp")
    @ResponseBody
    public String addVideo(@RequestParam(name = "files", required = false) CommonsMultipartFile[] files, @ModelAttribute(value = "dir") File dir
            , Navigation picture) throws IOException {
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
                    File file1 = new File(dir, System.currentTimeMillis() +"_"+ fileName);
                    files[i].transferTo(file1);
                    picture.setName(file1.getName());
                    picture.setUrl("navigation/" + file1.getName());
                    navigationService.addImage(picture);
                    return "true";
                }
                return "false";
            }
        }
        return "false";
    }
    //更新轮播图片
    @RequestMapping("/updateNavigation")
    @ResponseBody
    public String updateImage(@RequestParam(name = "files", required = false) MultipartFile files, @ModelAttribute(value = "dir") File dir
            , Navigation picture) throws IOException {
        // 获取上传的文件的名称
        String fileName = files.getOriginalFilename();
        if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
            // 设置文件存储位置--->当前项目的平级目录下
            // 限制文件名称最长位50，若超出截取后面部分
            if (fileName.length() > 50) {

                fileName = fileName.substring(fileName.length() - 51);
            }
            Navigation image = navigationService.queryI(picture.getId());
            String name = image.getName();
            String dir1 = dir.toString().replaceAll("\\\\","/");
            String url = dir1+"/"+name;
            System.out.println(url);
            File f = new File(url);
            f.delete();
            File file1 = new File(dir, System.currentTimeMillis() + "_" + fileName);
            files.transferTo(file1);
            picture.setName(file1.getName());
            picture.setUrl("navigation/" + file1.getName());
            boolean a = navigationService.updateImage(picture);
            if (a) {
                return "true";
            } else {
                return "false";
            }
        }
        return "false";
    }
    //查看轮播图片
    @RequestMapping("/queryNavigation")
    @ResponseBody
    public List<Navigation> query(){
        List<Navigation> list = navigationService.query();
        return list;
    }

}
