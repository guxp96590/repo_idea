package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();

        return  new ResponseResult(true,200,"查询所有分类信息成功",allResourceCategory);

    }

    @PostMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory) {
        Date date = new Date();
        // 看是否携带 id
        if (resourceCategory.getId() == null) {
            // 新增
            resourceCategory.setCreatedTime(date);
            resourceCategory.setUpdatedTime(date);
            resourceCategory.setCreatedBy("system");
            resourceCategory.setUpdatedBy("system");
            resourceCategoryService.saveResourceCategory(resourceCategory);
            ResponseResult result = new ResponseResult(true, 200, "添加资源分类成功", null);
            return result;
        } else {
            // 更新
            resourceCategory.setUpdatedTime(date);
            resourceCategory.setUpdatedBy("system");
            resourceCategoryService.updateResourceCategory(resourceCategory);
            return new ResponseResult(true, 200, "修改资源分类成功", null);
        }
    }

    @GetMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id) {
        resourceCategoryService.deleteResourceCategory(id);
        return new ResponseResult(true, 200, "删除资源分类成功", null);
    }


}
