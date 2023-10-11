package cn.rl520.autogenerate.dto;

import lombok.Data;

/**
 * 初始化工具类
 */
@Data
public class Initialize {

    private String sourceJavaPath = ClassLoader.getSystemResource(".").getPath().replace("target/classes/","");

    private String sourceWebPath = "";

    private String sourceFilePath = System.getProperty("user.dir")+"/";

    private String sourceJavaFileName = "";

    private String sourceWebFileName = "";

    private String sourceFileName = "";

    private String replaceName = "Test";

    private String targetName = "";

    private String targetJavaPath = ClassLoader.getSystemResource(".").getPath().replace("target/classes/","");

    private String targetWebPath = "";

    private String targetFilePath = System.getProperty("user.dir")+"/";

    private String targetJavaFileName = "";

    private String targetWebFileName = "";

    private String targetFileName = "";

    private String mapperPath = "mapper/";

    private String servicePath = "service/impl/";

    private String IServicePath = "service/";

    private String controllerPath = "controller/";


}
