package ArrayandString;

import java.util.ArrayList;
import java.util.List;

class SimplifyPath {
    public String simplifyPath(String path) {
        String[] sections = path.split("/+");
        List<String> list = new ArrayList<String>();
        for(String s : sections){
            if(s.equals("") || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(list.size() > 0){
                    list.remove(list.size() - 1);
                }
            }else{
                list.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(String s : list){
            sb.append(s).append("/");
        }
        if(sb.length() > 1){
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
