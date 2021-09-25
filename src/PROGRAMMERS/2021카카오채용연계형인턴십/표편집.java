import java.util.Stack;

public class 표편집 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        
        // 삭제되지 않은 행은 O, 삭제된 행은 X
        System.out.println(solution(n, k, cmd));
      }
    
    /*
    * LinkedList : 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식의 자료구조
    * 데이터 추가 삭제 시 주위의 노드에 영향이 없기 때문에 추가 삭제가 많을 시 사용, 정렬은 arrayList
    */
    public static String solution(int n, int k, String[] cmd) {
        Node[] nodeArr = new Node[1000000];
        
        // 각자 위치에 노드 생성
        for(int i = 0; i < n; i++){
            nodeArr[i] = new Node();
        }
        
        // 노드의 head와 tail 연결
        for(int i = 0; i < n - 1; i++) {
            nodeArr[i].next = nodeArr[i+1];
            nodeArr[i + 1].prev = nodeArr[i];
        }
        
        // 삭제된 열 저장. 최근 삭제된 것을 꺼내와야하기 때문에 stack 사용
        Stack<Node> removeStack = new Stack<>();
        Node nowNode = nodeArr[k];
        
        for(String s : cmd) {
            char c = s.charAt(0);
            switch(c) {
                case 'U' :
                    int num = Integer.parseInt(s.substring(2));
                    for(int i = 0; i < num; i++)
                        nowNode = nowNode.prev;
                    break;
                case 'D' :
                    num = Integer.parseInt(s.substring(2));
                    for(int i = 0; i < num; i++)
                        nowNode = nowNode.next;
                    break;
                case 'C' :
                    nowNode.removed = true;
                    removeStack.push(nowNode);

                    Node up = nowNode.prev; //prev가 위
                    Node down = nowNode.next; // next가 아래
                    
                    // 위 노드가 있다면 이전노드의 next를 현재노드의 다음노드랑 연결
                    if(up != null)
                        up.next = down;
                    
                    // 아래 노드가 있다면 아래노드의 위를 현재노드의 위랑 연결
                    if(down != null) {
                        down.prev = up;
                        nowNode = down;
                    } else {
                        nowNode = up;
                    }
                    break;
                case 'Z' :
                    Node recover = removeStack.pop();
                    up = recover.prev;
                    down = recover.next;
                    
                    recover.removed = false;
                    if(up != null) {
                        up.next = recover;
                    }
                    
                    if(down != null) {
                        down.prev = recover;
                    }
                    break;
            }
        }   
    
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(nodeArr[i].removed)
                sb.append("X");
            else
                sb.append("O");
        }
    
        return sb.toString();
    }
}

class Node {
    boolean removed;
    Node prev;
    Node next;
}
