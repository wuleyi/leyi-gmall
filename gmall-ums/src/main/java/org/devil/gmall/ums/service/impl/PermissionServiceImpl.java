package org.devil.gmall.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.devil.gmall.ums.entity.Permission;
import org.devil.gmall.ums.mapper.PermissionMapper;
import org.devil.gmall.ums.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
