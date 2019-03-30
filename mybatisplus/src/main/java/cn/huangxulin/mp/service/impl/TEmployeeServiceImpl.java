package cn.huangxulin.mp.service.impl;

import cn.huangxulin.mp.entity.TEmployee;
import cn.huangxulin.mp.mapper.TEmployeeMapper;
import cn.huangxulin.mp.service.TEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HuangXuLin
 * @since 2019-03-23
 */
@Service
public class TEmployeeServiceImpl extends ServiceImpl<TEmployeeMapper, TEmployee> implements TEmployeeService {

}
