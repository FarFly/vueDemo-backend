package com.fly.sell.controller;
import com.fly.sell.common.Page;
import com.fly.sell.entity.ProductCategory;
import com.fly.sell.entity.ProductInfo;
import com.fly.sell.enums.FilePathEnum;
import com.fly.sell.exception.SellException;
import com.fly.sell.form.ProductSaveForm;
import com.fly.sell.service.CategoryService;
import com.fly.sell.service.ProductService;
import com.fly.sell.utils.ImgUtils;
import com.sun.imageio.plugins.common.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        Page<List<ProductInfo>> productInfoPage = new Page<>();
        productInfoPage.setIndex((page - 1) * size);
        productInfoPage.setSize(size);
        productService.pageQuery(productInfoPage);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") Integer productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") Integer productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) Integer productId,
                              Map<String, Object> map) {
        if (productId != null) {
            ProductInfo productInfo = productService.selectByPrimaryKey(productId);
            map.put("productInfo", productInfo);
        }

        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.selectAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index", map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductSaveForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if(form.getImgFile() != null){
            String imgPath = ImgUtils.getImgPath(form.getImgFile().getOriginalFilename(), FilePathEnum.IMG.getPath());
            try {
                FileCopyUtils.copy(form.getImgFile().getBytes(), new File(imgPath));
            } catch (IOException e) {
                log.error("文件复制出错");
            }
            form.setImage("/sell/" + imgPath);
        }
        if(form.getIconFile() != null){
            String iconPath = ImgUtils.getImgPath(form.getIconFile().getOriginalFilename(), FilePathEnum.ICON.getPath());
            try {
                FileCopyUtils.copy(form.getIconFile().getBytes(), new File(iconPath));
            } catch (IOException e) {
                log.error("文件复制出错");
            }
            form.setIcon("/sell/" + iconPath);
        }
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            if(form.getId() == null){
                map.put("url", "/sell/seller/product/index");
            }else{
                map.put("url", "/sell/seller/product/index?productId=" + form.getId());
            }

            return new ModelAndView("common/error", map);
        }

        try {
            if (form.getId() != null) {
                // 更新
                ProductInfo productInfo = productService.selectByPrimaryKey(form.getId());
                BeanUtils.copyProperties(form, productInfo);
                productService.update(productInfo);
            } else {
                // 新增
                ProductInfo productInfo = new ProductInfo();
                BeanUtils.copyProperties(form, productInfo);
                productService.insert(productInfo);
            }
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
