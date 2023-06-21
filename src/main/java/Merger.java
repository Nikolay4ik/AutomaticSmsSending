import java.util.Map;

public class Merger {
    private static String PATH = "Files/Numbers.xls";
    static void startWorkApi() {
        SmscApi smscApi = new SmscApi("","","utf-8",true);
        for(Map.Entry<String,String> s:ParseFiles.phoneAndName(PATH).entrySet()){
            smscApi.sendSms(s.getKey(),"Тест"+s.getValue(),1, "", "", 0, "", "");
            smscApi.getBalance();
        }
    }

}
