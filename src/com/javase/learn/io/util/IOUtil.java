package com.javase.learn.io.util;

import com.javase.learn.domain.Result;

import java.io.*;

public class IOUtil {

    /**
     * 把源文件内容写入到目标文件上
     * @param sourceFile 源文件file
     * @param targetFile 目标文件file
     * @return 是否成功
     */
    public static Result fileToFile(File sourceFile, File targetFile){

        Result result = new Result();

        if(!sourceFile.exists()){
            result.setSuccess(false);
            result.setResultMessage("源文件不存在，请确认传入地址是否正确！");
            return result;
        }

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        char[] chars = new char[1024];
        int hasRead = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            inputStreamReader = new InputStreamReader(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            while ((hasRead = inputStreamReader.read(chars)) != 0){
                outputStreamWriter.write(chars, 0, hasRead);
            }

            result.setSuccess(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setResultMessage(e.getMessage());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setResultMessage(e.getMessage());
            return result;
        } finally {
            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStreamWriter != null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * 使用BufferedReader和BufferedWriter实现文件写入
     * @param sourceFile 源文件
     * @param targetFile 目标问价
     * @throws IOException
     */
    public static void fileToFileByReader(File sourceFile, File targetFile) throws IOException {

        FileReader fileReader = new FileReader(sourceFile);
        FileWriter fileWriter = new FileWriter(targetFile);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String hasRead;

        StringBuffer stringBuffer = new StringBuffer();

        while((hasRead = bufferedReader.readLine()) != null){
            stringBuffer.append(hasRead);
            bufferedWriter.write(hasRead);
            bufferedWriter.write("\r\n");
        }

        System.out.println(stringBuffer.toString());

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        File sourdeFile = new File("/Users/chensiyu3/FileTest/sourceFile.txt");
        File targetFile = new File("/Users/chensiyu3/FileTest/targetFile.txt");
        try {
            IOUtil.fileToFileByReader(sourdeFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
