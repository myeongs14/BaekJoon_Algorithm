import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String op = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");

            boolean chk = true;
            boolean isEmpty = false;
            for (int j = 0; j < count; j++)
                deque.addLast(Integer.parseInt(arr[j]));
            loop:
            for (int j = 0; j < op.length(); j++) {
                switch (op.charAt(j)) {
                    case 'R':
                        if (chk == true) chk = false;
                        else chk = true;
                        break;
                    case 'D':
                        if (deque.isEmpty() == false) {
                            if (chk)
                                deque.pollFirst();
                            else
                                deque.pollLast();
                        } else {
                            isEmpty = true;
                            break loop;
                        }
                        count--;
                        break;
                }
            }
            if (isEmpty) {
                bw.write("error");
                bw.newLine();
            } else {
                StringBuilder str = new StringBuilder();
                if (count == 0)
                    str.append("[]");
                else {
                    str.append("[");
                    if (chk == true) {
                        for (int k = 0; k < count - 1; k++) {
                            str.append(deque.pollFirst() + ",");

                        }
                        str.append(deque.pollFirst());
                    } else {
                        for (int k = 0; k < count - 1; k++) {
                            str.append(deque.pollLast() + ",");
                        }
                        str.append(deque.pollLast());
                    }
                    str.append("]");
                }
                bw.write(String.valueOf(str));
                bw.newLine();
            }
        }
        br.close();
        bw.close();
    }
}
