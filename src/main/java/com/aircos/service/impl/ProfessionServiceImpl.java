package com.aircos.service.impl;

import com.aircos.core.ServiceException;
import com.aircos.entity.dao.Profession;
import com.aircos.entity.dao.User;
import com.aircos.entity.dto.CreateProfessionDto;
import com.aircos.entity.vo.ProfessionDetailVo;
import com.aircos.entity.vo.QueryProfessionVo;
import com.aircos.mapper.ProfessionMapper;
import com.aircos.service.ProfessionService;
import com.aircos.service.UserService;
import com.aircos.util.SecurityUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Service of 专业
 *
 * @author gongguowei01@gmail.com
 * @since 2020-02-02
 */
@Service
public class ProfessionServiceImpl extends ServiceImpl<ProfessionMapper, Profession> implements ProfessionService {

    private final UserService userService;

    private final ProfessionMapper professionMapper;

    @Autowired
    public ProfessionServiceImpl(ProfessionMapper professionMapper, UserService userService) {
        this.professionMapper = professionMapper;
        this.userService = userService;
    }

    @Override
    public ProfessionDetailVo list(int professionId) {
        return professionMapper.queryProfessionDetail(professionId);
    }

    @Override
    public IPage<QueryProfessionVo> query(String keyWord, Integer pageIndex, Integer pageSize) {
        IPage page = new Page(pageIndex, pageSize);
        return professionMapper.queryProfessionsByKeyWord(page, keyWord);
    }

    @Override
    public void create(CreateProfessionDto body) {
        User loginUser = userService.findByPhone(SecurityUtils.getPhone());
        Profession record = new Profession();

        setValues(record, body);

        record.setNeed(body.getNeed());
        record.setScaleAs(body.getScaleAs());
        record.setScaleSex(body.getScaleSex());
        record.setCreateUid(loginUser.getId());
        record.setWorkDetail(body.getWorkDetail());
        record.setProfessionDetail(body.getProfessionDetail());

        professionMapper.insert(record);
    }

    @Override
    public void update(CreateProfessionDto body) {
        Profession record = new Profession();
        if(existsById(body)){
            throw new ServiceException("没有找到相应的品类id");
        }
        record.setId(body.getId());
        setValues(record, body);
        professionMapper.updateById(record);
    }

    @Override
    public void delete(int professionId, int level) {
        Profession before = professionMapper.selectById(professionId);

        if (null == before) {
            throw new ServiceException("id :" + professionId + "不存在");
        }
        before.setIsDeleted(false);
        professionMapper.updateById(before);

        //如果删除level为[1,2]的品类，那么子品类也将被删除
        int notChild = 3;
        if (level != notChild) {
            List<Profession> childrenProfession = professionMapper.selectList(new QueryWrapper<Profession>()
                    .lambda()
                    .eq(Profession::getPid, professionId));
            childrenProfession.forEach(children -> {
                children.setIsDeleted(false);
            });
            this.updateBatchById(childrenProfession);
        }
    }

    /**
     * 校验且设置品类的父级ID
     *
     * @param profession 准备插入的品类
     * @param createProfessionDto 品类数据准备
     */
    private void setValues(Profession profession , CreateProfessionDto createProfessionDto){
        Integer pid = createProfessionDto.getPid();

        profession.setName(createProfessionDto.getCategoryName());
        profession.setLevel(createProfessionDto.getLevel());

        //判断是否为顶级路径
        if(!createProfessionDto.getLevel().equals(1) && null != pid) {
            if (!existsById(createProfessionDto)) {
                profession.setPid(pid);
            } else {
                throw new ServiceException("无法匹配父级类型");
            }
        }
    }

    private Boolean existsById(CreateProfessionDto createProfessionDto) {
        Integer existsById = professionMapper.selectCount(new QueryWrapper<Profession>()
                .lambda()
                .eq(Profession::getId, createProfessionDto.getPid()));
        if (0 != existsById) {
            return false;
        } else {
            return true;
        }
    }
}
