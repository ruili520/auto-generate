package cn.rl520.autogenerate;

import cn.rl520.autogenerate.dto.Initial;
import cn.rl520.autogenerate.service.InitialService;
import cn.rl520.autogenerate.vo.InitialVo;
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
    private InitialService deviceService;
    

    @RequestMapping(value = "saveInitial",method = RequestMethod.POST)
    public void saveInitial(@RequestBody Initial initial){
        deviceService.saveInitial(initial);
    }


    @RequestMapping(value = "deleteInitial",method = RequestMethod.POST)
    public void deleteInitial(@RequestBody Initial initial){
        deviceService.deleteInitial(initial);
    }

    @RequestMapping(value = "getInitialList",method = RequestMethod.POST)
    public List<InitialVo> getInitialList(@RequestBody Initial initial){
        return deviceService.getInitialList(initial);
    }

    @RequestMapping(value = "getInitialPage",method = RequestMethod.POST)
    public PageInfo<InitialVo> getInitialPage(@RequestBody Initial initial){
        return deviceService.getInitialPage(initial);
    }

}
