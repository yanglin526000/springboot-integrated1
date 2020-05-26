package com.spring.springbootintegrated1.service.common.impl;

import com.spring.springbootintegrated1.mapper.BaseMyBatisMapper;
import com.spring.springbootintegrated1.service.common.BaseMyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 描述: 公共业务层接口实现
 * </p>
 * <p>
 * 创建时间: 2019-11-15 09:35
 * </p>
 *
 * @param <T> 标签
 * @author yanglin
 */
@Service
public class BaseMyBatisServiceImpl<T> implements BaseMyBatisService<T> {

    @Autowired
    BaseMyBatisMapper baseMyBatisMapper;

    @Transactional
    @Override
    public T save(T t) {
        baseMyBatisMapper.selectAll();
        baseMyBatisMapper.selectAll();
        baseMyBatisMapper.selectAll();
//        int id = baseMyBatisMapper.insert(t);
//        return baseMyBatisMapper.selectByPrimaryKey(id);
        return null;
    }

//    @Transactional
//    @Override
//    public T delete(T t) {
////        ParamUtil.putField(t, "isDelete", ConstantUtil.IS_DELETE);
////        int id = baseMyBatisMapper.updateByPrimaryKeySelective(t);
////        return baseMyBatisMapper.selectByPrimaryKey(id);
//        return null;
//    }
//
//    @Override
//    public T info(T t) {
////        return baseMyBatisMapper.selectOne(t);
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> list(T t, Pageable pageable) {
////        baseMyBatisMapper.select(t);
////        return baseMyBatisMapper.select(record)list(t, pageable);
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> listAccurate(T t, Pageable pageable) {
////        return baseMyBatisMapper.listAccurate(t, pageable);
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> listAccurate(T t) {
////        Pageable pageable = PageRequest.of(Integer.parseInt(ConstantUtil.DEFAULT_PAGE_INDEX),
////                Integer.parseInt(ConstantUtil.DEFAULT_PAGE_SIZE));
////        return listAccurate(t, pageable);
//        return null;
//    }
}
