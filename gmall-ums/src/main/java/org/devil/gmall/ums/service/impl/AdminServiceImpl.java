package org.devil.gmall.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.devil.gmall.ums.entity.Admin;
import org.devil.gmall.ums.mapper.AdminMapper;
import org.devil.gmall.ums.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
