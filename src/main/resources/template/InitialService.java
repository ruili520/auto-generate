package cn.rl520.autogenerate.utils.service;

import cn.rl520.autogenerate.utils.dto.Initial;
import cn.rl520.autogenerate.utils.mapper.InitialMapper;
import cn.rl520.autogenerate.utils.vo.InitialVo;
import com.github.f4b6a3.ulid.UlidCreator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public class InitialService  implements  InitialIService{

    @Autowired
    private InitialMapper initialMapper;

    @Override
    @Transactional
    public void saveInitial(Initial initial) {
        //查询当前的imei是否存在，imei作为唯一值
        initial.setUpdateTime(new Date());
        if (initial.getUuId()!=null){
            initialMapper.updateInitial(initial);
        }else {
            initial.setUuId(UlidCreator.getUlid().toString());
            initial.setAddTime(new Date());
            initialMapper.addInitial(initial);
        }
    }

    @Override
    @Transactional
    public void deleteInitial(Initial initial) {
        initialMapper.deleteInitial(initial);
    }

    @Override
    public InitialVo getInitial(Initial initial) {
        return initialMapper.getInitial(initial);
    }

    @Override
    public List<InitialVo> getInitialList(Initial initial) {
        return initialMapper.getInitialList(initial);
    }

    @Override
    public PageInfo<InitialVo> getInitialPage(Initial initial) {
        PageHelper.startPage(initial.getPageNum(),initial.getPageSize());
        List<InitialVo> initialVos = initialMapper.getInitialList(initial);
        return new PageInfo<>(initialVos);
    }


}
