package org.devil.gmall.ums.service.impl;

import org.devil.gmall.ums.entity.AdminPermissionRelation;
import org.devil.gmall.ums.mapper.AdminPermissionRelationMapper;
import org.devil.gmall.ums.service.AdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class AdminPermissionRelationServiceImpl extends ServiceImpl<AdminPermissionRelationMapper, AdminPermissionRelation> implements AdminPermissionRelationService {

}
