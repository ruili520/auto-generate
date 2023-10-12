package cn.rl520.autogenerate.service;

import cn.rl520.autogenerate.dto.Initial;
import cn.rl520.autogenerate.dto.InitialLogs;
import cn.rl520.autogenerate.vo.InitialLogsVo;
import cn.rl520.autogenerate.vo.InitialVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InitialIService {

    void saveInitial(Initial initial);

    void deleteInitial(Initial initial);

    InitialVo getInitial(Initial initial);

    List<InitialVo> getInitialList(Initial initial);

    PageInfo<InitialVo> getInitialPage(Initial initial);


}
