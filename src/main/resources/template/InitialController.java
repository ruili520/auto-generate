package cn.rl520.autogenerate.utils.controller;

import cn.rl520.autogenerate.utils.dto.Initial;
import cn.rl520.autogenerate.utils.service.InitialService;
import cn.rl520.autogenerate.utils.vo.InitialVo;
import cn.rl520.response.result.aop.RlResponseResult;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("initial")
@RlResponseResult
@Slf4j
public class InitialController {

    @Autowired
    private InitialService initialService;
    

    @RequestMapping(value = "saveInitial",method = RequestMethod.POST)
    public void saveInitial(@RequestBody Initial initial){
        initialService.saveInitial(initial);
    }


    @RequestMapping(value = "deleteInitial",method = RequestMethod.POST)
    public void deleteInitial(@RequestBody Initial initial){
        initialService.deleteInitial(initial);
    }

    @RequestMapping(value = "getInitialList",method = RequestMethod.POST)
    public List<InitialVo> getInitialList(@RequestBody Initial initial){
        return initialService.getInitialList(initial);
    }

    @RequestMapping(value = "getInitialPage",method = RequestMethod.POST)
    public PageInfo<InitialVo> getInitialPage(@RequestBody Initial initial){
        return initialService.getInitialPage(initial);
    }

}
