package ok.lab.com;

import java.util.HashMap;

public class CLinkedList {
    HashMap<Character, Integer> map = new HashMap<>();
    MyLinkedList list = new MyLinkedList();
    char r;
    public CLinkedList(int[] a, char[] b) {
        r = b[0];
        int acc = 0;
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(b[i])) {
                return;
            }
            map.put(b[i],  acc);
                MyLinkedList.Node node = new MyLinkedList.Node();
                node.next = null;
                node.data = b[i];
                list.add(node, list.numberOfElements);
                    acc += a[i];
            }
            map.put(b[0],  acc);
        }
    public int getDistance(char element1, char element2) {
        if(map.get(element1) > map.get(element2)){
            return map.get(r) - map.get(element1) + map.get(element2);
        }
        else {
            return map.get(element2) -  map.get(element1);
        }
    }
}
