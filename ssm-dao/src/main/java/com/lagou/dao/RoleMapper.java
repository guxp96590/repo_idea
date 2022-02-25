package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface RoleMapper {

    /*
        查询所有角色&条件进行查询
     */

    public List<Role> findAllRole(Role role);


    /*
        根据角色ID查询该角色关联的菜单信息ID [1,2,3,5]
     */
    public List<Integer> findMenuByRoleId(Integer roleid);


    /*
        根据roleid清空中间表的关联关系
     */
    public void deleteRoleContextMenu(Integer rid);


    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /*
        删除角色
     */

    public void deleteRole(Integer roleid);



    /*
    获取当前角色拥有的资源分类信息
    */
    List<ResourceCategory> findResourceCategoryByRoleId(Integer roleId);

    /*
    获取当前角色拥有的资源信息
    */
    List<Resource> findResourceByRoleId(Integer roleId);

    /*
        根据角色ID删除角色与资源的关联关系(操作中间表 role_resource_relation)
     */
    void deleteRoleContextResource(Integer roleId);

    /*
        为角色分配资源，删除完成后，插入最新的关联关系
     */
    void roleContextResource(RoleResourceRelation roleResourceRelation);
}
