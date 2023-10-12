package cn.rl520.autogenerate.utils;

import cn.rl520.autogenerate.dto.Initialize;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Locale;


/**
 * 生成工具类
 * 根据选择的文件或者路径进行设置操作
 */
@Slf4j
public class GenerateUtils<T> {

    private Class<T> t;
    private Initialize initialize = new Initialize();

    public GenerateUtils() {

    }

    public GenerateUtils(Class<T> t) {
        this.t = t;
    }

    public GenerateUtils(Class<T> t, Initialize initialize) {
        this.t = t;
        this.initialize = initialize;
    }

    /**
     *
     * @param inFile 是否是JAR包内置文件
     * @param fileType 文件类型 Service，Mapper，IService ,Controller
     * @return 返回当前执行状态的说明
     */
    public String cpJavaFile(Boolean inFile,String fileType) throws IOException {
        log.info("开始执行JAVA文件的复制修改操作,需要替换的实体类名称={}",initialize.getTargetName());
        String javaPath = "/src/main/java/"+t.getPackage().getName().replaceAll("\\.","/")+"/";
        String fullPathName =initialize.getTargetJavaPath()+javaPath;
        switch (fileType){
            case "Mapper":
                fullPathName = fullPathName+initialize.getMapperPath();
                break;
            case "IService":
                fullPathName = fullPathName+initialize.getIServicePath();
                break;
            case "Service":
                fullPathName = fullPathName+initialize.getServicePath();
                break;
            case "Controller":
                fullPathName = fullPathName+initialize.getControllerPath();
                break;
            default:
                break;
        }
        //判断文件夹是否存在
        File file = new File(fullPathName);
        if(!file.exists()){
            file.mkdirs();              //不存在创建新的文件
        }
        InputStreamReader inputStreamReader = null;
        if (inFile){
            initialize.setReplaceName("Initial");
            inputStreamReader = new InputStreamReader(GenerateUtils.class.getClassLoader().getResource("template/Initial"+fileType+".java").openStream());
        }else {
            inputStreamReader = new InputStreamReader(new FileInputStream(initialize.getSourceJavaPath()+initialize.getSourceJavaFileName()));
        }
        //获取指定的文件
        try {
            StringBuffer res = new StringBuffer();
            String line = null;
            BufferedReader reader = new BufferedReader(inputStreamReader);
            while ((line = reader.readLine()) != null) {
                res.append(line + "\n");
            }
            reader.close();
            String text = res.toString().replaceAll(GenerateUtils.class.getPackage().getName(),t.getPackage().getName()).replaceAll(initialize.getReplaceName(), initialize.getTargetName()).replaceAll(initialize.getReplaceName().substring(0,1).toLowerCase(Locale.ROOT)+initialize.getReplaceName().substring(1), initialize.getTargetName().substring(0,1).toLowerCase(Locale.ROOT)+initialize.getTargetName().substring(1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathName+initialize.getTargetName()+fileType+".java"));
            writer.write(text);
            writer.flush();
            writer.close();
            log.info("执行JAVA文件的复制修改工作完成，无异常");
            return "执行"+initialize.getTargetName()+"类的"+fileType+"-JAVA文件的复制修改工作成功";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "执行"+initialize.getTargetName()+"类的"+fileType+"-JAVA文件的复制修改工作失败";
        } catch (IOException e) {
            e.printStackTrace();
            return "执行"+initialize.getTargetName()+"类的"+fileType+"-JAVA文件的复制修改工作失败";
        }
    }


    /**
     *
     * @param inFile 是否是JAR包内置文件
     * @return 返回当前执行状态的说明
     */
    public String generateJavaFile(Boolean inFile){
        log.info("开始执行JAVA文件的复制修改操作,是否生成mapper文件={},是否生成IService文件={},是否生成Service文件={},是否生成controller文件={}",initialize.getIsGenerateMapper(),
                initialize.getIsGenerateIService(),initialize.getIsGenerateService(),initialize.getIsGenerateController());
        String msg = "开始执行JAVA文件的复制修改操作";
        String text = null;
        if (initialize.getIsGenerateMapper()){
            log.info("开始执行复制mapper文件");
            try {
                text = cpJavaFile(inFile,"Mapper");
                log.info(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            msg = msg + ",mapper文件成功";
        }
        if (initialize.getIsGenerateIService()){
            log.info("开始执行复制IService文件");
            try {
                text = cpJavaFile(inFile,"IService");
                log.info(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            msg = msg + ",IService文件成功";
        }
        if (initialize.getIsGenerateService()){
            log.info("开始执行复制Service文件");
            try {
                text = cpJavaFile(inFile,"Service");
                log.info(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            msg = msg + ",Service文件成功";
        }
        if (initialize.getIsGenerateController()){
            log.info("开始执行复制controller文件");
            try {
                text = cpJavaFile(inFile,"Controller");
                log.info(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            msg = msg + ",controller文件成功";
        }
        return msg;
    }



}
