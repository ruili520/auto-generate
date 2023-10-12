package cn.rl520.autogenerate.utils.service;

import cn.rl520.autogenerate.utils.dto.Initial;
import cn.rl520.autogenerate.utils.vo.InitialVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InitialIService {

    void saveInitial(Initial initial);

    void deleteInitial(Initial initial);

    InitialVo getInitial(Initial initial);

    List<InitialVo> getInitialList(Initial initial);

    PageInfo<InitialVo> getInitialPage(Initial initial);


}
