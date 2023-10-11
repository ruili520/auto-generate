package cn.rl520.autogenerate.utils.mapper;

import cn.rl520.autogenerate.utils.dto.Initial;
import cn.rl520.autogenerate.utils.vo.InitialVo;

import java.util.List;

public interface InitialMapper {

    int addInitial(Initial initial);

    int updateInitial(Initial initial);

    int deleteInitial(Initial initial);

    InitialVo getInitial(Initial initial);

    List<InitialVo> getInitialList(Initial initial);

}