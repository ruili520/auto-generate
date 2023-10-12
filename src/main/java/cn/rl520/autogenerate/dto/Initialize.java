package cn.rl520.autogenerate.dto;

import lombok.Data;

/**
 * 初始化工具类
 */
@Data
public class Initialize {

    /**
     * 原始文件的路径，用于替换其他文件内容使用-暂未启用或者用于web路径拼接
     */
    private String sourceFilePath = System.getProperty("user.dir")+"/";

    /**
     * 原始JAVA文件的路径，用于替换JAVA文件内容使用
     */
    private String sourceJavaPath = ClassLoader.getSystemResource(".").getPath().replace("target/classes/","");

    /**
     * 原始WEB文件的路径，用于替换WEB文件内容使用
     */
    private String sourceWebPath = "";

    /**
     * 原始需要替换文件的实际路径+文件名（去除上述路径部分）
     */
    private String sourceFileName = "";

    /**
     * 原始需要替换JAVA文件的实际路径+文件名（去除上述路径部分）
     */
    private String sourceJavaFileName = "";

    /*
     * 原始需要替换WEB文件的实际路径+文件名（去除上述路径部分）
     */
    private String sourceWebFileName = "";

    /**
     * 需要替换的名称（实体类名）
     */
    private String replaceName = "Initial";

    /**
     * 目标文件路径，同上原始文件路径
     */
    private String targetFilePath = System.getProperty("user.dir")+"/";

    /**
     * 目标JAVA文件路径，同上原始文件路径
     */
    private String targetJavaPath = ClassLoader.getSystemResource(".").getPath().replace("target/classes/","");

    /**
     * 目标web文件路径，同上原始文件路径
     */
    private String targetWebPath = "";

    /**
     * 目标需要生成文件的实际路径+文件名（去除上述路径部分）
     */
    private String targetFileName = "";

    /**
     * 目标需要生成JAVA文件的实际路径+文件名（去除上述路径部分或者mapper等标识）
     */
    private String targetJavaFileName = "";


    /**
     * 目标需要生成WEB文件的实际路径+文件名（去除上述路径部分）
     */
    private String targetWebFileName = "";


    /**
     * 目标的名称（实体类名）
     */
    private String targetName = "";

    /**
     * 是否生成mapper
     */
    private Boolean isGenerateMapper = true;

    /**
     * 是否生成Service
     */
    private Boolean isGenerateService = true;

    /**
     * 是否生成IService
     */
    private Boolean isGenerateIService = true;

    /**
     * 是否生成controller
     */
    private Boolean isGenerateController = true;


    /**
     * mapper路径
     */
    private String mapperPath = "mapper/";

    /**
     * service路径
     */
    private String servicePath = "service/";

    /**
     * service路径
     */
    private String IServicePath = "service/";

    /**
     * controller路径
     */
    private String controllerPath = "controller/";

    public Initialize() {
    }

    public Initialize(String replaceName, String targetName) {
        this.replaceName = replaceName;
        this.targetName = targetName;
    }
}
