package com.csg.cn.sys.service.impl;

import com.baidu.UUIDUtils;
import com.csg.cn.db.dao.SysCompanyMapper;
import com.csg.cn.db.dao.SysUserCompanyMapper;
import com.csg.cn.db.entity.SysCompany;
import com.csg.cn.db.entity.SysCompanyExample;
import com.csg.cn.db.entity.SysUserCompanyExample;
import com.csg.cn.db.vo.DeleteMessage;
import com.csg.cn.db.vo.SysCompanyCount;
import com.csg.cn.db.vo.SysCompanySimple;
import com.csg.cn.sys.constant.SysConstant;
import com.csg.cn.sys.service.SysCompanyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangzy on 2018/11/7.
 */
@Service
public class SysCompanyServiceImpl implements SysCompanyService {

    @Autowired
    private SysCompanyMapper sysCompanyMapper;
    @Autowired
    private SysUserCompanyMapper sysUserCompanyMapper;

    @Override
    public List<SysCompany> selectListByEnabled() {
        SysCompanyExample sysCompanyExample = new SysCompanyExample();
        sysCompanyExample.createCriteria().andCompanyStatusEqualTo(SysConstant.ENABLED_ONE);
        return sysCompanyMapper.selectByExample(sysCompanyExample);
    }

    @Override
    public List<SysCompany> selectList(String searchName) {
        SysCompanyExample sysCompanyExample = new SysCompanyExample();
        SysCompanyExample.Criteria criteria = sysCompanyExample.createCriteria();
        criteria.andCompanyStatusNotEqualTo(SysConstant.ENABLED_TWO);
        if(StringUtils.isNotBlank(searchName)){
            criteria.andCompanyNameLike("%"+searchName+"%");
        }
        return sysCompanyMapper.selectByExample(sysCompanyExample);
    }

    @Override
    public List<SysCompany> selectListByCompanyParentId(String companyParentId) {
        SysCompanyExample sysCompanyExample = new SysCompanyExample();
        sysCompanyExample.createCriteria().andCompanyParentIdEqualTo(companyParentId).andCompanyStatusEqualTo(SysConstant.ENABLED_ONE);
        return sysCompanyMapper.selectByExample(sysCompanyExample);
    }

    @Override
    public List<SysCompanyCount> getCompanyTreeWithState(String companyParentId) {
        return sysCompanyMapper.getCompanyTreeWithState(companyParentId);
    }

    @Override
    public List<SysCompanySimple> userCompanies(String userId) {
        return sysCompanyMapper.userCompanies(userId);
    }

    @Override
    public void saveAdd(SysCompany sysCompany) {
        sysCompany.setId(UUIDUtils.generateUUID());
        sysCompany.setCompanyParentId("0");
        sysCompanyMapper.insert(sysCompany);
    }

    @Override
    public SysCompany edit(String id) {
        return sysCompanyMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean saveEdit(SysCompany sysCompany) {
        if(!sysCompany.getCompanyName().equals(sysCompany.getLastCompanyName())){
            SysCompanyExample sysCompanyExample = new SysCompanyExample();
            sysCompanyExample.createCriteria().andCompanyNameEqualTo(sysCompany.getCompanyName());
            if(sysCompanyMapper.countByExample(sysCompanyExample) > 0){
                return false;
            }
        }
        sysCompanyMapper.updateByPrimaryKeySelective(sysCompany);
        return true;
    }

    @Override
    public boolean delete(String id) {
        SysUserCompanyExample sysUserCompanyExample = new SysUserCompanyExample();
        sysUserCompanyExample.createCriteria().andCompanyIdEqualTo(id);

        if(sysUserCompanyMapper.countByExample(sysUserCompanyExample) > 0){
            return false;
        }

        SysCompany sysCompany = new SysCompany();
        sysCompany.setId(id);
        sysCompany.setCompanyStatus(SysConstant.ENABLED_TWO);
        sysCompanyMapper.updateByPrimaryKeySelective(sysCompany);
        return true;
    }

    @Override
    public DeleteMessage deleteAll(List<String> ids) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setResult(true);

        SysUserCompanyExample sysUserCompanyExample;
        SysCompany deleteCompany;
        for(String id : ids){
            sysUserCompanyExample = new SysUserCompanyExample();
            sysUserCompanyExample.createCriteria().andCompanyIdEqualTo(id);

            if(sysUserCompanyMapper.countByExample(sysUserCompanyExample) > 0){
                deleteMessage.setResult(false);
                SysCompany sysCompany = sysCompanyMapper.selectByPrimaryKey(id);
                deleteMessage.setName(sysCompany.getCompanyName());
                break;
            }

            deleteCompany = new SysCompany();
            deleteCompany.setId(id);
            deleteCompany.setCompanyStatus(SysConstant.ENABLED_TWO);
            sysCompanyMapper.updateByPrimaryKeySelective(deleteCompany);
        }

        return deleteMessage;
    }
}
