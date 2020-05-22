package org.wrf.jsonparser;

import org.wrf.jsonparser.model.JsonObject;

import java.io.*;


public class JSONParserMain {
    public void parseJson(String jsonPath) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(jsonPath));
        StringBuilder sb=new StringBuilder();
        String line="";
        while((line=br.readLine())!=null){
            sb.append(line+"?");
        }
        br.close();

        sb.setCharAt(sb.length()-1,' ');
        String []jsons=sb.toString().split("\\?");
        JSONParser jsonParser=new JSONParser();
        int len=jsons.length;
        //写入文件
        BufferedWriter bw=new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/result.txt"));
        int i=0;
        while(i<len){
            try{
                JsonObject jsonObject=(JsonObject) jsonParser.fromJSON(jsons[i++]);
                //System.out.println(jsonObject);
                System.out.println("解析正常");
                bw.write(i+",yes"+"\n");
            }catch (Exception e){
                System.out.println("解析异常");
                bw.write(i+",no"+"\n");
            }
            bw.flush();

        }

        bw.close();
        br.close();
    }


    public static void main(String[] args) {
        try {
            String path=args[0];
            new JSONParserMain().parseJson(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
