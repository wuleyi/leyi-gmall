package org.devil.gmall.pms.vo;

import lombok.Data;
import org.devil.gmall.pms.entity.ProductCategory;

import java.util.List;

/**
 * Created by leyi on 2019/6/9.
 */
@Data
public class PmsProductMultiCategoryVo extends ProductCategory {

    /**
     * {
     *     id:1
     *     name:xxx
     *     children:{
     *         id:2
     *         name:xxx
     *         children:{
     *             id:3
     *             name:xxx
     *             children:
     *         }
     *     }
     * }
     *
     * 1、去数据库查出所有菜单
     *      写递归来组装关系 不推荐(时间复杂度、空间复杂度[占空间])；StackOverflowException
     *      category(root){
     *          //1、查询子节点  children
     *          if(children.hasChildren){
     *              //1、查是否有子节点
     *              //2、组装关系
     *              category(children)
     *          }
     *          root.setChildren(children);
     *      }
     * 2、数据库层面，查询的时候就组装好
     *      //mybatis的关联查询；（ass。。。  ,collection）；
     *         1、查出菜单
     *         select * from caidan  where id=1
     *         if(caidan.parentId>0){
     *
     *         }
     *
     */
    //每个分类里面都有自己的子分类
    private List<PmsProductMultiCategoryVo> children;

}
