import java.util.*;

public class AboutCollections {
    /**
     * 接口           类
     * Collections
     * List         ArrayList  LinkedList
     * Set          HashSet     TreeSet(实现SortedSet接口) 不能存放重复元素
     * Map          HashMap
     * Iterator   用于集合输出
     * Enumeration
     * Queue
     **/
    /*
    方法
    add  addAll
    clear remove removeAll
    contains   containsAll
    size
    toArray
    equals
    hashCode
    isEmpty
    * */

    public static void main(String[] args){
        ArrayList<Double> al = new ArrayList<Double>();
        ArrayList<Double> all = new ArrayList<Double>();
        al.add(22.0);
        al.add(11.2);
        al.add(1,15.8); // 扩展方法
        all.addAll(0,al);       // 指定位置
        al.remove(0);
        al.remove(11.2);
        Double s = al.get(0); // 获取指定位置的值
        Double[] ss = al.toArray(new Double[]{}); // List转数组
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("key",111);
        Set<String> keys = map.keySet(); //map.values()
        Iterator<String> iter = keys.iterator(); //为接口实现实例化
        while(iter.hasNext()){
            String str = iter.next();
            System.out.print(str+" /");
        }
        Set<Map.Entry<String,String>> set = new HashMap<String,String>().entrySet();
        Iterator<Map.Entry<String,String>> me = set.iterator();
        while(me.hasNext()){
            Map.Entry<String,String> mm = me.next();
            mm.getKey();
            mm.getValue();
        }

        Map<String,String> sss = new HashMap<String,String>();
        for (Map.Entry<String,String> me1:sss.entrySet()) {

        }
        sss.get("key");
    }
}
