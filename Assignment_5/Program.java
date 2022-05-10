import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String args[]){
        final int ARR_SIZE = 100;
        final int MIN = 1;
        final int MAX = 1001;
        List<Integer> list = new ArrayList<>();


        for(int i=0 ; i<ARR_SIZE; i++){
            list.add(i, (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN));
        }
        
        print(list);

        list = sort(list);

        print(list);
    }


    public static List<Integer> sort(List<Integer> m) {
        if(m.size() <= 1){
            return m;
        }

        List<Integer> left = new ArrayList<>();        
        List<Integer> right = new ArrayList<>();        
        int i = 0;
        int midway = m.size()/2;

        while(i<m.size()){
            if(i<midway){
                left.add(m.get(i));
                i++;
            }
            else{
                right.add(m.get(i));
                i++;
            }
        }
        
        left = sort(left);
        right = sort(right);
        return merge(left, right); 
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> list = new ArrayList<>();

        while(!left.isEmpty() && !right.isEmpty()){
            if(left.get(0)<right.get(0)){
                list.add(left.get(0));
                left.remove(0);
            }
            else{
                list.add(right.get(0));
                right.remove(0);
            }
        }

        if(!left.isEmpty())
            list.addAll(left);
        if(!right.isEmpty())
            list.addAll(right);

        return list;
    }

    public static void print(List<Integer> list){
        list.forEach((Integer)-> System.out.print(Integer + ", "));
        System.out.print("\b" + "\b" + " ");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
