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


    public void cpTest(String msg){
        System.out.println(initialize.getSourceJavaPath());
        System.out.println(initialize.getSourceFilePath());
        System.out.println(initialize.getTargetFilePath());
        System.out.println(initialize.getTargetJavaPath());
    }

    /**
     *
     * @param inFile 是否是JAR包内置文件
     * @param className 需要替换的实体类名称
     * @return 返回当前执行状态的说明
     */
    public String cpJavaFile(Boolean inFile,String className){
        log.info("开始执行JAVA文件的复制修改操作,需要替换的实体类名称={}",className);
        String javaPath = "/src/main/java/"+t.getPackage().getName().replaceAll("\\.","/")+"/";
        String fullPathName =initialize.getTargetJavaPath()+javaPath+initialize.getMapperPath();
        //判断文件夹是否存在
        File file = new File(fullPathName);
        if(!file.exists()){
            file.mkdirs();              //不存在创建新的文件
        }
        if (inFile){
            //获取指定的文件
            try {
                StringBuffer res = new StringBuffer();
                String line = null;
                BufferedReader reader = new BufferedReader(new InputStreamReader(GenerateUtils.class.getClassLoader().getResource("template/InitialMapper.java").openStream()));
                while ((line = reader.readLine()) != null) {
                    res.append(line + "\n");
                }
                reader.close();
                String text = res.toString().replace(GenerateUtils.class.getPackage().getName(),t.getPackage().getName()).replaceAll("Initial", className).replaceAll("initial", className.substring(0,1).toLowerCase(Locale.ROOT)+className.substring(1));
                BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathName+className+"mapper.java"));
                writer.write(text);
                writer.flush();
                writer.close();
                log.info("执行JAVA文件的复制修改工作完成，无异常");
                return "执行"+className+"类的JAVA文件的复制修改工作成功";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "执行"+className+"类的JAVA文件的复制修改工作失败";
            } catch (IOException e) {
                e.printStackTrace();
                return "执行"+className+"类的JAVA文件的复制修改工作失败";
            }
        }else {
            return "执行"+className+"类的JAVA文件的复制修改工作成功";
        }
    }





}
